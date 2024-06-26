package com.wirecard.myspring.domain;

public class Product {
	private String code;
	private String name;
	private String type;
	private int price;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
	
}
