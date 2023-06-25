package com.navin.rentalapp.models.payment;

import com.navin.rentalapp.models.Location;
import com.navin.rentalapp.models.User;
import com.navin.rentalapp.models.product.Vehicle;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

import javax.persistence.Entity;

@Data
@Accessors(chain = true)
// @Entity
public class Reservation {
    int reservationId;
    // User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date bookingfrom;
    private Date bookingTo;
    private Long fromTimeStamp;
    private Long toTimeStamp;
    private Location pickupLocation;
    private Location dropLocation;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;
    private Location location;

}
