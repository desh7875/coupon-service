package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class CouponServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApplication.class, args);
    }

    @GetMapping("/coupon")
    public String getCoupon() {
        performCpuIntensiveTask();
        return "COUPON-" + new Random().nextInt(10000);
    }

    private void performCpuIntensiveTask() {
        int count = 0;
        for (int i = 2; i < 50000; i++) {
            if (isPrime(i)) count++;
        }
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
