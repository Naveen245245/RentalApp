package com.navin.rentalapp.models.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
// @Entity
@Accessors(chain = true)
public class Bill {
    @Id
    @GeneratedValue
    private long id;
    private Reservation reservation;
    private double totalAmount;
    private boolean isPaid;

}
