package com.lawal.transit.infrastructure.road;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepo extends JpaRepository<Road, Long> {
}