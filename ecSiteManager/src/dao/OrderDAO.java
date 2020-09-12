package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Order;

public class OrderDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost/netShopSystemdb";
	private final String JDBC_USER = "root";
	private final String JDBC_PASS = "12345678";

	public List<Order> findAll() {
		List<Order> orderList = new ArrayList<>();


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
			String sql = "select * from order_history "
					+ "join order_quantity "
					+ "on order_history.id = order_quantity.id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String date = rs.getString("date").substring(0,10);
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Map<String, Integer> orderQuantity = new HashMap<>();
				orderQuantity.put("甘美人", rs.getInt("甘美人"));
				orderQuantity.put("兵庫絹莢", rs.getInt("兵庫絹莢"));
				orderQuantity.put("男爵イモ", rs.getInt("男爵イモ"));
				orderQuantity.put("ごろごろゴーヤ", rs.getInt("ごろごろゴーヤ"));
				orderQuantity.put("千両茄子", rs.getInt("千両茄子"));
				orderQuantity.put("四川きゅうり", rs.getInt("四川きゅうり"));
				orderQuantity.put("スイートコーン", rs.getInt("スイートコーン"));
				orderQuantity.put("グリーンリーフ", rs.getInt("グリーンリーフ"));
				orderQuantity.put("えびす南瓜", rs.getInt("えびす南瓜"));
				orderQuantity.put("桜島大根", rs.getInt("桜島大根"));
				orderQuantity.put("ミニパプリカ", rs.getInt("ミニパプリカ"));
				orderQuantity.put("ミニトマト", rs.getInt("ミニトマト"));

				Order order = new Order(id, date, name, mail,
						phone, address, orderQuantity);
				orderList.add(order);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;
	}
	public List<Order> findShipmentList(LocalDateTime now, LocalDateTime timeLimit) {
		List<Order> shipmentList = new ArrayList<>();


		String fromStr = "";
		String byStr = "";
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		if(now.isAfter(timeLimit)) {
			LocalDateTime from = timeLimit.minusDays(1);
			fromStr = from.format(formatter);
			byStr = timeLimit.format(formatter);
		} else {
			LocalDateTime from = timeLimit.minusDays(2);
			LocalDateTime by = timeLimit.minusDays(1);
			fromStr = from.format(formatter);
			byStr = by.format(formatter);
		}


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
			String sql = "select * from order_history "
					+ "join order_quantity "
					+ "on order_history.id = order_quantity.id";
			String conditional = " where date >= " + "'" + fromStr + "'"
								+ " and date < " + "'" + byStr + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql + conditional);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String date = "";
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Map<String, Integer> orderQuantity = new HashMap<>();
				orderQuantity.put("甘美人", rs.getInt("甘美人"));
				orderQuantity.put("兵庫絹莢", rs.getInt("兵庫絹莢"));
				orderQuantity.put("男爵イモ", rs.getInt("男爵イモ"));
				orderQuantity.put("ごろごろゴーヤ", rs.getInt("ごろごろゴーヤ"));
				orderQuantity.put("千両茄子", rs.getInt("千両茄子"));
				orderQuantity.put("四川きゅうり", rs.getInt("四川きゅうり"));
				orderQuantity.put("スイートコーン", rs.getInt("スイートコーン"));
				orderQuantity.put("グリーンリーフ", rs.getInt("グリーンリーフ"));
				orderQuantity.put("えびす南瓜", rs.getInt("えびす南瓜"));
				orderQuantity.put("桜島大根", rs.getInt("桜島大根"));
				orderQuantity.put("ミニパプリカ", rs.getInt("ミニパプリカ"));
				orderQuantity.put("ミニトマト", rs.getInt("ミニトマト"));

				Order order = new Order(id, date, name, mail,
						phone, address, orderQuantity);
				shipmentList.add(order);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shipmentList;
	}
	public Order findOrderById(int id) {
		Order order = null;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
			String sql = "select * from order_history "
								+ "join order_quantity "
								+ "on order_history.id = order_quantity.id ";
			String conditional = "where order_history.id = " + id;
			PreparedStatement pStmt = conn.prepareStatement(sql + conditional);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String date = rs.getString("date").substring(0,16);
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Map<String, Integer> orderQuantity = new HashMap<>();
				orderQuantity.put("甘美人", rs.getInt("甘美人"));
				orderQuantity.put("兵庫絹莢", rs.getInt("兵庫絹莢"));
				orderQuantity.put("男爵イモ", rs.getInt("男爵イモ"));
				orderQuantity.put("ごろごろゴーヤ", rs.getInt("ごろごろゴーヤ"));
				orderQuantity.put("千両茄子", rs.getInt("千両茄子"));
				orderQuantity.put("四川きゅうり", rs.getInt("四川きゅうり"));
				orderQuantity.put("スイートコーン", rs.getInt("スイートコーン"));
				orderQuantity.put("グリーンリーフ", rs.getInt("グリーンリーフ"));
				orderQuantity.put("えびす南瓜", rs.getInt("えびす南瓜"));
				orderQuantity.put("桜島大根", rs.getInt("桜島大根"));
				orderQuantity.put("ミニパプリカ", rs.getInt("ミニパプリカ"));
				orderQuantity.put("ミニトマト", rs.getInt("ミニトマト"));

				order = new Order(id, date, name, mail,
						phone, address, orderQuantity);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;
	}
}

