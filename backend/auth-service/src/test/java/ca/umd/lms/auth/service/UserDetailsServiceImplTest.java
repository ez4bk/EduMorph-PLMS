package ca.umd.lms.auth.service;

import ca.umd.lms.auth.mapper.UserMapper;
import ca.umd.lms.auth.model.User;
import ca.umd.lms.auth.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.util.Optionals;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @InjectMocks
    private UserDetailsServiceImpl service;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        // Arrange
        String username = "test";
        User user = new User();
        user.setUsername(username);
        user.setPassword("password");

        when(repository.findByUsername(username)).thenReturn(Optional.of(user));

        // Act
        UserDetails details = service.loadUserByUsername(username);

        // Assert
        assertEquals(username, details.getUsername());
        assertEquals("password", details.getPassword());
    }

    @Test
    void testLoadUserByUsernameNotFound() {
        // Arrange
        String username = "test";

        when(repository.findByUsername(username)).thenReturn(Optional.empty());

        // Act
        assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername(username));
    }
}
