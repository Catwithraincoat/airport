package com.example.airport.service.validate.impl;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.exception.AircraftValidationException;
import com.example.airport.service.validate.BusinessValidateAircraft;
import org.springframework.stereotype.Component;

@Component
public class RangeValidation implements BusinessValidateAircraft {

    private static final int MIN_RANGE = 100;
    private static final int MAX_RANGE = 20000;

    @Override
    public void validate(AircraftDTO aircraftDTO) {
        String rangeStr = aircraftDTO.getRange();

        if (rangeStr == null || rangeStr.isBlank()) {
            throw new AircraftValidationException("Дальность не может быть пустой");
        }

        int range;
        try {
            range = Integer.parseInt(rangeStr);
        } catch (NumberFormatException e) {
            throw new AircraftValidationException("Дальность должна быть числом: " + rangeStr);
        }

        if (range < MIN_RANGE || range > MAX_RANGE) {
            throw new AircraftValidationException(
                    "Дальность должна быть от " + MIN_RANGE + " до " + MAX_RANGE + " км, получено: " + range
            );
        }
    }
}