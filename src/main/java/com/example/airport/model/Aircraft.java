package com.example.airport.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "aircrafts")
public class Aircraft {
    // системные поля - дата создания  Creadet
    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;

    @Column(name="model")
    private String model;

    @Column(name="range")
    private Integer range;


    @OneToMany(fetch = FetchType.LAZY,mappedBy ="aircraft")
    private List<Flight> flights;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="aircraft")
    private List<Seat> seats;

    //зфщита от  N +1
}
