package com.lawal.transit.infrastructure.avenue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvenueRepo extends JpaRepository<Avenue, Long> {
}