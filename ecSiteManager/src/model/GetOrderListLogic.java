package model;

import java.util.List;

import dao.OrderDAO;

public class GetOrderListLogic {

	public List<Order> execute() {

		OrderDAO orderDAO = new OrderDAO();
		List<Order> orderList = orderDAO.findAll();
		return orderList;
	}
}
