package com.example.airport.repository;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.dto.projection.AircraftProjection;
import com.example.airport.entity.AircraftEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AircraftRepository extends JpaRepository<AircraftEntity, String> {

    @Query(value = """
                    SELECT aircraft_code, model, range FROM aircrafts WHERE is_deleted = false 
                    AND (:model IS NULL OR model ILIKE CONCAT('%', :model, '%')) 
                    AND (:minRange IS NULL OR range >= :minRange)
                    AND (:maxRange IS NULL OR range <= :maxRange)
                    AND (:aircraftCode IS NULL OR aircraft_code = :aircraftCode)
                    """,
            countQuery = """
                    SELECT COUNT(*) FROM aircrafts
                    WHERE (:model IS NULL OR model ILIKE CONCAT('%', :model, '%'))
                    AND (:minRange IS NULL OR range >= :minRange)
                    AND (:maxRange IS NULL OR range <= :maxRange)
                    AND (:aircraftCode IS NULL OR aircraft_code = :aircraftCode)
                    AND is_deleted = false
                    """,
            nativeQuery = true)

    Page<AircraftProjection> search(
            @Param("model") String model,
            @Param("minRange") Integer minRange,
            @Param("maxRange") Integer maxRange,
            @Param("aircraftCode") String aircraftCode,
            Pageable pageable
    );
}
