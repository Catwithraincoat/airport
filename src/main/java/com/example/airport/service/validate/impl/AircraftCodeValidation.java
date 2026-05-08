package com.example.airport.service.validate.impl;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.exception.AircraftValidationException;
import com.example.airport.service.validate.BusinessValidateAircraft;
import org.springframework.stereotype.Component;

@Component
public class AircraftCodeValidation implements BusinessValidateAircraft {

    @Override
    public void validate(AircraftDTO aircraftDTO) {
        String code = aircraftDTO.getAircraftCode();

        if (code == null || code.isBlank()) {
            throw new AircraftValidationException("Код самолёта не может быть пустым");
        }

        if (code.length() != 3) {
            throw new AircraftValidationException(
                    "Код самолёта должен содержать ровно 3 символа, получено: " + code.length()
            );
        }

        if (!code.matches("[A-Z0-9]+")) {
            throw new AircraftValidationException(
                    "Код самолёта должен содержать только заглавные буквы и цифры: " + code
            );
        }
    }
}