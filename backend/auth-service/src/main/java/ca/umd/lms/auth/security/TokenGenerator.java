package ca.umd.lms.auth.security;

import ca.umd.lms.auth.client.FacultyFeignClient;
import ca.umd.lms.auth.model.User;
import ca.umd.lms.auth.repository.UserRepository;
import ca.utoronto.lms.shared.exception.BadRequestException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.security.TokenUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Component
@RequiredArgsConstructor
public class TokenGenerator {//TokenGenerator class encapsulates the logic for generating and refreshing access 
//and refresh tokens based on user authentication. 
    private final UserRepository userRepository;
    private final FacultyFeignClient facultyFeignClient;
    private final TokenUtils tokenUtils;

    @Value("${token.secret}")
    private String secret;

    @Value("${token.accessExpiration}")
    private Long accessExpiration;

    @Value("${token.refreshExpiration}")
    private Long refreshExpiration;

    public String refreshAccessToken(String refreshToken) {
        String username = tokenUtils.getUsername(refreshToken);
        if (username == null) {
            throw new AuthenticationException("Refresh token isn't valid!") {};
        }
        return generateAccessToken(username);
    }
    //This method generates an access token using the provided username. It builds the token using the Jwts builder, including claims like subject, issuance time, expiration time, and user-related information.
    // The token is then signed using the specified algorithm and secret key.
    public String generateAccessToken(String username) {
        Map<String, Object> claims = generateClaims(username);
        return Jwts.builder()
                .setClaims(claims) // It has to be first because it overwrites the rest
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + accessExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateRefreshToken(String username) {
        validateUser(username);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    //This private method generates claims for the token based on the provided username. 
    //It includes information such as the user's ID, roles (authorities), and additional data depending on the user's roles (admin, teacher, or student).
    private Map<String, Object> generateClaims(String username) {
        Map<String, Object> claims = new HashMap<>();

        User user = validateUser(username);
        Long userId = user.getId();
        claims.put("userId", userId);

        List<String> authorities =
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        claims.put("roles", authorities);

        if (authorities.contains(ROLE_ADMIN)) {
            claims.put("adminId", facultyFeignClient.getAdministratorIdByUserId(userId));
        } else if (authorities.contains(ROLE_TEACHER)) {
            claims.put("teacherId", facultyFeignClient.getTeacherIdByUserId(userId));
        } else if (authorities.contains(ROLE_STUDENT)) {
            claims.put("studentId", facultyFeignClient.getStudentIdByUserId(userId));
        }

        return claims;
    }
    //This private method validates a user based on the provided username. It retrieves the user from the UserRepository and checks if the user exists and is not deleted.
    // If the user is not found or is deleted, exceptions (NotFoundException or BadRequestException) are thrown.
    private User validateUser(String username) {
        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new NotFoundException("User not found"));
        if (user.isDeleted()) {
            throw new BadRequestException("User is deleted");
        }
        return user;
    }
}
