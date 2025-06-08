package com.lawal.transitcraft.infrastructure.bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartureRepo extends JpaRepository<Departure, Long> {}