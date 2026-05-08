package com.example.airport.service.validate.impl;


import com.example.airport.dto.AircraftDTO;
import com.example.airport.exception.AircraftValidationException;
import com.example.airport.service.validate.BusinessValidateAircraft;
import org.springframework.stereotype.Component;

// Модель: не пустая, длина от 2 до 50 символов
@Component
public class ModelValidation implements BusinessValidateAircraft {

    @Override
    public void validate(AircraftDTO aircraftDTO) {
        String model = aircraftDTO.getModel();

        if (model == null || model.isBlank()) {
            throw new AircraftValidationException("Модель самолёта не может быть пустой");
        }

        if (model.length() < 2 || model.length() > 50) {
            throw new AircraftValidationException(
                    "Длина модели должна быть от 2 до 50 символов, получено: " + model.length()
            );
        }

        if (!model.matches("[A-Za-z0-9 \\-]+")) {
            throw new AircraftValidationException(
                    "Модель может содержать только буквы, цифры, пробелы и дефис: " + model
            );
        }
    }
}