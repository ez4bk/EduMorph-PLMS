package ca.umd.lms.exam.controller;

import ca.umd.lms.exam.dto.ExamTermDTO;
import ca.umd.lms.exam.model.ExamTerm;
import ca.umd.lms.exam.service.ExamTermService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam-terms")
public class ExamTermController extends BaseController<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermService service;

    public ExamTermController(ExamTermService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}/all")
    //handles HTTP GET requests with the path "/exam-terms/subject/{id}/all". It retrieves a list of ExamTermDTO objects related to a specific subject ID. 
    //The service.findBySubjectId(id) method is used to fetch the data
    public ResponseEntity<List<ExamTermDTO>> getBySubjectId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}/all")
    //handles HTTP GET requests with the path "/exam-terms/teacher/{id}/all". It retrieves a list of ExamTermDTO objects related to a specific teacher ID. 
    //The service.findByTeacherId(id) method is used to fetch the data.
    public ResponseEntity<List<ExamTermDTO>> getByTeacherId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByTeacherId(id), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    //handles HTTP GET requests with the path "/exam-terms/student/{id}". It retrieves a paginated list of ExamTermDTO objects related to a specific student ID. 
    //The service.findByStudentId(id, pageable, search) method is used to fetch the data.
    public ResponseEntity<Page<ExamTermDTO>> getByStudentId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(service.findByStudentId(id, pageable, search), HttpStatus.OK);
    }
}
