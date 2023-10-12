package ca.umd.lms.faculty.controller;

import ca.umd.lms.faculty.dto.AddressDTO;
import ca.umd.lms.faculty.model.Address;
import ca.umd.lms.faculty.service.AddressService;
import ca.utoronto.lms.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController<Address, AddressDTO, Long> {
    private final AddressService service;

    public AddressController(AddressService service) {
        super(service);
        this.service = service;
    }
}
