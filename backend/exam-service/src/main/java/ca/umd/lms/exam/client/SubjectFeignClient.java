package ca.umd.lms.exam.client;

import ca.umd.lms.exam.dto.SubjectDTO;
import ca.umd.lms.exam.dto.SubjectEnrollmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;
//provides a declarative way to make HTTP requests to the "subject-service" in a Spring Cloud environment.
// It defines methods corresponding to different endpoints in the target service, specifying the HTTP methods, paths, and expected response types.
// This allows for a more concise and readable way of interacting with remote services compared to using RestTemplate or other HTTP client libraries.
@FeignClient("subject-service")
public interface SubjectFeignClient {
    @GetMapping("/subjects/{id}")
    List<SubjectDTO> getSubject(@PathVariable Set<Long> id);

    @GetMapping("/subjects/teacher/{id}/all")
    List<SubjectDTO> getSubjectByTeacherId(@PathVariable Long id);

    @GetMapping("/subjects/student/{id}/all")
    List<SubjectDTO> getSubjectByStudentId(@PathVariable Long id);

    @GetMapping("/subject-enrollments/{id}")
    List<SubjectEnrollmentDTO> getSubjectEnrollment(@PathVariable Set<Long> id);

    @GetMapping("/subject-enrollments/student/{id}/all")
    List<SubjectEnrollmentDTO> getSubjectEnrollmentByStudentId(@PathVariable Long id);
}
