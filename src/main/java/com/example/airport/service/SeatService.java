package com.example.airport.service;

import com.example.airport.model.Flight;
import com.example.airport.model.Seat;
import com.example.airport.repository.FlightRepository;
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

}
