package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.PostOrderLogic;
import model.Vegetable;

@WebServlet("/Thanks")
public class Thanks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//ここでの処理は、リクエストパラメータとセッションスコープから注文に関する情報を取り出して
		//それを元に注文情報を表す『Order』オブジェクトを生成します。
		//そして、その『Order』オブジェクトを,データベースアクセス担当の『PostOrderLogic』インスタンスに渡して
		//データベースに注文情報を登録します。

		//最後にセッションスコープを破棄して,"thanks.jsp"にフォワードします。


		request.setCharacterEncoding("UTF-8");


		//『Order』オブジェクト生成のためのデータを取得。
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		int sum = Integer.parseInt(request.getParameter("sum"));
		String date;
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		date = now.plusHours(9).format(formatter);


		HttpSession session = request.getSession();
		Map<String, Vegetable[]> basket =
				(Map<String, Vegetable[]>) session.getAttribute("basket");


		//取得したデータを元に『Order』オブジェクトを生成。
		Order order = new Order(date, name, mail, phone, address, sum, basket);


		//データベースアクセス担当クラスに注文情報を渡して、
		//データベースに注文情報を登録。
		PostOrderLogic postOrderLogic = new PostOrderLogic();
		postOrderLogic.execute(order);
		//リクエストスコープの破棄。
		session.invalidate();


		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/thanks.jsp");
		dispatcher.forward(request, response);

	}
}






