package com.example.airport.model;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="ticket_flights")
public class TicketFlight {
    @EmbeddedId
    private TicketFlightId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ticketNo")
    @JoinColumn(name = "ticket_no")
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("flightId")
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Embeddable
    @Data
    public static class TicketFlightId
            implements Serializable {

        @Column(name = "ticket_no")
        private String ticketNo;

        @Column(name = "flight_id")
        private Integer flightId;
    }
}
