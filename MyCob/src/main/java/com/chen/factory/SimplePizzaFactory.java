package com.chen.factory;
/**
 * @author ChenJunQuan
 * @version 2014-3-25 上午11:41:11
 */
public class SimplePizzaFactory {
	public Pizza createPizza(String type){
		Pizza pizza = null;
		if(type.equals("cheese")){
			pizza = new CheesePizza();
		}else if(type.equals("clam")){
			pizza  = new ClamPizza();
		}
		return pizza;
	}

}
