package com.chen.factory_method.pizza;

import com.chen.factory_method.ingredient.NYPizzaIngredientFactory;
import com.chen.factory_method.ingredient.PizzaIngredientFactory;


/**
 * @author ChenJunQuan
 * @version 2014-3-25 下午12:01:32
 */
public class NYPizzaStore extends PizzaStore{

	@Override
	Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
		if(type.equals("cheese")){
			pizza = new CheesePizza(pizzaIngredientFactory);
			pizza.setName("New York style Cheese Pizza");
		}else if(type.equals("clam")){
			pizza  = new ClamPizza(pizzaIngredientFactory);
		}
		return pizza;
	}

}
