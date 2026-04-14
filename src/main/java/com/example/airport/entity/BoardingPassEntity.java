package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "boarding_passes")
@Data
public class BoardingPassEntity {
    @EmbeddedId
    private BoardingPassId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ticketNo")
    @JoinColumn(name = "ticket_no")
    private TicketEntity ticketEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("flightId")
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;

    @Column(name = "boarding_no", nullable = false)
    private Integer boardingNo;

    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;


    @Embeddable
    @Data
    public static class BoardingPassId
            implements Serializable {

        @Column(name = "ticket_no")
        private String ticketNo;

        @Column(name = "flight_id")
        private Integer flightId;
    }
}
