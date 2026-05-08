package com.example.airport.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class AircraftDTO {
    // Проверка кода на значения - пустота пробел ZKZ TRN
    private String aircraftCode;

    private String model;

    private String range;

}
