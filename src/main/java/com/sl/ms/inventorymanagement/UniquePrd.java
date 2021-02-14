package com.sl.ms.inventorymanagement;

public class UniquePrd {
	
	private int productid;	
	private String name;
	
	public UniquePrd(int productid, String name) {
		super();
		this.productid = productid;
		this.name = name;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
