package model;

import dao.OrderDAO;

public class PostOrderLogic {

	public void execute(Order order) {

		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insertOrder(order);
	}
}
