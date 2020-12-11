package com.javatechie.spring.tx.repository;

import com.javatechie.spring.tx.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Integer> {
}
