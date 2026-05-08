package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Table(name="bookings")
public class BookingEntity {
    @Id
    @Column(name = "book_ref", length = 6)
    private String bookRef;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @CreatedDate
    @Column(name ="created_at", updatable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "book_date", nullable = false)
    private OffsetDateTime bookDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
// каскадное удаление может и не надо
    @OneToMany(mappedBy = "bookingEntity", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntities;
}
