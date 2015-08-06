package com.chen.test;
/**
 * @author ChenJunQuan
 * @version 2014-3-24 下午4:56:55
 */
public class Whip extends CondimentDecorator {
	Beverage beverage;
	public Whip(Beverage beverage) {
		// TODO Auto-generated constructor stub
		this.beverage = beverage;
	}
	
	public Whip(){}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ",Whip";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .10 + beverage.cost();
	}

}
