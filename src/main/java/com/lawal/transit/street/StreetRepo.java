package com.lawal.transit.street;

import com.lawal.transit.street.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepo extends JpaRepository<Street, Long> {
}