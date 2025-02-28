package com.lawal.transit.path;

import com.lawal.transit.path.model.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepo extends JpaRepository<Path, Long> {
}