package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.RequestCustomerdto;
import com.devstack.ecom.upscale.service.CustomerService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping()
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerdto dto){
        //data save // http://localhost:8001/api/v1/customers [POST[
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was created!...",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id){
        //find data // http://localhost:8001/api/v1/customers/1234 [GET]
        return "get()";
    }

    @PutMapping()
    public String update(){
        return "update()";
    }

    @GetMapping("/list")
    public String findAll(
                @RequestParam String searchText,
                @RequestParam int page,
                @RequestParam int size
        )
        {return "findAll()";}


    @GetMapping()
    public String getById(){
        return "getById()";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return "delete()";
    }


}

//http://localhost:8001/api/v1/customer/create(POST)
//http://localhost:8001/api/v1/curtomer/update(PUT)