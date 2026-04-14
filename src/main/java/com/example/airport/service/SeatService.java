package com.example.airport.service;

import com.example.airport.entity.SeatEntity;
import com.example.airport.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    //todo mapping
    public List<SeatEntity> getAll() {
        return seatRepository.findAll();
    }

    public SeatEntity getById(SeatEntity.SeatId id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Место не найдено"));
    }

    public void delete(SeatEntity.SeatId id){
        seatRepository.deleteById(id);
    }

    public SeatEntity create(SeatEntity seatEntity){
        return seatRepository.save(seatEntity);
    }

    public SeatEntity updateSeat(SeatEntity.SeatId Id, SeatEntity seatEntity){
        if (!seatRepository.existsById(Id)) {
            return seatRepository.save(seatEntity);
        }
        throw new RuntimeException("Место не найден");
    }


}
