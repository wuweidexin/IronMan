package com.chen.factory_method.pizza;

import com.chen.factory_method.ingredient.PizzaIngredientFactory;

/**
 * @author ChenJunQuan
 * @version 2014-3-25 上午11:53:39
 */
public class CheesePizza extends Pizza {
	PizzaIngredientFactory pizzaIngredientFactory;
	public CheesePizza() {
		// TODO Auto-generated constructor stub
	}
	public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
		// TODO Auto-generated constructor stub
		this.pizzaIngredientFactory = pizzaIngredientFactory;
	}

	@Override
	void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing  " +  name);
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		
	}
}
