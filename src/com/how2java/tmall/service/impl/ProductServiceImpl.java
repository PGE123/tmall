package com.how2java.tmall.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
 
@Service
public class ProductServiceImpl  extends BaseServiceImpl implements ProductService {
 
    @Autowired
    ProductImageService productImageService;
     
    public void fill(List<Category> categorys) {
        for (Category category : categorys) {
            fill(category);
        }
    }
 
    @Override
    public void fillByRow(List<Category> categorys) {
        int productNumberEachRow = 8;
        for (Category category : categorys) {
            List<Product> products =  category.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
             
            category.setProductsByRow(productsByRow);
        }
    }
     
    @Override
    public void fill(Category category) {
        List<Product> products= listByParent(category);
         
        for (Product product : products)
            productImageService.setFirstProductImage(product);
         
        category.setProducts(products);
         
    }  
}