package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.dao.impl.DAOImpl;
import com.how2java.tmall.service.BaseService;
import com.how2java.tmall.util.Page;

public class BaseServiceImpl extends ServiceDelegateDAO implements BaseService{
	
	@Autowired DAOImpl dao;
	
	protected Class clazz ;
	
	public static void main(String[] args) {
		new CategoryServiceImpl().showClass();
	}
	
	public void showClass(){
		System.out.println(clazz);
	}
	
	public BaseServiceImpl(){
		try{
			throw new Exception();
		}catch(Exception e){
			StackTraceElement stes[] = e.getStackTrace();
			String serviceImpleClassName = stes[1].getClassName();
			try{
				Class serviceImplClazz = Class.forName(serviceImpleClassName);
				String serviceImpleClassSimpleName = serviceImplClazz.getName();
				String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl","");
				String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
				String pojoFullName = pojoPackageName+"."+pojoSimpleName;
				clazz = Class.forName(pojoFullName);
				
			}catch(ClassNotFoundException e1){
				e1.printStackTrace();
			}
			
		}
	}
	
	
	@Override
	public Integer save(Object object) {
		return (Integer)super.save(object);
	}

	@Override
	public void update(Object object) {
		 update(object);
		
	}

	@Override
	public void delete(Object object) {
		 delete(object);
		
	}

	@Override
	public Object get(Class clazz, int id) {
		return super.get(clazz, id); 
	}

	@Override
	public Object get(int id) {
		return get(clazz, id);
	}

	@Override
	public List list() {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}

	@Override
	public List<Object> listByPage(Page page) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc,page.getStart(),page.getCount());
	}

	@Override
	public int total() {
		String hql = "select count(*) from" + clazz.getName();
		List<Long> l = find(hql);
		if(l.isEmpty())
			return 0;
		Long result = l.get(0);
		return result.intValue();
	}
	
	
}
