package com.igate.igateapi.controller;


import com.igate.igateapi.model.network.CustomerRequestDTO;
import com.igate.igateapi.model.network.ResultMessage;
import com.igate.igateapi.model.network.Body;
import com.igate.igateapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerApiController {


    private final CustomerService customerService;


    @GetMapping("/{customerId}")
    public ResponseEntity<Body> read(@PathVariable Long customerId, @RequestBody Body request) {

        return customerService.read(customerId, request);
    }

    @PostMapping("")
    public ResponseEntity<Body<ResultMessage>> create(@RequestBody Body<CustomerRequestDTO> request) {
        System.out.println("post");
        return customerService.create(request);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Body<ResultMessage>> update(@PathVariable Long customerId, @RequestBody Body<CustomerRequestDTO> request) {
        return customerService.update(customerId, request);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Body<ResultMessage>> delete(@PathVariable Long customerId, @RequestBody Body request) {
        return customerService.delete(customerId, request);
    }
}
