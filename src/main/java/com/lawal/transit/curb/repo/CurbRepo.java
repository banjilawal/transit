package com.lawal.transit.curb.repo;

import com.lawal.transit.curb.model.Curb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurbRepo extends JpaRepository<Curb, Long> {
}