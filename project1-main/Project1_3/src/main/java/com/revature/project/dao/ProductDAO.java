package com.revature.project.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.revature.project.model.Product;

public class ProductDAO {

	
	private static List<Product> products = new ArrayList<Product>(Arrays.asList(new Product(0, "Product A", 20.00, null),
			new Product(1, "Product B", 35.00, null), new Product(2, "Product C", 100.00, null)));

			
			public static Iterable<Product> getAllProducts() {
				return products;
			}
			
			public static Product getProductByName(String productName) {
				return products.stream().filter(p -> p.getProductName().equals(productName)).findFirst().orElse((null));
			}
			
			public static Product getRandomProduct() {
				return products.get(new Random().nextInt(products.size()));
			}

	
	
}
