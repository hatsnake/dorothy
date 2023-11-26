package com.ucamp.dorothy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Coupon;
import com.ucamp.dorothy.mapper.CouponMapper;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponMapper couponMapper;

	@Override
	public List<Coupon> selectCouponList() throws Exception {

		return couponMapper.selectCouponList();
	}


}
