package com.chen.factory_method.pizza;

import com.chen.factory_method.ingredient.PizzaIngredientFactory;

/**
 * @author ChenJunQuan
 * @version 2014-3-25 上午11:55:03
 */
public class ClamPizza extends Pizza {
	PizzaIngredientFactory pizzaIngredientFactory;
	public ClamPizza() {
		// TODO Auto-generated constructor stub
	}
	public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory){
		this.pizzaIngredientFactory = pizzaIngredientFactory;
	}
	@Override
	void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing "+ name);
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
	}

}
