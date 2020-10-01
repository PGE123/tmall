package com.how2java.tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.Review;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ReviewService;

@Service
public class ReviewServiceImpl extends BaseServiceImpl implements ReviewService{
	
	
	@Autowired
	OrderService orderService;
	
	@Override
	public void saveReviewAndUpdateOrderStatus(Review review, Order order) {
		save(review);
		orderService.update(order);
	}
}
