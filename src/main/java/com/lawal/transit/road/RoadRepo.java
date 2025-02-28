package com.lawal.transit.road;

import com.lawal.transit.road.model.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepo extends JpaRepository<Road, Long> {
}