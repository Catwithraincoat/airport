package com.example.airport.service;

import com.example.airport.model.Seat;
import com.example.airport.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    //todo mapping
    public List<Seat> getAll() {
        return seatRepository.findAll();
    }

    public Seat getById(Seat.SeatId id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Место не найдено"));
    }

    public void delete(Seat.SeatId id){
        seatRepository.deleteById(id);
    }

    public Seat create(Seat seat ){
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Seat.SeatId Id, Seat seat){
        if (!seatRepository.existsById(Id)) {
            return seatRepository.save(seat);
        }
        throw new RuntimeException("Место не найден");
    }


}
