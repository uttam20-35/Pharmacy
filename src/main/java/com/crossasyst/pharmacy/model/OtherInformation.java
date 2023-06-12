package com.crossasyst.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OtherInformation {

    private Date startDate;

    private Date endDate;

    private Date lastUpdatedDate;

    private String status;

    private String additionalStatus;

    private String indicator;
/*
    @Column(name = "transfer_type")
    private String transferType;

    @Column(name = "rx_source")
    private String rxSource;
*/

    private String actions;

    private Boolean activeStatus;

    private Long ncpdpId;

    private Long uniqueId;

    private String additionalInformation;

    private Category category;

}
