package com.lawal.transitcraft.infrastructure.junction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JunctionRepo extends JpaRepository<Junction, Long> {
}