package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.RequestCustomerdto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerDto;

public interface CustomerService {
    public void create(RequestCustomerdto dto);
    public ResponseCustomerDto findById(String id);
}



