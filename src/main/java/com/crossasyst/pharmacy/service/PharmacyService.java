package com.crossasyst.pharmacy.service;

import com.crossasyst.pharmacy.entity.PharmacyEntity;
import com.crossasyst.pharmacy.mapper.PharmacyMapper;
import com.crossasyst.pharmacy.model.Pharmacy;
import com.crossasyst.pharmacy.repository.PharmacyRepository;
import com.crossasyst.pharmacy.response.PharmacyResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Log4j2
@Service
public class PharmacyService {


    private final PharmacyRepository pharmacyRepository;


    private final PharmacyMapper pharmacyMapper;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository, PharmacyMapper pharmacyMapper) {
        this.pharmacyRepository = pharmacyRepository;
        this.pharmacyMapper = pharmacyMapper;
    }

    public PharmacyResponse createPharmacy(Pharmacy pharmacy) {
        PharmacyEntity pharmacyEntity = pharmacyMapper.modelToEntity(pharmacy);
        pharmacyRepository.save(pharmacyEntity);

        PharmacyResponse pharmacyResponse = new PharmacyResponse();
        pharmacyResponse.setPharmacyId(pharmacyEntity.getPharmacyId());
        pharmacyResponse.setPharmacyName(pharmacyEntity.getPharmacyName());
        return pharmacyResponse;
    }

    public Pharmacy getPharmacyById(Long pharmacyId) {
        Optional<PharmacyEntity> optionalPharmacyEntity = pharmacyRepository.findById(pharmacyId);
        Pharmacy pharmacy = null;
        if (optionalPharmacyEntity.isPresent()) {
            pharmacy = pharmacyMapper.entityToModel(optionalPharmacyEntity.get());
            log.info("Record Found");
        } else {
            log.info("No Records Found");
        }
        return pharmacy;
    }
}
