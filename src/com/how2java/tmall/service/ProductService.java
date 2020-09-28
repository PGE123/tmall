package com.how2java.tmall.service;
 
import java.util.List;
 
import com.how2java.tmall.pojo.Category;
 
public interface ProductService extends BaseService {
    public void fill(List<Category> categorys);
    public void fill(Category category);
    public void fillByRow(List<Category> categorys);
}