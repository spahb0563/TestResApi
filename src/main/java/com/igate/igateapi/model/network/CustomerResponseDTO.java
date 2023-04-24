package com.igate.igateapi.model.network;

import com.igate.igateapi.model.entity.Address;
import com.igate.igateapi.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CustomerResponseDTO {
    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private int active;

    private LocalDate createDate;

    private LocalDateTime lastUpdate;

    public CustomerResponseDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.active = customer.getActive();
        this.createDate = customer.getCreateDate();
        this.lastUpdate = customer.getLastUpdate();
    }



}
