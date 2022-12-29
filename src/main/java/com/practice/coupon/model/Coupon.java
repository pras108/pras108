package com.practice.coupon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {

    @Id
    private Integer id;

    @Column
    private String code;
}
