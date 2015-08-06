package com.chen.factory;
/**
 * @author ChenJunQuan
 * @version 2014-3-25 上午11:41:35
 */
public abstract class PizzaStore {
//	SimplePizzaFactory simplePizzaFactory;
//	public PizzaStore(SimplePizzaFactory simplePizzaFactory){
//		this.simplePizzaFactory = simplePizzaFactory;
//	}
	
//	public Pizza orderPizza(String type){
//		Pizza pizza;
//		pizza = simplePizzaFactory.createPizza(type);
//		pizza.prepare();
//		pizza.bake();
//		pizza.cut();
//		pizza.box();
//		return pizza;
//	}
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
