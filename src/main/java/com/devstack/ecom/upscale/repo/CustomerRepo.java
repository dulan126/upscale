package com.devstack.ecom.upscale.repo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<entity.Customer, String> {


}
