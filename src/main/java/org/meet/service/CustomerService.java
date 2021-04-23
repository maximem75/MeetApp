package org.meet.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.meet.enums.ECustomerState;
import org.meet.mapper.CustomerMapper;
import org.meet.model.dto.CustomerDTO;
import org.meet.model.entity.Customer;
import org.meet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    //private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerService(
            //CustomerRepository customerRepository,
            CustomerMapper customerMapper
    ) {
        //this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public Iterable<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    public CustomerDTO save(@NonNull CustomerDTO customerDTO) {
        log.info("Save customer {}", customerDTO);

        Customer customer = this.customerMapper.toEntity(customerDTO);
        customer.setState(ECustomerState.CREATED);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        Customer saved = this.customerRepository.save(customer);
        return this.customerMapper.toDto(saved);
    }
}
