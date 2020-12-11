package com.javatechie.spring.tx.repository;

import com.javatechie.spring.tx.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentInfo,Integer> {
}
