package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.RequestCustomerdto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerPaginateDto;
import com.devstack.ecom.upscale.entity.Customer;
import com.devstack.ecom.upscale.repo.CustomerRepo;
import com.devstack.ecom.upscale.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public void update(String id, RequestCustomerdto dto) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new RuntimeException("Customer not found");
        }
        Customer customer = selectedCustomer.get();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setActive(dto.isActive());

        customerRepo.save(customer);
    }

    @Override
    public CustomerPaginateDto findAll(String searchText, int page, int size) {
        return CustomerPaginateDto.builder()
                .dataList(customerRepo.findAllWithSearchText(searchText, PageRequest.of(page,size)).stream().map(this::toResponseCustomerDto).toList())
                .count(
                        customerRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
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
