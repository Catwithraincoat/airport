package com.example.airport.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "seats")
@Data
//SeatEntity
@NoArgsConstructor
@AllArgsConstructor
@Builder //для тестов
public class Seat {
    @EmbeddedId
    private SeatId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("aircraftCode")
    @JoinColumn(name = "aircraft_code")
    private Aircraft aircraft;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @Embeddable
    @Data
    public static class SeatId implements Serializable {
        @Column(name = "aircraft_code")
        private String aircraftCode;

        @Column(name = "seat_no")
        private String seatNo;
    }
}
