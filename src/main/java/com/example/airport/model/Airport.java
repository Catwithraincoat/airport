package com.example.airport.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "airports")
@Data
public class Airport {

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
    private List<Flight> departureFlights;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalAirport")
    private List<Flight> arrivalFlights;



}
