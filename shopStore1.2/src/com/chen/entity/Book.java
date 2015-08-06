package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

public class Book {
	private int id;
	private String bookName;//����
	private String author;//����
	private String press;//�汾
	private String version;//���
	private int count;//���
	private String bookSort;//������
	private double price;
	private Set<Order> orders =  new HashSet<Order>();
	private Set<ShoppingCart> shoppingCart = new HashSet<ShoppingCart>();

	private String bookID;
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	//��������Щ���Ե�get��set�ķ���
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBookSort() {
		return bookSort;
	}
	public void setBookSort(String bookSort) {
		this.bookSort = bookSort;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<ShoppingCart> getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(Set<ShoppingCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
}
