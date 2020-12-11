package com.javatechie.spring.tx.utils;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    //CREATE A PAYMENT MAP
    public static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 2000.0);
        paymentMap.put("acc2", 1000.0);
        paymentMap.put("acc3", 500.0);
        paymentMap.put("acc4", 12000.0);

    }

    public static boolean validateCreditLimit(String accountNumber, double payAmount) throws Exception {
        if (payAmount > paymentMap.get(accountNumber)) {
            throw new Exception("InSufficient fund");
        } else {
            return true;
        }
    }
}
