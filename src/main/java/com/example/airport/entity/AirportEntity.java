package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "airports")
@Data
public class AirportEntity {

    @Id
    @Column(name = "airport_code", length = 3)
    private String airportCode;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private String timezone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departureAirport")
    private List<FlightEntity> departureFlightEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalAirport")
    private List<FlightEntity> arrivalFlightEntities;



}
