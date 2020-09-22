package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.how2java.tmall.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	@Override
	public boolean isExist(String name) {
		List l = list("name",name);
		if(!l.isEmpty())
			return true;
		return false;
	}

}
