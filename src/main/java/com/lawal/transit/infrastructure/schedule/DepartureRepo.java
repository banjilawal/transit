package com.lawal.transit.infrastructure.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartureRepo extends JpaRepository<Departure, Long> {}