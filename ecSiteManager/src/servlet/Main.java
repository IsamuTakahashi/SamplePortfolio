package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetOrderListLogic;
import model.GetShipmentListLogic;
import model.Order;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");


		List<Order> list = null;
		String label = "";
		if(action == null || action.equals("shipmentList")) {

			LocalDateTime now = LocalDateTime.now().plusHours(9);
			int year = now.getYear();
			int month = now.getMonth().getValue();
			int day = now.getDayOfMonth();
			LocalDateTime timeLimit = LocalDateTime.of(year, month, day, 17, 0, 0);


			int showMonth;
			int showDay;
			if(now.isAfter(timeLimit)){
				LocalDateTime tommorow = now.plusDays(1);
				showMonth = tommorow.getMonth().getValue();
				showDay = tommorow.getDayOfMonth();
			} else {
				showMonth = month;
				showDay = day;
			}

			 label = showMonth + "月" + showDay + "日の出荷リスト";
			 GetShipmentListLogic getShipmentListLogic = new GetShipmentListLogic();
			 list = getShipmentListLogic.execute(now, timeLimit);
		}
		else if(action.equals("orderList")) {

			label = "注文一覧";
			GetOrderListLogic getOrderListLogic = new GetOrderListLogic();
			list = getOrderListLogic.execute();
		}


		request.setAttribute("label", label);
		request.setAttribute("list", list);


		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}
}

