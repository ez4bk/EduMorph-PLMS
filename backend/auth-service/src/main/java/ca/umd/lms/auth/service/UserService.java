package ca.umd.lms.auth.service;

import ca.umd.lms.auth.dto.TokensDTO;
import ca.umd.lms.auth.mapper.UserMapper;
import ca.umd.lms.auth.model.User;
import ca.umd.lms.auth.repository.UserRepository;
import ca.umd.lms.auth.security.TokenGenerator;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class UserService extends BaseService<User, UserDetailsDTO, Long> {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserDetailsService userDetailsService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserService(//The constructor is used for dependency injection, initializing the UserService with instances of various components required for user management.
    // These components include a UserRepository for data access, a UserMapper for mapping between entities and DTOs, 
    //a UserDetailsService for retrieving user details, a TokenGenerator for handling tokens,
    // AuthenticationManager for user authentication, and PasswordEncoder for encoding passwords.
            UserRepository repository,
            UserMapper mapper,
            UserDetailsService userDetailsService,
            TokenGenerator tokenGenerator,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.userDetailsService = userDetailsService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional//This method overrides the save method from the superclass BaseService.
    // It is annotated with @Transactional, indicating that the method is transactional.
    // It encodes the user's password, sets various account-related flags, and then delegates the saving operation to the superclass.
    public UserDetailsDTO save(UserDetailsDTO userDetailsDTO) {
        userDetailsDTO.setPassword(passwordEncoder.encode(userDetailsDTO.getPassword()));
        userDetailsDTO.setAccountNonExpired(true);
        userDetailsDTO.setAccountNonLocked(true);
        userDetailsDTO.setCredentialsNonExpired(true);
        userDetailsDTO.setEnabled(true);
        return super.save(userDetailsDTO);
    }

    @Transactional//This method updates an existing user based on the information provided in the UserDetailsDTO. 
    //It retrieves the existing user, modifies the username and password if provided, 
    //saves the changes, and returns the updated user details.
    public UserDetailsDTO update(UserDetailsDTO userDetailsDTO) {
        User existingUser =
                repository
                        .findById(userDetailsDTO.getId())
                        .orElseThrow(() -> new NotFoundException("User not found"));
        if (userDetailsDTO.getUsername() != null) {
            existingUser.setUsername(userDetailsDTO.getUsername());
        }
        if (userDetailsDTO.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(userDetailsDTO.getPassword()));
        }

        return this.mapper.toDTO(this.repository.save(existingUser));
    }
    //This method retrieves a list of users by their IDs. 
    //If the list is empty, indicating that no users were found, a NotFoundException is thrown. 
    //It then maps the list of User entities to a list of UserDTO using the UserMapper
    public List<UserDTO> findByIdPublic(Set<Long> id) {
        List<User> users = (List<User>) this.repository.findAllById(id);
        if (users.isEmpty()) {
            throw new NotFoundException("User id missing");
        }
        return this.mapper.userToUserDTOList(users);
    }
    //This method retrieves user details by username. It performs authorization checks to ensure that the caller has the necessary authority (ROLE_ADMIN) or is accessing their own details. 
    //It then delegates the operation to the UserDetailsService.

    public UserDetailsDTO findByUsername(String username) throws UsernameNotFoundException {
        if (!getUsername().equals(username) && !hasAuthority(ROLE_ADMIN)) {
            throw new ForbiddenException("You are not allowed to view this user's details");
        }

        return (UserDetailsDTO) userDetailsService.loadUserByUsername(username);
    }

    //This method retrieves the ID of a user by their username. If the username is not found, a NotFoundException is thrown.
    public Long findIdByUsername(String username) {
        return this.repository
                .findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Username not found"))
                .getId();
    }


    //This method handles user login. It creates a UsernamePasswordAuthenticationToken with the provided username and password, 
    //authenticates the token using the AuthenticationManager, sets the authentication in the SecurityContextHolder, 
    //and generates access and refresh tokens using the TokenGenerator.
    public TokensDTO login(UserDTO userDTO) {
       UsernamePasswordAuthenticationToken token =
               new UsernamePasswordAuthenticationToken(
                       userDTO.getUsername(), userDTO.getPassword());
        
       String encoString = passwordEncoder.encode(userDTO.getPassword());
       Authentication authentication = authenticationManager.authenticate(token);
       SecurityContextHolder.getContext().setAuthentication(authentication);
        String username = userDTO.getUsername();
        return new TokensDTO(
                tokenGenerator.generateAccessToken(username),
                tokenGenerator.generateRefreshToken(username));
    }
    //This method handles token refresh. It extracts the token from the "Bearer" prefix, 
    //refreshes the access token using the TokenGenerator, and returns a new set of tokens
    public TokensDTO refresh(String refreshToken) {
        refreshToken = refreshToken.substring(BEARER_PREFIX.length());
        return new TokensDTO(tokenGenerator.refreshAccessToken(refreshToken), refreshToken);
    }
}
