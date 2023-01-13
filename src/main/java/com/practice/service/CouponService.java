package com.practice.service;

import com.practice.coupon.model.Coupon;
import com.practice.coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    CouponRepository couponRepository;


    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}
