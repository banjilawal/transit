package com.lawal.transit.route.repo;

import com.lawal.transit.route.model.TransitRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitRouteRepo extends JpaRepository<TransitRoute, Long> {
}