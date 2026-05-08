package com.example.airport.service.validate;

import com.example.airport.dto.AircraftDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftValidationService {

    private final List<BusinessValidateAircraft> validators;

    public void validate(AircraftDTO aircraftDTO) {
        validators.forEach(validator -> validator.validate(aircraftDTO));
    }
}