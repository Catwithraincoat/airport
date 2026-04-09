package com.example.airport.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;

    @Column(name = "flight_no", nullable = false, length = 6)
    private String flightNo;

    @Column(name = "scheduled_departure", nullable = false)
    private OffsetDateTime scheduledDeparture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport", nullable = false)
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport", nullable = false)
    private Airport arrivalAirport;

    // Возможно стоит перейти на  enum
    @Column(name="status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="aircraft_code", nullable = false)
    private Aircraft aircraft;

    @Column(name = "actual_departure")
    private OffsetDateTime actualDeparture;

    @Column(name = "actual_arrival")
    private OffsetDateTime actualArrival;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<TicketFlight> ticketFlights;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<BoardingPass> boardingPasses;


}
