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
    public ResponseEntity<StandardResponse> get(@PathVariable String id){
        //find data // http://localhost:8001/api/v1/customers/1234 [GET]
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer was created!..",customerService.findById(id)),
                HttpStatus.OK

        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestCustomerdto dto){
        customerService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer data changed!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> findAll(
                @RequestParam String searchText,
                @RequestParam int page,
                @RequestParam int size
        ){

        return new ResponseEntity<>(
                new StandardResponse(201,"Customer data fetched...",customerService.findAll(searchText, page, size)),
                HttpStatus.CREATED
        );}


    @GetMapping()
    public String getById(){
        return "getById()";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        customerService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer data deleted!..",null),
                HttpStatus.CREATED
        );
    }


}

//http://localhost:8001/api/v1/customer/create(POST)
//http://localhost:8001/api/v1/curtomer/update(PUT)