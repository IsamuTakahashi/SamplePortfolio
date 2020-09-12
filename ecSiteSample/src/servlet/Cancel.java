package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Vegetable;

/**
 * Servlet implementation class Cancel
 */
@WebServlet("/Cancel")
public class Cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		//キャンセルする野菜の名前を取得します。
		String vegName = request.getParameter("vegName");


		//『Map<String, Vegetable[]> インスタンス』の『basket』は、カートの中身を表します。
		//指定された野菜をカートから削除。
		HttpSession session = request.getSession();
		Map<String, Vegetable[]> basket =
				(Map<String, Vegetable[]>)session.getAttribute("basket");
		basket.remove(vegName);


		//削除したあと再びセッションスコープに保存します。
		session.setAttribute("basket", basket);


		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/basket.jsp");
		dispatcher.forward(request, response);

	}
}
