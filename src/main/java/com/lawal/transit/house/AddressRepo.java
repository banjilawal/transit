package com.lawal.transit.house;

import com.lawal.transit.house.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<House, Long> {
}