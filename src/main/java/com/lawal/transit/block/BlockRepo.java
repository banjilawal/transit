package com.lawal.transit.block;

import com.lawal.transit.block.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepo extends JpaRepository<Block, Long> {
}