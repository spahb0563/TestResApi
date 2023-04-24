package com.igate.igateapi.model.network;

import com.igate.igateapi.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerRequestDTO {
    private String firstName;

    private String lastName;

    private String email;

    private int active;

    public Customer toEntity() {
        return Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .active(active)
                .build();
    }
}
