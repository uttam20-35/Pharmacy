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
public class Pharmacy {

    private String pharmacyName;

    private Address address;

    private OtherInformation otherInformation;
}
