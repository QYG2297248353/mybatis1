package com.ms.pojo;

/**
 * 对应表Product_
 * 
 * @author Ms
 *
 */
public class Product {
	private int id;
	private String name;
	private float price;
	private Category category;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// 重构tostring
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
