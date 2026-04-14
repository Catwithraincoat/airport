package com.example.airport.service;

import com.example.airport.entity.TicketFlightEntity;
import com.example.airport.repository.TicketFlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketFlightService {
    private final TicketFlightRepository ticketFlightRepository;

    public List<TicketFlightEntity> getAll(){
        return ticketFlightRepository.findAll();
    }

    public TicketFlightEntity getbyId(TicketFlightEntity.TicketFlightId  Id){
        if (!ticketFlightRepository.existsById(Id)) {
            return ticketFlightRepository.getById(Id);}

        throw new RuntimeException("Связь билет-полет  не найдена");
    }

    public TicketFlightEntity create(TicketFlightEntity ticketFlightEntity){
        return ticketFlightRepository.save(ticketFlightEntity);
    }

    public TicketFlightEntity updateTicket(TicketFlightEntity.TicketFlightId  Id, TicketFlightEntity ticketFlightEntity){
        if (!ticketFlightRepository.existsById(Id)) {
            return ticketFlightRepository.save(ticketFlightEntity);
        }
        throw new RuntimeException("Связь билет-полет не найден");

    }
    public void delete(TicketFlightEntity.TicketFlightId Id){
        ticketFlightRepository.deleteById(Id);
    }

}
