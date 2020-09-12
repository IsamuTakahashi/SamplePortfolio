package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Vegetable;

public class VegetablesDAO {

	private final String JDBC_URL =
			"jdbc:mysql://localhost/netShopSystemdb";
	private final String JDBC_USER = "root";
	private final String JDBC_PASS = "12345678";


	//この『findAllメソッド』はデータベース『vegetablesテーブル』の全てのレコードを取得して、それをMapにして返します。
	//『Vegetableクラス』は、取得したレコードの一行分を表します。
	public Map<String, Vegetable> findAll() {


		Map<String, Vegetable> veggies = new HashMap<>();


		//データベースに接続。
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
			String sql = "SELECT * FROM vegetables";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();


			//取得したデータを元に、『Vegetableインスタンス』を生成して、
			//findAll()メソッドの戻り値、『veggies』に追加。
			//レコードの数だけ繰り返します。
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String season = rs.getString("season");
				int price = rs.getInt("price");
				String taste = rs.getString("taste");
				String ex = rs.getString("ex");

				Vegetable veg = new Vegetable(id, name, season, price, taste, ex);
				veggies.put(name, veg);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return veggies;
	}
}








