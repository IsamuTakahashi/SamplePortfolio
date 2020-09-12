package model;

import dao.OrderDAO;

public class GetOrderLogic {

	public Order execute(int id) {
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findOrderById(id);
		return order;
	}
}
