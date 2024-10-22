package com.scp.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Product> cart;
	
	public void addProduct(Product product) {
		if(cart==null) {
			cart=new ArrayList<>();
		}
		cart.add(product);
	}
	
	public boolean removeProduct(Product product) throws NullPointerException  {
		if(cart==null) {
			throw new NullPointerException("cart is empty");
		}
		return cart.remove(product);
	}

	public List<Product> getAllProduct(){
		return cart;
	}
	
	public int calculateTotalPrice()throws NullPointerException {
		int tot=0;
		if(cart==null) {
			throw new NullPointerException("cart is empty");
		}
		
		for(Product p: cart) {
			tot=tot+p.getpUnitPrice();
		}
		return tot;
	}
}
