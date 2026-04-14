package com.example.airport.service;


import com.example.airport.entity.TicketEntity;
import com.example.airport.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public List<TicketEntity> getAll(){
        return ticketRepository.findAll();
    }

    public TicketEntity getbyId(String Id){
        if (!ticketRepository.existsById(Id)) {
            return ticketRepository.getById(Id);}

        throw new RuntimeException("Бронь  не найдена");
    }

    public TicketEntity create(TicketEntity ticketEntity){
        return ticketRepository.save(ticketEntity);
    }

    public TicketEntity updateTicket(String Id, TicketEntity ticketEntity){
        if (!ticketRepository.existsById(Id)) {
            return ticketRepository.save(ticketEntity);
        }
        throw new RuntimeException("Билет не найден");

    }
    public void delete(String Id){
        ticketRepository.deleteById(Id);
    }
}
