package com.practice.controller;

import com.practice.coupon.model.Coupon;
import com.practice.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CouponController {

    @Autowired
    CouponService couponService;

    @GetMapping("/coupons")
    public ResponseEntity<String> getAllCoupons() {
        List<Coupon> coupons = couponService.getAllCoupons();
        log.info("size of coupon list: {}", coupons.size());
        return new ResponseEntity<>(coupons.toString(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> throwGenericException(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
