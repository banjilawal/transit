package com.lawal.transitcraft.infrastructure.curb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurbRepo extends JpaRepository<Curb, Long> {
}