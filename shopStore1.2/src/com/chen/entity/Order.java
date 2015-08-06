package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

public class Order {
	
	private int id;
	
	private double totalPrice;//总价
	private double carriagePaid;//运费
	private String orderTime;//订货时间
	private String deliveryMethod;//配送方式
	private int orderState;
	
	
	private String recieverOphone;
	private String recieverAddress;
	private Set<Book> book = new HashSet<Book>();
	private String orderID;
	private String recieverName;
	private String moneySendMethod;//支付方式
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getMoneySendMethod() {
		return moneySendMethod;
	}
	public void setMoneySendMethod(String moneySendMethod) {
		this.moneySendMethod = moneySendMethod;
	}
	public String getRecieverName() {
		return recieverName;
	}
	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
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
	public double getCarriagePaid() {
		return carriagePaid;
	}
	public void setCarriagePaid(double carriagePaid) {
		this.carriagePaid = carriagePaid;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getRecieverOphone() {
		return recieverOphone;
	}
	public void setRecieverOphone(String recieverOphone) {
		this.recieverOphone = recieverOphone;
	}
	public String getRecieverAddress() {
		return recieverAddress;
	}
	public void setRecieverAddress(String recieverAddress) {
		this.recieverAddress = recieverAddress;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
	
}
