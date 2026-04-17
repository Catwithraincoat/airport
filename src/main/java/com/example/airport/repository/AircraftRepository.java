package com.example.airport.repository;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.entity.AircraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//Добавить пагинацию
@Repository
public interface AircraftRepository extends JpaRepository<AircraftEntity, String> {

    @Query(value = """
                    SELECT * FROM aircrafts WHERE (:is_deleted = false) 
                    AND (:model IS NULL OR model ILIKE CONCAT('%', :model, '%')) 
                    AND (:minRange IS NULL OR range >= :minRange)
                    AND (:maxRange IS NULL OR range <= :maxRange)
                    AND (:aircraftCode IS NULL OR aircraft_code = :aircraftCode)""", nativeQuery = true)
    List<AircraftDTO> search(
            @Param("model") String model,
            @Param("minRange") Integer minRange,
            @Param("maxRange") Integer maxRange,
            @Param("aircraftCode") String aircraftCode
    );
}
