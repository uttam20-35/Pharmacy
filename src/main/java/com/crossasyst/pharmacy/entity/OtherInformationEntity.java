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

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "other_information")
public class OtherInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "other_information_gen")
    @SequenceGenerator(name = "other_information_gen", sequenceName = "other_information_seq")
    @Column(name = "other_info_id", nullable = false)
    private Long otherInfoId;

    @Column(name = "opening_date")
    private Date startDate;

    @Column(name = "closing_date")
    private Date endDate;

    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "additional_status")
    private String additionalStatus;

    @Column(name = "indicator")
    private String indicator;
/*
    @Column(name = "transfer_type")
    private String transferType;

    @Column(name = "rx_source")
    private String rxSource;
*/

    @Column(name = "actions")
    private String actions;

    @Column(name = "active_status")
    private Boolean activeStatus;

    @Column(name = "ncpdp_id")
    private Long ncpdpId;

    @Column(name = "unique_id")
    private Long uniqueId;

    @Column(name = "additional_information")
    private String additionalInformation;

    @OneToOne
    private CategoryEntity categoryEntity;
}
