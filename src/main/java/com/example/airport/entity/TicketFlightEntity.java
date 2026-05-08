package com.example.airport.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="ticket_flights")
public class TicketFlightEntity {
    @EmbeddedId
    private TicketFlightId id;

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

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Embeddable
    @Data
    public static class TicketFlightId
            implements Serializable {

        @Column(name = "ticket_no")
        private String ticketNo;

        @Column(name = "flight_id")
        private Integer flightId;
    }
}
