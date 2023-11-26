package com.ucamp.dorothy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.dorothy.domain.Coupon;

@Mapper
public interface CouponMapper {
	public List<Coupon> selectCouponList() throws Exception;

}
