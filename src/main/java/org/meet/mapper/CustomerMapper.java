package org.meet.mapper;

import org.meet.model.dto.CustomerDTO;
import org.meet.model.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Customer toEntity(CustomerDTO customerDTO) {
        return this.modelMapper.map(customerDTO, Customer.class);
    }

    public CustomerDTO toDto(Customer customer) {
        return this.modelMapper.map(customer, CustomerDTO.class);
    }
}
