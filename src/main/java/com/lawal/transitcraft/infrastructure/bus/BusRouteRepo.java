package com.lawal.transitcraft.infrastructure.bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRouteRepo extends JpaRepository<BusRoute, Long> {
}