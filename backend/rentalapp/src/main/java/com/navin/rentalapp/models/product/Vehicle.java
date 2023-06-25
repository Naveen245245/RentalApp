package com.navin.rentalapp.models.product;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data 
@Accessors(chain = true)
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;
    private int vehicaleNumber;
    private VehicleType vehicleType;
    private String companyName;
    private String modelName;
    private int kmDrive;
    private Date manufatureDate;
    private int avg;
    private int cc;
    private int dailyRentalCost;
    private int hourlyRentalCost;
    private int noOfSeat;
    private Status status;
}
