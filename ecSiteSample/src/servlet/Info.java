package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetVeggiesLogic;
import model.Vegetable;

@WebServlet("/Info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//HOAM画面に表示する野菜のデータを取得して、リクエストスコープに保存します。
		GetVeggiesLogic getVeggiesLogic =
				new GetVeggiesLogic();
		Map<String, Vegetable> veggies = getVeggiesLogic.execute();
		request.setAttribute("veggies", veggies);



		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/info.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
