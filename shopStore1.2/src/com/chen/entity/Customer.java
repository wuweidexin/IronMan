package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private int id;
	private String cusName;//�ͻ�����
	private String cusPassword;//�ͻ�����
	
	private String cusTelephone;//�ͻ��绰
	private String cusAddress;//�ͻ���ַ
	private String cusMail;//�ͻ��ʼ�
	private String cusPostCode;//�ͻ��ʱ�
	
	private ShoppingCart shoppingCart;//���ﳵ
	private Set<Order> orders  = new HashSet<Order>();//����
	
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
	
	//��������Щ���Ե�get��set�ķ���
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
