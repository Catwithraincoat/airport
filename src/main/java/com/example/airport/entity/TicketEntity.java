package com.example.airport.entity;



import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="tickets")
public class TicketEntity {
    @Id
    @Column(name = "ticket_no", length = 13)
    private String ticketNo;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @CreatedDate
    @Column(name ="created_at", updatable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "book_ref", nullable = false)
    private BookingEntity bookingEntity;

    @Column(name = "passenger_id", nullable = false, length = 20)
    private String passengerId;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "contact_data")
    private String contactData;


    @OneToMany(mappedBy = "ticketEntity", cascade = CascadeType.ALL)
    private List<TicketFlightEntity> ticketFlightEntities;

    @OneToMany(mappedBy = "ticketEntity", cascade = CascadeType.ALL)
    private List<BoardingPassEntity> boardingPassEntities;
}
