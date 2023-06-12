package com.crossasyst.pharmacy.mapper;

import com.crossasyst.pharmacy.entity.PharmacyEntity;
import com.crossasyst.pharmacy.model.Pharmacy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PharmacyMapper {

    Pharmacy entityToModel(PharmacyEntity pharmacyEntity);

    PharmacyEntity modelToEntity(Pharmacy pharmacy);
}