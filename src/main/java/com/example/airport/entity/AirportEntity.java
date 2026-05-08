package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "airports")
@Data
public class AirportEntity {

    @Id
    @Column(name = "airport_code", length = 3)
    private String airportCode;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @CreatedDate
    @Column(name ="created_at", updatable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

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
