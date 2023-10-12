package ca.umd.lms.auth.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ca.umd.lms.auth.mapper.RoleMapper;
import ca.umd.lms.auth.model.Role;
import ca.umd.lms.auth.repository.RoleRepository;
import ca.utoronto.lms.shared.dto.RoleDTO;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private RoleRepository repository;

    @Mock
    private RoleMapper mapper;

    @InjectMocks
    private RoleService service;

    @Test
    void testSave() {
        // Given
        RoleDTO dto = new RoleDTO();
        dto.setId(1L);
        Role role = new Role();
        role.setId(dto.getId());

        when(mapper.toModel(dto)).thenReturn(role);
        when(repository.save(role)).thenReturn(role);

        // When
        RoleDTO savedDto = service.save(dto);

        // Then
        assertEquals(dto.getId(), savedDto.getId());
    }
}
// ```