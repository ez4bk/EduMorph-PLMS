package ca.umd.lms.auth.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.List;

import ca.umd.lms.auth.dto.TokensDTO;
import ca.umd.lms.auth.model.User;
import ca.umd.lms.auth.repository.UserRepository;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUsername("test");
        userDetailsDTO.setPassword("test");

        UserDetailsDTO savedUserDetailsDTO = userService.save(userDetailsDTO);

        assertNotNull(savedUserDetailsDTO);
        assertEquals(userDetailsDTO.getUsername(), savedUserDetailsDTO.getUsername());
        assertTrue(savedUserDetailsDTO.isEnabled());
    }

    @Test
    public void testUpdate() {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUsername("test");
        userDetailsDTO.setPassword("test");

        UserDetailsDTO savedUserDetailsDTO = userService.save(userDetailsDTO);

        UserDetailsDTO userDetailsDTODummy = new UserDetailsDTO();
        userDetailsDTO.setId(userDetailsDTO.getId());
        userDetailsDTODummy.setUsername("test2");
        userDetailsDTODummy.setPassword("test2");

        UserDetailsDTO updatedUserDetailsDTO = userService.update(userDetailsDTO);

        assertNotNull(updatedUserDetailsDTO);
        assertEquals(userDetailsDTO.getUsername(), updatedUserDetailsDTO.getUsername());
    }

    @Test
    public void testFindByIdPublic() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userRepository.save(user);

        Set<Long> id = Set.of(user.getId());

        List<UserDTO> userDTOs = userService.findByIdPublic(id);

        assertNotNull(userDTOs);
        assertEquals(1, userDTOs.size());
    }

    @Test
    public void testFindByUsername() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userRepository.save(user);

        UserDetailsDTO userDetailsDTO = userService.findByUsername("test");

        assertNotNull(userDetailsDTO);
        assertEquals(user.getUsername(), userDetailsDTO.getUsername());
    }

    @Test
    public void testFindIdByUsername() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userRepository.save(user);

        Long id = userService.findIdByUsername("test");

        assertNotNull(id);
        assertEquals(user.getId(), id);
    }

    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("test");
        userDTO.setPassword("test");

        TokensDTO tokensDTO = userService.login(userDTO);

        assertNotNull(tokensDTO);
        assertNotNull(tokensDTO.getAccessToken());
        assertNotNull(tokensDTO.getRefreshToken());
    }

    @Test
    public void testRefresh() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userRepository.save(user);

        String refreshToken = userService.login(new UserDTO(user.getUsername(), user.getPassword())).getRefreshToken();

        TokensDTO tokensDTO = userService.refresh(refreshToken);

        assertNotNull(tokensDTO);
        assertNotNull(tokensDTO.getAccessToken());
        assertNotNull(tokensDTO.getRefreshToken());
    }
}
// ```