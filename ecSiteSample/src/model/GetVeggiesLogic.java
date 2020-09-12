package model;

import java.util.Map;

import dao.VegetablesDAO;

public class GetVeggiesLogic {

	public Map<String, Vegetable> execute() {
		VegetablesDAO dao = new VegetablesDAO();
		Map<String, Vegetable> veggies = dao.findAll();

		return veggies;
	}
}
