package ca.umd.lms.exam.controller;

import ca.umd.lms.exam.dto.ExamTypeDTO;
import ca.umd.lms.exam.model.ExamType;
import ca.umd.lms.exam.service.ExamTypeService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam-types")
public class ExamTypeController extends BaseController<ExamType, ExamTypeDTO, Long> {
    private final ExamTypeService service;

    public ExamTypeController(ExamTypeService service) {
        super(service);
        this.service = service;
    }
}
