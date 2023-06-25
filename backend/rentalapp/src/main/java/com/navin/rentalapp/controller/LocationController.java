package com.navin.rentalapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.navin.rentalapp.models.Location;
import com.navin.rentalapp.service.LocationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * locationController
 */
@RestController
@Tag(name = "LocationManagement", description = "Location Management api")
public class LocationController {
    public final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public Flux<List<Location>> getlocations() {
        return locationService.getLocationList();
    }

    @GetMapping("/locations/{id}")
    public Mono<Location> getLocation(@PathVariable int id) {
        return locationService.getLocation(id);
    }

    @PostMapping("/locations")
    public Mono<Location> createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @PostMapping("/locations/{id}")
    public Mono<Location> createLocation(@PathVariable int id, @RequestBody Location location) {
        return locationService.updateLocation(id, location);
    }

    @DeleteMapping("/locations/{id}")
    public Mono<String> deleteLocation(@PathVariable int id) {
        return locationService.deleteLocation(id);
    }

}