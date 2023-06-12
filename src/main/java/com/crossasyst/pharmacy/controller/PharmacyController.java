package com.crossasyst.pharmacy.controller;

import com.crossasyst.pharmacy.model.Pharmacy;
import com.crossasyst.pharmacy.response.PharmacyResponse;
import com.crossasyst.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PharmacyController {
    private final PharmacyService pharmacyService;

    @Autowired
    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping(value = "/pharmacies", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PharmacyResponse> createPharmacy(@RequestBody Pharmacy pharmacy) {
        PharmacyResponse pharmacyResponse = pharmacyService.createPharmacy(pharmacy);
        return new ResponseEntity<>(pharmacyResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/pharmacies/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pharmacy> getPharmacyById(@PathVariable Long pharmacyId) {
        Pharmacy pharmacy = pharmacyService.getPharmacyById(pharmacyId);
        return new ResponseEntity<>(pharmacy, HttpStatus.OK);
    }
}
