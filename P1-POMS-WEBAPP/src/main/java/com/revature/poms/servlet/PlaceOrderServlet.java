package com.revature.poms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.poms.daoImpl.OrderDaoImpl;
import com.revature.poms.daoImpl.OrderedItemDaoImpl;
import com.revature.poms.model.Order;
import com.revature.poms.model.OrderedItem;
import com.revature.poms.util.OrderUtility;

/**
 * Servlet implementation class PlcaeOrderServlet
 */
@WebServlet("/order")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNum= request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		String[] values = request.getParameterValues("1"); 
		for(String value:values)
			totalPrice += Integer.parseInt(value.split(" ")[1]);
		Order order = new Order(name, mobileNum, address, status, totalPrice, email);
		int orderId = -1;
		try {
			OrderDaoImpl impl = new OrderDaoImpl();
			orderId = impl.addOrderDetails(order);
			OrderedItemDaoImpl imItemDaoImpl = new OrderedItemDaoImpl(orderId);
			for(String value:values) {
				OrderedItem item = new OrderedItem();
				item.setId(orderId);
				item.setItemName(value.split(" ")[0]);
				item.setPrice(Integer.parseInt(value.split(" ")[1]));
				imItemDaoImpl.addItemDetails(item);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		response.sendRedirect("order.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
