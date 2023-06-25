package com.navin.rentalapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
public class Location {
    @Id
    @GeneratedValue
    private int pin;
    private String address;
    private String city;
    private String state;
} 
