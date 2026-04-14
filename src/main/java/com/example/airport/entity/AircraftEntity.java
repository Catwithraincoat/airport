package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "aircrafts")
public class AircraftEntity {
    // системные поля - дата создания  Creadet
    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;

    @Column(name="model")
    private String model;

    @Column(name="range")
    private Integer range;


    @OneToMany(fetch = FetchType.LAZY,mappedBy ="aircraft")
    private List<FlightEntity> flightEntities;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="aircraft")
    private List<SeatEntity> seatEntities;

    //зфщита от  N +1
}
