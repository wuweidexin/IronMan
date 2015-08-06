package com.chen.factory_method.ingredient;

import com.chen.factory_method.material.Cheese;
import com.chen.factory_method.material.Clam;
import com.chen.factory_method.material.FreshClams;
import com.chen.factory_method.material.ReggianoCheese;

/**
 * @author ChenJunQuan
 * @version 2014-3-25 下午3:31:24
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Cheese createCheese() {
		// TODO Auto-generated method stub
		return new ReggianoCheese();
	}

	@Override
	public Clam createClam() {
		// TODO Auto-generated method stub
		return new FreshClams();
	}

	@Override
	public Dough createDough() {
		// TODO Auto-generated method stub
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new MarinaraSouce();
	}

}
