package ca.umd.lms.faculty.controller;

import ca.umd.lms.faculty.dto.CountryDTO;
import ca.umd.lms.faculty.model.Country;
import ca.umd.lms.faculty.service.CountryService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController extends BaseController<Country, CountryDTO, Long> {
    private final CountryService service;

    public CountryController(CountryService service) {
        super(service);
        this.service = service;
    }
}
