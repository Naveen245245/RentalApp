package com.navin.rentalapp.service;

import com.navin.rentalapp.models.product.Vehicle;
import com.navin.rentalapp.repo.VehicleRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    
    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Flux<List<Vehicle>> getVehicleList() {
        return Flux.just(vehicleRepository.findAll());
    }

    public Mono<Vehicle> createVehicle(Vehicle vehicle) {
        return Mono.just(vehicleRepository.save(vehicle));
    }

    public Mono<Vehicle> getVehicle(int vehicleId) {
        return Mono.just(vehicleRepository.findByVehicleId(vehicleId));
    }

    public Mono<Vehicle> updateVehicle(int vehicleId, Vehicle vehicle) {
        Vehicle vehicleFetched = vehicleRepository.findByVehicleId(vehicleId);

        Vehicle updatedVehicleId = vehicleFetched.setAvg(vehicle.getAvg()).setCc(vehicle.getCc()).setCompanyName(vehicle.getCompanyName())
                .setDailyRentalCost(vehicle.getDailyRentalCost()).setHourlyRentalCost(vehicle.getHourlyRentalCost())
                .setKmDrive(vehicle.getKmDrive()).setManufatureDate(vehicle.getManufatureDate())
                .setModelName(vehicle.getModelName()).setNoOfSeat(vehicle.getNoOfSeat()).setStatus(vehicle.getStatus())
                .setVehicaleNumber(vehicleId);

        return Mono.just(vehicleRepository.save(updatedVehicleId));
    }

    public Mono<String> deleteVehicle(int vehicleId) {
        Vehicle vehicleFetched = vehicleRepository.findByVehicleId(vehicleId);
        vehicleRepository.delete(vehicleFetched);
        return Mono.just(String.valueOf(vehicleFetched.getVehicaleNumber())+"Deleted successful");
    }

}
