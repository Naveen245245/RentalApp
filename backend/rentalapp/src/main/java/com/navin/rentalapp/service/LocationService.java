package com.navin.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navin.rentalapp.repo.LocationRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.navin.rentalapp.models.Location;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Flux<List<Location>> getLocationList() {
        return Flux.just(locationRepository.findAll());
    }

    public Mono<Location> createLocation(Location location) {
        return Mono.just(locationRepository.save(location));
    }

    public Mono<Location> getLocation(int locationId) {
        return Mono.just(locationRepository.findByPin(locationId));
    }

    public Mono<Location> updateLocation(int locationId, Location location) {
        Location locationFetched = locationRepository.findByPin(locationId);
        Location updatedLocation = locationFetched.setAddress(location.getAddress()).setCity(location.getCity())
                .setState(location.getState());
        return Mono.just(locationRepository.save(updatedLocation));
    }

    public Mono<String> deleteLocation(int locationId) {
        Location locationFetched = locationRepository.findByPin(locationId);
        locationRepository.delete(locationFetched);
        return Mono.just(String.valueOf(locationFetched.getAddress()) + "Deleted successful");
    }
}
