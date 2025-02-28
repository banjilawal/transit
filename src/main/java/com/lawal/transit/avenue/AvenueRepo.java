package com.lawal.transit.avenue;

import com.lawal.transit.avenue.model.Avenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvenueRepo extends JpaRepository<Avenue, Long> {
}