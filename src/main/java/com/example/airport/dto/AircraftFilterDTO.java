package com.example.airport.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AircraftFilterDTO {
    private String aircraftCode;
    private String model;
    private String MaxRange;
    private String MinRange;
}
