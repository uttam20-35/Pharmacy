package com.crossasyst.pharmacy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pharmacy")
public class PharmacyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmacy_gen")
    @SequenceGenerator(name = "pharmacy_gen", sequenceName = "pharmacy_seq")
    @Column(name = "pharmacy_id", nullable = false)
    private Long pharmacyId;

    @Column(name = "name")
    private String pharmacyName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OtherInformationEntity otherInformationEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContactEntity contactEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CategoryEntity categoryEntity;
}
