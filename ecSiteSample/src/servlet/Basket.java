package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetSelectedVegetableLogic;
import model.Vegetable;

@WebServlet("/Basket")
public class Basket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		//リクエストパラメータを取得します。
		//このパラメータでクリックされた野菜と数量を識別します。
		String vegName = request.getParameter("vegName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));


		//データベースにアクセスして、クッリクされた野菜のデータを取り出します。
		GetSelectedVegetableLogic getSelectedVegetableLogic =
				new GetSelectedVegetableLogic();
		Vegetable veg = getSelectedVegetableLogic.execute(vegName);


		//箱を用意して、指定の数量だけ野菜を入れます。
		//（最終的に）※この箱をセッションスコープに保存します。
		Vegetable[] vegBox = new Vegetable[quantity];
		for(int i = 0; i < quantity ; i++) {
			vegBox[i] = veg.clone();
		}


		//セッションスコープに、
		//指定の数量の野菜が入った箱を追加します。
		//セッションスコープの内容は、カートの中身を表します。
		HttpSession session = request.getSession();
		Map<String, Vegetable[]> basket = (Map<String, Vegetable[]>) session.getAttribute("basket");
		if(basket == null) {
			basket = new HashMap<>();
		}
		basket.put(vegName, vegBox);
		session.setAttribute("basket", basket);


		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/basket.jsp");
		dispatcher.forward(request, response);

	}
}






