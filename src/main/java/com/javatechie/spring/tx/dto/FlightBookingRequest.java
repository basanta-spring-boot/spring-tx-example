package com.javatechie.spring.tx.dto;

import com.javatechie.spring.tx.entity.PassengerInfo;
import com.javatechie.spring.tx.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;
}
