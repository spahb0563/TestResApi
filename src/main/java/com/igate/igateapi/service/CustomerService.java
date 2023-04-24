package com.igate.igateapi.service;

import com.igate.igateapi.model.entity.Customer;
import com.igate.igateapi.model.network.CustomerRequestDTO;
import com.igate.igateapi.model.network.CustomerResponseDTO;
import com.igate.igateapi.model.network.Message;
import com.igate.igateapi.model.network.ResultMessage;
import com.igate.igateapi.model.network.Body;
import com.igate.igateapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseEntity<Body> read(Long id, Body request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 고객입니다."));

        request.setDataBody(new CustomerResponseDTO(customer));

        return ResponseEntity.ok(request);
    }

    @Transactional
    public ResponseEntity<Body<ResultMessage>> create(Body<CustomerRequestDTO> request) {

        customerRepository.save(request.getDataBody().toEntity());

        Body response = Body.builder()
                .dataHeader(request.getDataHeader())
                .dataBody(new ResultMessage(Message.CREATE_COMPLETE.getDescription(), Message.CREATE_COMPLETE.getHttpStatus()))
                .build();

        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<Body<ResultMessage>> update(Long id, Body<CustomerRequestDTO> request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 고객입니다."));

        customer.update(request.getDataBody());

        Body response = Body.builder()
                .dataHeader(request.getDataHeader())
                .dataBody(new ResultMessage(Message.UPDATE_COMPLETE.getDescription(), Message.UPDATE_COMPLETE.getHttpStatus()))
                .build();

        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<Body<ResultMessage>> delete(Long id, Body request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 고객입니다."));

        customerRepository.delete(customer);

        Body response = Body.builder()
                .dataHeader(request.getDataHeader())
                .dataBody(new ResultMessage(Message.DELETE_COMPLETE.getDescription(), Message.DELETE_COMPLETE.getHttpStatus()))
                .build();

        return ResponseEntity.ok(response);
    }
















}
