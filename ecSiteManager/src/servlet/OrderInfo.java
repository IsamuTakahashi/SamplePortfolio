package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetOrderLogic;
import model.Order;

@WebServlet("/OrderInfo")
public class OrderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");


		int id = Integer.parseInt(request.getParameter("id"));


		GetOrderLogic getOrderLogic = new GetOrderLogic();
		Order order = getOrderLogic.execute(id);


		request.setAttribute("order", order);


		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/orderInfo.jsp");
		dispatcher.forward(request, response);

	}
}
