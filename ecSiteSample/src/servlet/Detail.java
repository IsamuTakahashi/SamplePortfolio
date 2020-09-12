package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetSelectedVegetableLogic;
import model.Vegetable;

@WebServlet("/Detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータを取得します。
		//このパラメータでクリックされた野菜を識別します。
		String vegName = request.getParameter("vegName");


		//データベースにアクセスして、クッリクされた野菜のデータを取り出します。
		GetSelectedVegetableLogic getSelectedVegetableLogic =
				new GetSelectedVegetableLogic();
		Vegetable veg = getSelectedVegetableLogic.execute(vegName);

		//クリックされた野菜のデータをリクエストスコープに保存します。
		//この保存されたデータは、"detail.jsp"で野菜の詳細情報を表示するため利用されます。
		request.setAttribute("veg", veg);


		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp");
		dispatcher.forward(request, response);

	}
}
