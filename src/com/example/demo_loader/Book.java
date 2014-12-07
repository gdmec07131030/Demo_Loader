package com.example.demo_loader;

public class Book {
    String id;
    String name;
    float price;
    String publisher;
	public Book() {
		super();
	}
	public Book(String id, String name, float price, String publisher) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.publisher = publisher;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", publisher=" + publisher + "]";
	}
    
}
