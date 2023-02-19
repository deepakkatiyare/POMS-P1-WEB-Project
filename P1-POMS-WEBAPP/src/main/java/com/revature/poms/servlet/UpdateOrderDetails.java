package com.revature.poms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.poms.daoImpl.OrderDaoImpl;
import com.revature.poms.daoImpl.OrderedItemDaoImpl;
import com.revature.poms.model.Order;
import com.revature.poms.model.OrderedItem;

@WebServlet("/update")
public class UpdateOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalPrice = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNum= request.getParameter("contact");
		String address = request.getParameter("address");
		String status =  "confirmed";
		String[] values = request.getParameterValues("2"); 
		for(String value:values)
			totalPrice += Integer.parseInt(value.split(" ")[1]);
		Order order = new Order(name, mobileNum, address, status, totalPrice, email);
		try {
			OrderDaoImpl impl = new OrderDaoImpl();
			impl.updateOrderDetails(order, id);
			OrderedItemDaoImpl imItemDaoImpl = new OrderedItemDaoImpl(id);
			imItemDaoImpl.deleteItemDetails();
			for(String value:values) {
				OrderedItem item = new OrderedItem();
				item.setId(id);
				item.setItemName(value.split(" ")[0]);
				item.setPrice(Integer.parseInt(value.split(" ")[1]));
				imItemDaoImpl.addItemDetails(item);
			}
		} catch (SQLException e){ 
			e.printStackTrace();
		}
		try {
			OrderDaoImpl impl = new OrderDaoImpl();
			request.setAttribute("ORDER_DETAIL", impl.getOrderDetails());
			request.getRequestDispatcher("orderslist.jsp").forward(request, response);
		}catch (SQLException|ServletException|IOException e) {
			response.getWriter().print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
