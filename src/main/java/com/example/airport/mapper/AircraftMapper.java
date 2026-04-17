package com.example.airport.mapper;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.dto.AircraftFilterDTO;
import com.example.airport.entity.AircraftEntity;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapper {
    public AircraftDTO toDTO(AircraftEntity aircraft) {
        AircraftDTO aircraftDTO = new AircraftDTO();
        aircraftDTO.setAircraftCode(aircraft.getAircraftCode());
        aircraftDTO.setModel(aircraft.getModel());
        aircraftDTO.setRange(String.valueOf( aircraft.getRange()));
        return aircraftDTO;
    }

    public AircraftEntity toEntity(AircraftDTO aircraftDTO){
        AircraftEntity aircraft = new AircraftEntity();
        aircraft.setAircraftCode(aircraftDTO.getAircraftCode());
        aircraft.setModel(aircraftDTO.getModel());
        aircraft.setRange(Integer.valueOf(aircraftDTO.getRange()));
        return aircraft;
    }

//    public AircraftEntity toEntity(AircraftFilterDTO aircraftDTO){
//        AircraftEntity aircraft = new AircraftEntity();
//        aircraft.setAircraftCode(aircraftDTO.getAircraftCode());
//        aircraft.setModel(aircraftDTO.getModel());
//        aircraft.setRange(Integer.valueOf(aircraftDTO.getRange()));
//        return aircraft;
//    }

}
