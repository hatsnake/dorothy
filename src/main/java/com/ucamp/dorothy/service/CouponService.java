package com.ucamp.dorothy.service;

import java.util.List;

import com.ucamp.dorothy.domain.Coupon;

public interface CouponService {

	List<Coupon> selectCouponList() throws Exception;

}
