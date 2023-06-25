package com.navin.rentalapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navin.rentalapp.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Location findByPin(int locationId);
    
}
