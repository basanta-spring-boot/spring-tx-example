package com.javatechie.spring.tx;

import com.javatechie.spring.tx.dto.BookingAcknowledgement;
import com.javatechie.spring.tx.dto.FlightBookingRequest;
import com.javatechie.spring.tx.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
@RequestMapping("/flight")
public class DemoApplication {
    @Autowired
    private FlightBookingService service;

    @PostMapping("/booking")
    public BookingAcknowledgement purchase(@RequestBody FlightBookingRequest request) throws Exception {
        return service.bookTicket(request);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
