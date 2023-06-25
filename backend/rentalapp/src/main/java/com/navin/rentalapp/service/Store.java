package com.navin.rentalapp.service;

import java.util.List;

import com.navin.rentalapp.models.Location;
import com.navin.rentalapp.models.payment.Reservation;

public class Store {
    int storeId;
    VehicleService vehicleInventoryManagement;
    Location location;
    List<Reservation> reservationList;
}
