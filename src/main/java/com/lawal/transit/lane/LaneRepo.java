package com.lawal.transit.lane;

import com.lawal.transit.lane.model.Lane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaneRepo extends JpaRepository<Lane, Long> {
}