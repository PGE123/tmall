package com.how2java.tmall.action;

import java.lang.reflect.Method;

import org.apache.commons.lang.xwork.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.service.CategoryService;

public class Action4Service extends Action4Pojo {
	@Autowired
	CategoryService categoryService;
	
	public void t2p(Object o){
		try{
			Class clazz = o.getClass();
			int id = (Integer) clazz.getMethod("getId").invoke(o);
			Object persistentBean = categoryService.get(clazz,id);
			String beanName = clazz.getSimpleName();
			Method setMethod = getClass().getMethod("set"+WordUtils.capitalize(beanName), clazz);
			setMethod.invoke(this, persistentBean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
