package com.ucamp.dorothy.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucamp.dorothy.domain.Coupon;
import com.ucamp.dorothy.domain.Item;
import com.ucamp.dorothy.domain.Order;
import com.ucamp.dorothy.domain.Payment;
import com.ucamp.dorothy.domain.Point;
import com.ucamp.dorothy.service.CouponService;
import com.ucamp.dorothy.service.ItemService;
import com.ucamp.dorothy.service.OrderService;
import com.ucamp.dorothy.service.PaymentService;
import com.ucamp.dorothy.service.PointService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private CouponService couponService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private PointService pointService;


    @GetMapping
    public String showPaymentForm(Model model) throws Exception {
        // 쿠폰
        List<Coupon> coupons = couponService.selectCouponList();
        
        model.addAttribute("couponList", coupons);
        
        log.info("보유 쿠폰 : " + coupons);
        

        // 포인트
        List<Point> pointList = pointService.selectPointList();
        
        Point selectedPoint = (pointList != null && !pointList.isEmpty()) ? pointList.get(0) : null;
        
        model.addAttribute("selectedPoint", selectedPoint);
        
        int holdingPoints = (selectedPoint != null) ? selectedPoint.getPrice() : 0;
        
        model.addAttribute("holdingPoints", holdingPoints);
        
        log.info("보유 포인트 : " + pointList);
        
        
        // 아이템
        List<Item> itemList = itemService.selectItemList();
        
        int totalAmount = itemService.calculateTotalAmount(itemList);
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String formattedDate = currentDate.format(formatter);
        
        model.addAttribute("currentDate", formattedDate);
        model.addAttribute("list", itemList);
        model.addAttribute("totalAmount", totalAmount);
        
        log.info("보유 아이템 : " + itemList);

        return "payment/paymentForm";
    }
	




}
