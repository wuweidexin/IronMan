package com.chen.factory_method;

import com.chen.factory_method.pizza.NYPizzaStore;
import com.chen.factory_method.pizza.Pizza;
import com.chen.factory_method.pizza.PizzaStore;

/**
 * @author ChenJunQuan
 * @version 2014-3-25 下午2:19:22
 */
public class PizzaTestDriver {
	public static void main(String[] args) {
		PizzaStore nyPizzaStore = new NYPizzaStore();
		Pizza pizza = nyPizzaStore.orderPizza("cheese");
		System.out.println("Jom ordered a " + pizza.getName());
	}
}
