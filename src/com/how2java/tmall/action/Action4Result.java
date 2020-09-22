package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results(
		{
			/*分类管理*/	
			@Result(name="listCategory", location="/admin/listCategory.jsp"),
			@Result(name="editCategory", location="/admin/editCategory.jsp"),
			@Result(name="listCategoryPage", type="redirect", location="/admin/listCategory.jsp"),
			/*属性管理*/
			@Result(name="listProperty", location="/admin/listProperty.jsp"),
			@Result(name="editProperty", location="/admin/editProperty.jsp"),
			@Result(name="listPropertyPage", type="redirect", location="admin_property_list?category"
					+ ".id=${property.category.id}"),
			/*产品管理*/
			@Result(name="listProduct", location="/admin/listProduct.jsp"),
			@Result(name="listProductPage",type="redirect",location="admin_product_list?category"
					+ ".id=${product.category.id}"),
			@Result(name="editProduct",location="/admin/editProduct.jsp"),
			/*产品图片管理*/
			@Result(name="listProductImage",location="/admin/listProductImage.jsp"),
			@Result(name="listProductImagePage",type="redirect",location="admin_productImage_list?"
					+ "product.id=${productImage.product.id}"),
			/*属性值管理*/
			@Result(name="editPropertyValue",location="/admin/editPropertyValue.jsp"),
			/*用户管理*/
			@Result(name="listUser",location="/admin/listUser.jsp"),
			/*订单管理*/
			@Result(name="listOrder",location="/admin/listOrder.jsp"),
			@Result(name="listOrderPage",type="redirect",location="/admin_order_list"),
			
			/*前台 服务端跳转*/
			@Result(name="home.jsp",location="/home.jsp"),
			@Result(name="register.jsp",location="/register.jsp"),
			/*前台 客户端跳转*/
			@Result(name="registerSuccessPage",type="redirect",location="/registerSuccess.jsp"),
			
			
		}
		)
public class Action4Result extends Action4Parameter {
	
}
