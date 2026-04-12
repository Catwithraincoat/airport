package com.example.airport.service;

import com.example.airport.model.Ticket;
import com.example.airport.model.TicketFlight;
import com.example.airport.repository.TicketFlightRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class TicketFlightService {
    private TicketFlightRepository ticketFlightRepository;

    public List<TicketFlight> getAll(){
        return ticketFlightRepository.findAll();
    }

    public TicketFlight getbyId(TicketFlight.TicketFlightId  Id){
        if (!ticketFlightRepository.existsById(Id)) {
            return ticketFlightRepository.getById(Id);}

        throw new RuntimeException("Связь билет-полет  не найдена");
    }

    public TicketFlight create(TicketFlight ticketFlight){
        return ticketFlightRepository.save(ticketFlight);
    }

    public TicketFlight updateTicket(TicketFlight.TicketFlightId  Id, TicketFlight ticketFlight){
        if (!ticketFlightRepository.existsById(Id)) {
            return ticketFlightRepository.save(ticketFlight);
        }
        throw new RuntimeException("Связь билет-полет не найден");

    }
    public void delete(TicketFlight.TicketFlightId Id){
        ticketFlightRepository.deleteById(Id);
    }

}
