package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private int id;
	private String cusName;//客户姓名
	private String cusPassword;//客户密码
	
	private String cusTelephone;//客户电话
	private String cusAddress;//客户地址
	private String cusMail;//客户邮件
	private String cusPostCode;//客户邮编
	
	private ShoppingCart shoppingCart;//购物车
	private Set<Order> orders  = new HashSet<Order>();//订单
	
	private String cusID;
	private String question;
	private String answer;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getCusID() {
		return cusID;
	}
	public void setCusID(String cusID) {
		this.cusID = cusID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//下面是这些属性的get和set的方法
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusPassword() {
		return cusPassword;
	}
	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}
	public String getCusTelephone() {
		return cusTelephone;
	}
	public void setCusTelephone(String cusTelephone) {
		this.cusTelephone = cusTelephone;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public String getCusMail() {
		return cusMail;
	}
	public void setCusMail(String cusMail) {
		this.cusMail = cusMail;
	}
	public String getCusPostCode() {
		return cusPostCode;
	}
	public void setCusPostCode(String cusPostCode) {
		this.cusPostCode = cusPostCode;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
