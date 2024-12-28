package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.RequestCustomerdto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerDto;
import com.devstack.ecom.upscale.entity.Customer;
import com.devstack.ecom.upscale.repo.CustomerRepo;
import com.devstack.ecom.upscale.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;


    @Override
    public void create(RequestCustomerdto dto) {
        System.out.println(dto.isActive());
        Customer customer = Customer.builder()
                .propertyId(UUID.randomUUID().toString())
                .name(dto.getName())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .isActive(dto.isActive())
                .build();
        customerRepo.save(customer);
    }

    @Override
    public ResponseCustomerDto findById(String id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new RuntimeException("Customer not found");
        }
        return toResponseCustomerDto(selectedCustomer.get());
    }

    private ResponseCustomerDto toResponseCustomerDto(Customer customer) {
        return ResponseCustomerDto.builder()
                .propertyId(customer.getPropertyId())
                .address(customer.getAddress())
                .name(customer.getName())
                .phone(customer.getPhone())
                .isActive(customer.isActive())
                .email(customer.getEmail())
                .build();

    }
}
