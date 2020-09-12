package model;

import java.time.LocalDateTime;
import java.util.List;

import dao.OrderDAO;

public class GetShipmentListLogic {

	public List<Order> execute(LocalDateTime now, LocalDateTime timeLimit) {
		OrderDAO orderDAO = new OrderDAO();
		List<Order> shipmentList = orderDAO.findShipmentList(now, timeLimit);
		return shipmentList;
	}
}
