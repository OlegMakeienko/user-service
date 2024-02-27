package com.makeienko.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommunalTransportDto {
    private Long id;
    private String fromPlace;
    private String toPlace;
    private String departureTime;
    private String arrivalTime;
    private Integer numberOfTransfers;
    private String travelTime;
    private String walkTime;
    private String delayReport;
    private String estimatedDelay;
    private Boolean isFavourite;
}
