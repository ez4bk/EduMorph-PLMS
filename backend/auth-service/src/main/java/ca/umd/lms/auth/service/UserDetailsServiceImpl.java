package ca.umd.lms.auth.service;

import ca.umd.lms.auth.mapper.UserMapper;
import ca.umd.lms.auth.model.User;
import ca.umd.lms.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

//UserDetailsServiceImpl class serves as a custom implementation of the Spring Security UserDetailsService. 
//It retrieves user details based on the username from a data repository, converts the user entity to a DTO using a mapper, and returns the user details for authentication purposes.
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return mapper.toDTO(user.get());
    }
}
