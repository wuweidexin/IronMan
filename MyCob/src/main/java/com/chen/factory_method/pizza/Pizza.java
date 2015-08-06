package com.chen.factory_method.pizza;

import com.chen.factory_method.ingredient.Dough;
import com.chen.factory_method.ingredient.Sauce;
import com.chen.factory_method.material.Cheese;
import com.chen.factory_method.material.Clam;


/**
 * @author ChenJunQuan
 * @version 2014-3-25 上午11:42:32
 */
public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Cheese cheese;
	Clam clas;
	
	abstract void prepare();
	
	void bake(){
		System.out.println("Bake for 25 minutes at 350");
	}
	
	void cut(){
		System.out.println("Cutting the pizza into diagnal slies");
	}
	
	void box(){
		System.out.println("Palce the pizza in offical PizzaStore box");
	}
	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
