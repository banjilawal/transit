package com.lawal.transit.route.repo;

import com.lawal.transit.route.model.TransitStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitStopRepo extends JpaRepository<TransitStop, Long> {}