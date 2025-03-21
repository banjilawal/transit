package com.lawal.transit.infrastructure.street;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepo extends JpaRepository<Street, Long> {
}