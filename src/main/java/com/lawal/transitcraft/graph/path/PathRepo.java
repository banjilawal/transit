package com.lawal.transitcraft.graph.path;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepo extends JpaRepository<Path, Long> {
}