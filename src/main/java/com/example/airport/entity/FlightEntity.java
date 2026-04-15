package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
public class FlightEntity {
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
    private AirportEntity departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport", nullable = false)
    private AirportEntity arrivalAirport;

    // Возможно стоит перейти на  enum
    @Column(name="status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="aircraft_code", nullable = false)
    private AircraftEntity aircraftEntity;

    @Column(name = "actual_departure")
    private OffsetDateTime actualDeparture;

    @Column(name = "actual_arrival")
    private OffsetDateTime actualArrival;

    @OneToMany(mappedBy = "flightEntity", cascade = CascadeType.ALL)
    private List<TicketFlightEntity> ticketFlightEntities;

    @OneToMany(mappedBy = "flightEntity", cascade = CascadeType.ALL)
    private List<BoardingPassEntity> boardingPassEntities;


}
