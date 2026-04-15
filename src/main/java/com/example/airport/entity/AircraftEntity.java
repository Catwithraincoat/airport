package com.example.airport.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "aircrafts")
@SQLDelete(sql = "update article set deleted=true where id=?")
@SQLRestriction("is_deleted=false")
@EntityListeners(AuditingEntityListener.class)
public class AircraftEntity {
    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @CreatedDate
    @Column(name ="created_at")
    private LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;



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
