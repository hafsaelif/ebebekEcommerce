package com.ebebek.models;

public class Product {

	public String id;
	public String name;
	public String details;
	public String imageName;
	public double price;

	public Product(String id, String name, String details, String imageName, double price) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.imageName = imageName;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {		
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
