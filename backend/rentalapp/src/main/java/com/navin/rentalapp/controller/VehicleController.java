package com.navin.rentalapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.navin.rentalapp.service.VehicleService;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.navin.rentalapp.models.product.Vehicle;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * VehicleController
 */
@RestController
@Tag(name = "VehicleManagement", description = "Vehicle Inventory Management api")
public class VehicleController {
    public final VehicleService vehicleService;
    
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public Flux<List<Vehicle>> getVehicles() {
        return vehicleService.getVehicleList();
    }
    
    @GetMapping("/vehicles/{id}")
    public Mono<Vehicle> getVehicle(@PathVariable int id) {
        return vehicleService.getVehicle(id);
    }
    
    @PostMapping("/vehicles")
    public Mono<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @PostMapping("/vehicles/{id}")
    public Mono<Vehicle> createVehicle(@PathVariable int id,@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id,vehicle);
    }

    @DeleteMapping("/vehicles/{id}")
    public Mono<String> deleteVehicle(@PathVariable int id) {
        return vehicleService.deleteVehicle(id);
    }

}