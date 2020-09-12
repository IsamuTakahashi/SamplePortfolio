package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLBuilder {

	public String orderQuantitySQLBuild(Order order) {

		Map<String, Vegetable[]> basket = order.getBasket();

		List<Integer> quantity = new ArrayList<>();
		String sql = "insert into order_quantity(";
		for(Vegetable[] vegBox : basket.values()) {
			sql += vegBox[0].getName() + ",";
			quantity.add(vegBox.length);
		}
		sql += "sum) values (";
		for(int i = 0; i < quantity.size(); i++) {
			sql += quantity.get(i) + ",";
		}
		sql += order.getSum() + ");";

		return sql;
	}
	public String orderHistorySQLBuild(Order order) {

		String date = "'" + order.getDate() + "'";
		String name = "'" + order.getName() + "'";
		String mail = "'" + order.getMail() + "'";
		String phone = "'" + order.getPhone() + "'";
		String address = "'" + order.getAddress() + "'";

		String sql = "insert into order_history(date, name, mail, phone, address) values("
				+ date + ","
				+ name + ","
				+ mail + ","
				+ phone + ","
				+ address + ");";

		return sql;
	}
}
