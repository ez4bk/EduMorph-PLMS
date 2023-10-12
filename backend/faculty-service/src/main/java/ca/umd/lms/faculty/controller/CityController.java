package ca.umd.lms.faculty.controller;

import ca.umd.lms.faculty.dto.CityDTO;
import ca.umd.lms.faculty.model.City;
import ca.umd.lms.faculty.service.CityService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController extends BaseController<City, CityDTO, Long> {
    private final CityService service;

    public CityController(CityService service) {
        super(service);
        this.service = service;
    }
}
