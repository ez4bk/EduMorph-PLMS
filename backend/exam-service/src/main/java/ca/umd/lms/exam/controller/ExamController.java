package ca.umd.lms.exam.controller;

import ca.umd.lms.exam.dto.ExamDTO;
import ca.umd.lms.exam.model.Exam;
import ca.umd.lms.exam.service.ExamService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
////These annotations define the class as a REST controller, and all the request mappings within this controller are relative to the base path "/exams."
@RestController
@RequestMapping("/exams")
public class ExamController extends BaseController<Exam, ExamDTO, Long> {
    private final ExamService service;
    //The constructor initializes the controller with an instance of ExamService. The BaseController constructor is invoked with the service, setting it as the service used for handling exam-related operations.
    public ExamController(ExamService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/subject/{id}/all")
    // maps the method to handle HTTP GET requests with the path "/exams/subject/{id}/all". The {id} is a path variable that represents the subject ID.
    public ResponseEntity<List<ExamDTO>> getBySubjectId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findBySubjectId(id), HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    //This method retrieves a list of ExamDTO objects related to a specific subject ID. It uses the ExamService to fetch the data and returns it in the response body with an HTTP status of OK (200).
    public ResponseEntity<Page<ExamDTO>> getBySubjectId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(service.findBySubjectId(id, pageable, search), HttpStatus.OK);
    }
}
