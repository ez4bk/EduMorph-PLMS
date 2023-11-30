package ca.umd.lms.faculty.service;

import ca.umd.lms.faculty.client.SubjectFeignClient;
import ca.umd.lms.faculty.client.UserFeignClient;
import ca.umd.lms.faculty.dto.StudentDTO;
import ca.umd.lms.faculty.mapper.StudentMapper;
import ca.umd.lms.faculty.model.Student;
import ca.umd.lms.faculty.repository.StudentRepository;
import ca.utoronto.lms.shared.dto.RoleDTO;
import ca.utoronto.lms.shared.dto.UserDTO;
import ca.utoronto.lms.shared.dto.UserDetailsDTO;
import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class StudentService extends ExtendedService<Student, StudentDTO, Long> {
    private final StudentRepository repository;
    private final StudentMapper mapper;
    private final ThesisService thesisService;
    private final UserFeignClient userFeignClient;
    private final SubjectFeignClient subjectFeignClient;

    public StudentService(
            StudentRepository repository,
            StudentMapper mapper,
            ThesisService thesisService,
            UserFeignClient userFeignClient,
            SubjectFeignClient subjectFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.thesisService = thesisService;
        this.userFeignClient = userFeignClient;
        this.subjectFeignClient = subjectFeignClient;
    }


    //overrides the findById method from the superclass (ExtendedService). It checks whether the user has the authority of a student and restricts access 
    //if they try to view multiple students or a student other than themselves.


    @Override
    public List<StudentDTO> findById(Set<Long> id) {
        if (hasAuthority(ROLE_STUDENT) && (id.size() > 1 || !id.contains(getStudentId()))) {
            throw new ForbiddenException("You are not allowed to view these students");
        }

        return super.findById(id);
    }

    @Override
    @Transactional

    // overrides the save method from the superclass. It is responsible for saving a student. 
    //Before saving, it checks whether the associated user already exists. If not, it creates a new user using the UserFeignClient. If the user already exists, 
    //it updates the user using the patchUser method. The resulting user information is then set in the student object, and the student is saved.
    public StudentDTO save(StudentDTO student) {
        UserDTO userRequest = student.getUser();
        UserDTO userResponse =
                userRequest.getId() == null
                        ? userFeignClient.createUser(
                                UserDetailsDTO.builder()
                                        .username(userRequest.getUsername())
                                        .password(userRequest.getPassword())
                                        .authorities(
                                                Set.of(
                                                        RoleDTO.builder()
                                                                .id(ROLE_STUDENT_ID)
                                                                .authority(ROLE_STUDENT)
                                                                .build()))
                                        .build())
                        : userFeignClient.patchUser(userRequest.getId(), userRequest);
        student.setUser(userResponse);
        return super.save(student);
    }

    @Override
    @Transactional
    //overrides the delete method from the superclass. It is responsible for deleting students. 
    //It retrieves the user IDs associated with the students, deletes those users using the deleteUser method from the UserFeignClient, 
    //and then performs a soft delete of the students using the softDeleteByIds method from the repository.
    public void delete(Set<Long> id) {
        List<Student> students = (List<Student>) repository.findAllById(id);
        Set<Long> userIds = students.stream().map(Student::getUserId).collect(Collectors.toSet());
        userFeignClient.deleteUser(userIds);
        repository.softDeleteByIds(id);
    }

    @Override
    //overrides the mapMissingValues method from the superclass. It is responsible for mapping missing values in a list of StudentDTO objects. 
    //It uses the UserFeignClient to fetch missing details related to users for each student.
    protected List<StudentDTO> mapMissingValues(List<StudentDTO> students) {
        map(students, StudentDTO::getUser, StudentDTO::setUser, userFeignClient::getUser);
        return students;
    }


    //retrieves a student based on the associated user ID. If the student is not found, it throws a NotFoundException. Otherwise, it converts the student to a DTO using the mapper.
    public StudentDTO findByUserId(Long userId) {
        Student student =
                repository
                        .findByUserId(userId)
                        .orElseThrow(() -> new NotFoundException("User id not found"));
        return mapper.toDTO(student);
    }


    //retrieves the ID of a student based on the associated user ID. If the student is not found, it throws a NotFoundException.
    public Long findIdByUserId(Long userId) {
        return repository
                .findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("User id not found"))
                .getId();
    }

    public List<StudentDTO> findBySubjectId(Long id) {
        //uses subjectFeignClient.getStudentIdsBySubjectId(id) to obtain a set of student IDs associated with a given subject ID.
        Set<Long> studentIds = new HashSet<>(subjectFeignClient.getStudentIdsBySubjectId(id));
        List<StudentDTO> students = mapper.toDTO(repository.findByIdInAndDeletedFalse(studentIds));
        return students.isEmpty() ? students : mapMissingValues(students);
    }


    // it retrieves a set of student IDs associated with a given subject ID.
    public Page<StudentDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        Set<Long> studentIds = new HashSet<>(subjectFeignClient.getStudentIdsBySubjectId(id));
        Page<StudentDTO> students =
                repository
                        .findByIdContaining(studentIds, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return students.getContent().isEmpty()
                ? students
                : new PageImpl<>(
                        this.mapMissingValues(students.getContent()),
                        pageable,
                        students.getTotalElements());
    }
//Retrieves the thesis ID associated with a student by calling the findByStudentId method on the thesisService.

Returns the ID of the found thesis.
    public Long findThesisId(Long id) {
        return this.thesisService.findByStudentId(id).getId();
    }
}
