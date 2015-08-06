package com.chen.test;
/**
 * @author ChenJunQuan
 * @version 2014-3-24 下午4:38:50
 */
public class Mocha extends CondimentDecorator{
	Beverage beverage;
	public Mocha() {
		// TODO Auto-generated constructor stub
	}
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .20 + beverage.cost();
	}

}
