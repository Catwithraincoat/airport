package com.example.airport.service;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.dto.AircraftFilterDTO;
import com.example.airport.entity.AircraftEntity;
import com.example.airport.mapper.AircraftMapper;
import com.example.airport.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AircraftService {
    private final AircraftRepository aircraftRepository;
    private final AircraftMapper aircraftMapper;

    public AircraftDTO getAircraftById(String Id){
        return aircraftMapper.toDTO(aircraftRepository.findById(Id).orElseThrow(() -> new RuntimeException("Самолёт не найден")));

    }

    public List<AircraftDTO> getAll(){
        return aircraftRepository.findAll().stream()
                .map(aircraftMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AircraftDTO saveAircraft(AircraftDTO aircraftDTO){
        return aircraftMapper.toDTO(aircraftRepository.save(aircraftMapper.toEntity(aircraftDTO)));
    }

    public String deleteAircraft(String Id){
        aircraftRepository.deleteById(Id);
        return "Ok";
    }

    public AircraftDTO updateAircraft(String code, AircraftDTO dto){
        AircraftEntity existing = aircraftRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Not found"));

        existing.setModel(dto.getModel());
        existing.setRange(Integer.valueOf(dto.getRange()));
        return aircraftMapper.toDTO(aircraftRepository.save(existing));
    }

    public List<AircraftDTO> search(AircraftFilterDTO aircraftFilterDTO){
        return aircraftRepository.search(
                                        aircraftFilterDTO.getModel(),
                                        Integer.valueOf(aircraftFilterDTO.getAircraftCode()),
                                        Integer.valueOf(aircraftFilterDTO.getMaxRange()),
                                        aircraftFilterDTO.getMinRange());
    }



}
