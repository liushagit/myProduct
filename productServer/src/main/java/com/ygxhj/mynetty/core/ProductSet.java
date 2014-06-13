package com.ygxhj.mynetty.core;

import java.util.Map;

import org.jboss.netty.util.internal.ConcurrentHashMap;

import com.ygxhj.mynetty.core.model.Product;

public class ProductSet {
	
	private static final ProductSet instance = new ProductSet();

	private ProductSet(){}
	public static ProductSet getInstance() {
		return instance;
	}
	
	
	private Map<String, Product> productSet = new ConcurrentHashMap<String, Product>();
	
	public Product getProduct(String productId){
		if (productSet.containsKey(productId)) {
			return productSet.get(productId);
		}
		return null;
	}
	
	public void addProduct(Product product){
		if (product == null) {
			return;
		}
		productSet.put(product.getProductId(), product);
	}

}
