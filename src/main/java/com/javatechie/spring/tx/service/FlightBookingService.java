package com.javatechie.spring.tx.service;

import com.javatechie.spring.tx.dto.BookingAcknowledgement;
import com.javatechie.spring.tx.dto.FlightBookingRequest;
import com.javatechie.spring.tx.dto.PaymentStatus;
import com.javatechie.spring.tx.entity.PassengerInfo;
import com.javatechie.spring.tx.entity.PaymentInfo;
import com.javatechie.spring.tx.exception.InsufficientFundException;
import com.javatechie.spring.tx.repository.PaymentRepository;
import com.javatechie.spring.tx.repository.PassengerInfoRepository;
import com.javatechie.spring.tx.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(readOnly = false, rollbackFor = InsufficientFundException.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public BookingAcknowledgement bookTicket(FlightBookingRequest request) throws Exception {
        BookingAcknowledgement acknowledgement = null;
        //save passenger info
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        //process payment
        PaymentInfo payment = request.getPaymentInfo();

        try {
            PaymentUtils.validateCreditLimit(payment.getAccountNo(), passengerInfo.getFare());
            payment.setPassengerId(passengerInfo.getPId());
            payment.setAmount(passengerInfo.getFare());
            paymentRepository.save(payment);
            return new BookingAcknowledgement(PaymentStatus.SUCCESS.toString(), payment.getAmount(), generatePNR(), passengerInfo);
        } catch (Exception ex) {
            throw new InsufficientFundException("insufficient fund");
        }

    }

    private String generatePNR() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
