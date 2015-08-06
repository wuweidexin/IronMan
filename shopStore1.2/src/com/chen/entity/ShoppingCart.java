package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {
	
	private int id;

	private double totalPrice;//�ܼ�
	private Customer customer;//�˹�ϵ�����ﳵ�Ϳͻ���һ��һ����
	private Set<Book> book = new HashSet<Book>();//�ι�ϵ�����ﳵ�����һ�Զ����
	private String shoppingCartID;
	
	public String getShoppingCartID() {
		return shoppingCartID;
	}
	public void setShoppingCartID(String shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
}
