package com.example.airport.service;


import com.example.airport.model.Ticket;
import com.example.airport.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;

    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }

    public Ticket getbyId(String Id){
        if (!ticketRepository.existsById(Id)) {
            return ticketRepository.getById(Id);}

        throw new RuntimeException("Бронь  не найдена");
    }

    public Ticket create(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(String Id, Ticket ticket){
        if (!ticketRepository.existsById(Id)) {
            return ticketRepository.save(ticket);
        }
        throw new RuntimeException("Билет не найден");

    }
    public void delete(String Id){
        ticketRepository.deleteById(Id);
    }
}
