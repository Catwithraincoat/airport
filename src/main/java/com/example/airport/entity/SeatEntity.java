package com.example.airport.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "seats")
@Data
//SeatEntity
@NoArgsConstructor
@AllArgsConstructor
@Builder //для тестов
public class SeatEntity {
    @EmbeddedId
    private SeatId id;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @CreatedDate
    @Column(name ="created_at", updatable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("aircraftCode")
    @JoinColumn(name = "aircraft_code")
    private AircraftEntity aircraftEntity;

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
