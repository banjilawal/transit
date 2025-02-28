package com.lawal.transit.junction;

import com.lawal.transit.junction.model.Junction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JunctionRepo extends JpaRepository<Junction, Long> {
}