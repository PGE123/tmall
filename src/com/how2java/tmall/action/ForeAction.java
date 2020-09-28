package com.how2java.tmall.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;
 
import com.how2java.tmall.pojo.User;
import com.opensymphony.xwork2.ActionContext;
 
public class ForeAction extends Action4Result {
    @Action("forelogout")
    public String logout() {
        ActionContext.getContext().getSession().remove("user");
        return "homePage"; 
    }
     
    @Action("forelogin")
    public String login() {
        user.setName(HtmlUtils.htmlEscape(user.getName()));
        User user_session = userService.get(user.getName(),user.getPassword());
        if(null==user_session){
            msg= "账号密码错误";
            return "login.jsp";
        }
        ActionContext.getContext().getSession().put("user", user_session);
        return "homePage";     
    }
     
    @Action("foreregister")
    public String register() {
        user.setName(HtmlUtils.htmlEscape(user.getName()));
        boolean exist = userService.isExist(user.getName());
       
         if(exist){
             msg = "用户名已经被使用,不能使用";
             return "register.jsp"; 
         }
         userService.save(user);
         return "registerSuccessPage";
    }  
    @Action("forehome")
    public String home() {
        categorys = categoryService.list();
        productService.fill(categorys);
        productService.fillByRow(categorys);
        return "home.jsp";
    }
}