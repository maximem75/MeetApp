package org.meet.controller;

import io.swagger.annotations.ApiOperation;
import org.meet.model.dto.CustomerDTO;
import org.meet.model.entity.Customer;
import org.meet.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("Find all customers")
    @GetMapping("/all")
    public ResponseEntity<Iterable<Customer>> getAll() {
        return ResponseEntity.ok(this.customerService.findAll());
    }

    @ApiOperation("Save new customer")
    @PostMapping
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customerDTO) {
        log.info("[CONTROLLER] CustomerController : save(@RequestBody CustomerDTO customerDTO) : {}", customerDTO);
        return ResponseEntity.ok(this.customerService.save(customerDTO));
    }
}