package com.lawal.transit.station;

import com.lawal.transit.station.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, Long> {
}