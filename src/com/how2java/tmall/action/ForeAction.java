package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

public class ForeAction extends Action4Result{
	String msg;
	
	@Action("forehome")
	public String home(){
		categorys = categoryService.list();
		productService.fill(categorys);
		productService.fillByRow(categorys);
		return "home.jsp";
	}
	
	@Action("foreregister")
	public String register(){
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		boolean isExist = userService.isExist(user.getName());
		if(!isExist){
			msg = "用户名已经存在，不能使用";
			return "register.jsp";
		}
		userService.save(user);
		return "registerSuccessPage";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
