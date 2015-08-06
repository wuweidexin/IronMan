package com.chen.factory_method.ingredient;

import com.chen.factory_method.material.Cheese;
import com.chen.factory_method.material.Clam;

/**
 * @author ChenJunQuan
 * @version 2014-3-25 下午3:28:58
 */
public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Clam createClam();
}
