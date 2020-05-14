package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.dao.impl.DAOImpl;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired DAOImpl dao;
	
	@Override
	public List list(){
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}
}
