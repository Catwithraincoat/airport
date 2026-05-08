package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "boarding_passes")
@Data
public class BoardingPassEntity {
    @EmbeddedId
    private BoardingPassId id;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @CreatedDate
    @Column(name ="created_at", updatable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

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
