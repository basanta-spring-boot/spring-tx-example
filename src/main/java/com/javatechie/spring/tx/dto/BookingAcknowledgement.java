package com.javatechie.spring.tx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javatechie.spring.tx.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingAcknowledgement {

    private String status;
    private double fare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
