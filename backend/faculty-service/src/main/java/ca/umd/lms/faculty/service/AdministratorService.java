package ca.umd.lms.faculty.service;

import ca.umd.lms.faculty.client.UserFeignClient;
import ca.umd.lms.faculty.dto.AdministratorDTO;
import ca.umd.lms.faculty.mapper.AdministratorMapper;
import ca.umd.lms.faculty.model.Administrator;
import ca.umd.lms.faculty.repository.AdministratorRepository;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ca.utoronto.lms.shared.security.SecurityUtils.ROLE_ADMIN;
import static ca.utoronto.lms.shared.security.SecurityUtils.ROLE_ADMIN_ID;

@Service
//
public class AdministratorService extends ExtendedService<Administrator, AdministratorDTO, Long> {
    private final AdministratorRepository repository;
    private final AdministratorMapper mapper;
    private final UserFeignClient userFeignClient;

    public AdministratorService(
            AdministratorRepository repository,
            AdministratorMapper mapper,
            UserFeignClient userFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.userFeignClient = userFeignClient;
    }

    @Override
    @Transactional
    //save method from the superclass (ExtendedService). It is responsible for saving an administrator. Before saving, 
    //it checks whether the associated user already exists. If not, it creates a new user using the UserFeignClient. 
    //If the user already exists, it updates the user using the patchUser method. The resulting user information is then set in the administrator object, and the administrator is saved.
    public AdministratorDTO save(AdministratorDTO administrator) {
        UserDTO userRequest = administrator.getUser();
        UserDTO userResponse =
                userRequest.getId() == null
                        ? userFeignClient.createUser(
                                UserDetailsDTO.builder()
                                        .username(userRequest.getUsername())
                                        .password(userRequest.getPassword())
                                        .authorities(
                                                Set.of(
                                                        RoleDTO.builder()
                                                                .id(ROLE_ADMIN_ID)
                                                                .authority(ROLE_ADMIN)
                                                                .build()))
                                        .build())
                        : userFeignClient.patchUser(userRequest.getId(), userRequest);
        administrator.setUser(userResponse);
        return super.save(administrator);
    }

    @Override
    @Transactional
    // overrides the delete method from the superclass. It is responsible for deleting administrators. 
    //It retrieves the user IDs associated with the administrators, 
    //deletes those users using the deleteUser method from the UserFeignClient, and then performs a soft delete of the administrators using the softDeleteByIds method from the repository.
    public void delete(Set<Long> id) {
        List<Administrator> administrators = (List<Administrator>) repository.findAllById(id);
        Set<Long> userIds =
                administrators.stream().map(Administrator::getUserId).collect(Collectors.toSet());
        userFeignClient.deleteUser(userIds);
        repository.softDeleteByIds(id);
    }

    @Override
    // overrides the mapMissingValues method from the superclass. It is responsible for mapping missing values in a list of AdministratorDTO objects. It uses the UserFeignClient to fetch missing details related to users for each administrator.
    protected List<AdministratorDTO> mapMissingValues(List<AdministratorDTO> administrators) {
        map(
                administrators,
                AdministratorDTO::getUser,
                AdministratorDTO::setUser,
                userFeignClient::getUser);

        return administrators;
    }


//retrieves an administrator based on the associated user ID. If the administrator is not found, it throws a NotFoundException. Otherwise, it converts the administrator to a DTO using the mapper.
    public AdministratorDTO findByUserId(Long userId) {
        Administrator administrator =
                repository
                        .findByUserId(userId)
                        .orElseThrow(() -> new NotFoundException("User id not found"));
        return mapper.toDTO(administrator);
    }
}
