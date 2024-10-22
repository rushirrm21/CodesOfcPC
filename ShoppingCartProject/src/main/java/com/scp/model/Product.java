package com.scp.model;

public class Product {

	private int pId;
	private String pName;
	private int pUnitPrice;
	
	public Product(int pId, String pName, int pUnitPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pUnitPrice = pUnitPrice;
	}
	public Product() {
		super();
	}

	public int getpUnitPrice() {
		return pUnitPrice;
	}
}
