package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Order;
import model.SQLBuilder;

public class OrderDAO {

	private final String JDBC_URL =
			"jdbc:mysql://localhost/netShopSystemdb";
	private final String JDBC_USER = "root";
	private final String JDBC_PASS = "12345678";


	//この『insertOrderメソッド』は、注文情報をデータベースに登録します。
	public void insertOrder(Order order) {


		//『SQLBuilder』はSQL文を作るだけのクラスです。
		//処理が複雑になってしまったので別のクラスにまとめました。
		SQLBuilder builder = new SQLBuilder();


		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);


			conn.setAutoCommit(false);


			PreparedStatement pStmt1 =
					conn.prepareStatement(builder.orderHistorySQLBuild(order));
			PreparedStatement pStmt2 =
					conn.prepareStatement(builder.orderQuantitySQLBuild(order));


			//『order_historyテーブル』に、注文履歴を登録
			pStmt1.executeUpdate();
			//『order_quantityテーブル』に、注文内容を登録
			pStmt2.executeUpdate();
			conn.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
