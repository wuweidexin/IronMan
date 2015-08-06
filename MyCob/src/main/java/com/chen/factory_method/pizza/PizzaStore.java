package com.chen.factory_method.pizza;



/**
 * @author ChenJunQuan
 * @version 2014-3-25 上午11:41:35
 */
public abstract class PizzaStore {

	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	abstract Pizza createPizza(String type);
}
