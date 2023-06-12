package com.crossasyst.pharmacy.service;


import com.crossasyst.pharmacy.entity.*;
import com.crossasyst.pharmacy.mapper.PharmacyMapper;
import com.crossasyst.pharmacy.model.*;
import com.crossasyst.pharmacy.repository.PharmacyRepository;
import com.crossasyst.pharmacy.response.PharmacyResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class testOnPharmacyService {

    @InjectMocks
    private PharmacyService sut;

    @Mock
    private PharmacyMapper pharmacyMapper;

    @Mock
    private PharmacyRepository pharmacyRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePharmacy() {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setPharmacyName("Apollo");
        PharmacyEntity pharmacyEntity = new PharmacyEntity();
        pharmacyEntity.setPharmacyId(101L);
        pharmacyEntity.setPharmacyName("Apollo");

        PharmacyResponse pharmacyResponse = new PharmacyResponse();
        pharmacyResponse.setPharmacyId(101L);

        Mockito.when(pharmacyMapper.modelToEntity(pharmacy)).thenReturn(pharmacyEntity);
        Mockito.when(pharmacyRepository.save(pharmacyEntity)).thenReturn(pharmacyEntity);

        pharmacyResponse = sut.createPharmacy(pharmacy);
        Assertions.assertEquals(101L, pharmacyResponse.getPharmacyId());
    }

    @Test
    public void testGetPharmacy() {
        Pharmacy pharmacy1=new Pharmacy();
        PharmacyEntity pharmacy= new PharmacyEntity();
        pharmacy.setPharmacyName("Apollo");

        AddressEntity address=new AddressEntity();
        address.setAddressLine1("abc");
        address.setAddressLine2("pqr");

        ContactEntity contact=new ContactEntity();
        contact.setPhoneNumber1("+3232323");
        address.setContactEntity(contact);

        pharmacy.setAddressEntity(address);

        OtherInformationEntity otherInformation=new OtherInformationEntity();
        otherInformation.setIndicator("new refill");

        CategoryEntity category=new CategoryEntity();
        category.setNameOfCategory("xyz");
        otherInformation.setCategoryEntity(category);

        pharmacy.setOtherInformationEntity(otherInformation);

        Mockito.when(pharmacyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pharmacy));
        Mockito.when(pharmacyMapper.entityToModel(pharmacy)).thenReturn(pharmacy1);

        Pharmacy pharmacyResponse=sut.getPharmacyById(Mockito.anyLong());
    }


    @Test
    public void getPharmacyNotPresent(){
        Pharmacy pharmacy=new Pharmacy();

        Mockito.when(pharmacyRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Pharmacy response=sut.getPharmacyById(Mockito.anyLong());
        Assertions.assertNull(response);
    }
}
