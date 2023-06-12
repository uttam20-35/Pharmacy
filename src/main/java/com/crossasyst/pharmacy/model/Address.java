package com.crossasyst.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private Long postalCode;

    private String country;

    private Double latitude;

    private Double longitude;

    private Contact contact;
}
