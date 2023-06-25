package com.navin.rentalapp.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navin.rentalapp.models.product.Vehicle;

@Repository
public interface  VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Vehicle findByVehicleId(int vehicleId);
    
}
