package com.example.airport.repository;

import com.example.airport.entity.TicketFlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketFlightRepository extends JpaRepository<TicketFlightEntity, TicketFlightEntity.TicketFlightId> {
}
