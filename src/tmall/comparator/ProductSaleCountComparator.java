package tmall.comparator;

import java.util.Comparator;

import com.how2java.tmall.pojo.Product;

public class ProductSaleCountComparator implements Comparator<Product>{
	@Override
	public int compare(Product p1,Product p2){
		return p1.getSaleCount()-p2.getSaleCount();
	}

}
