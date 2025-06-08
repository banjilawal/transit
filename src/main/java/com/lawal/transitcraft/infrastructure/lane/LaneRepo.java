package com.lawal.transitcraft.infrastructure.lane;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaneRepo extends JpaRepository<Lane, Long> {
}