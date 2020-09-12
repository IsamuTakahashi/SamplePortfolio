package model;

import java.util.Map;

import dao.VegetablesDAO;

public class GetSelectedVegetableLogic {

	public Vegetable execute(String vegName) {
		VegetablesDAO dao = new VegetablesDAO();
		Map<String, Vegetable> veggies = dao.findAll();
		Vegetable veg = veggies.get(vegName);

		return veg;
	}
}
