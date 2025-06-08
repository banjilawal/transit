package com.lawal.transitcraft.infrastructure.block;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepo extends JpaRepository<Block, Long> {
}