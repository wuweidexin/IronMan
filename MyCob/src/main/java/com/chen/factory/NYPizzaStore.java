package com.chen.factory;
/**
 * @author ChenJunQuan
 * @version 2014-3-25 下午12:01:32
 */
public class NYPizzaStore extends PizzaStore{

	@Override
	Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		if(type.equals("cheese")){
			pizza = new CheesePizza();
		}else if(type.equals("clam")){
			pizza  = new ClamPizza();
		}
		return pizza;
	}

}
