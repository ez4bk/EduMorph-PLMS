package ca.umd.lms.exam.controller;

import ca.umd.lms.exam.dto.ExamRealizationDTO;
import ca.umd.lms.exam.model.ExamRealization;
import ca.umd.lms.exam.service.ExamRealizationService;
import ca.umd.lms.exam.util.ExamRealizationPDFExporter;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/exam-realizations")
public class ExamRealizationController
        extends BaseController<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationService service;
    private final ExamRealizationPDFExporter pdfExporter;

    public ExamRealizationController(
//initializes the controller with an instance of ExamRealizationService and ExamRealizationPDFExporter. 
//The BaseController constructor is invoked with the service, setting it as the service used for handling exam realization-related operations. 
//The pdfExporter field is also assigned to hold a reference to the ExamRealizationPDFExporter, which is likely responsible for exporting exam realizations to a PDF file.
            ExamRealizationService service, ExamRealizationPDFExporter pdfExporter) {
        super(service);
        this.service = service;
        this.pdfExporter = pdfExporter;
    }

    @GetMapping("/exam-term/{id}")
    //handles HTTP GET requests with the path "/exam-realizations/exam-term/{id}". It retrieves a paginated list of ExamRealizationDTO objects related to a specific exam term ID. 
    //The service.findByExamTermId(id, pageable, search) method is used to fetch the data.

    public ResponseEntity<Page<ExamRealizationDTO>> getByExamTermId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(service.findByExamTermId(id, pageable, search), HttpStatus.OK);
    }

    @GetMapping("/exam-term/{id}/all/pdf")
    //handles HTTP GET requests with the path "/exam-realizations/exam-term/{id}/all/pdf". It exports a list of ExamRealizationDTO objects related to a specific exam term ID to a PDF file. 
    //The pdfExporter.export(examRealizations, response) method is used to perform the PDF export.
    public void getByExamTermIdPdf(@PathVariable Long id, HttpServletResponse response)
            throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=exam-realizations.pdf");
        List<ExamRealizationDTO> examRealizations = service.findByExamTermId(id);
        pdfExporter.export(examRealizations, response);
    }

    @GetMapping("/student/{id}")
    //handles HTTP GET requests with the path "/exam-realizations/student/{id}". It retrieves a paginated list of ExamRealizationDTO 
    //objects related to a specific student ID. The service.findByStudentId(id, pageable, search) method is used to fetch the data.
    public ResponseEntity<Page<ExamRealizationDTO>> getByStudentId(
            @PathVariable Long id,
            Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return new ResponseEntity<>(service.findByStudentId(id, pageable, search), HttpStatus.OK);
    }

    @PostMapping("/exam-term/{id}")
    public ResponseEntity<List<ExamRealizationDTO>> createByExamTermId(
            @PathVariable Set<Long> examTermIds) {
        return new ResponseEntity<>(service.createByExamTermId(examTermIds), HttpStatus.CREATED);

        //service.createByExamTermId(examTermIds) method is used to perform the creation.
    }

    @PatchMapping("/{id}/score")
    // handles HTTP PATCH requests with the path "/exam-realizations/{id}/score". It updates the score of a specific exam realization. The service.updateScore(id, examRealizationDTO) method is used for the update.
    public ResponseEntity<ExamRealizationDTO> updateScore(
            @PathVariable Long id, @RequestBody ExamRealizationDTO examRealizationDTO) {
        return new ResponseEntity<>(
                this.service.updateScore(id, examRealizationDTO), HttpStatus.OK);
    }

    @PatchMapping("/exam-term/{id}/score")
    // handles HTTP PATCH requests with the path "/exam-realizations/exam-term/{id}/score". It updates the scores of multiple exam realizations related to a specific exam term ID. 
    //The service.updateScoresByExamTermId(id, examRealizations) method is used for the update.
    public ResponseEntity<List<ExamRealizationDTO>> updateScoresByExamTermId(
            @PathVariable Long id, @RequestBody List<ExamRealizationDTO> examRealizations) {
        return new ResponseEntity<>(
                service.updateScoresByExamTermId(id, examRealizations), HttpStatus.OK);
    }
}
