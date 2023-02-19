package com.revature.poms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.poms.daoImpl.CancelOrderDaoImpl;
import com.revature.poms.daoImpl.OrderDaoImpl;
import com.revature.poms.daoImpl.OrderedItemDaoImpl;
import com.revature.poms.model.CancelItem;
import com.revature.poms.model.CancelOrder;
import com.revature.poms.model.Order;
import com.revature.poms.model.OrderedItem;
import com.revature.poms.util.OrderUtility;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/delete")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		try {
			int orderId = Integer.parseInt(request.getParameter("cancelId"));
			String message = request.getParameter("reason");
				
			OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
			Order order = orderDaoImpl.getOrderById(orderId);
				
			CancelOrder cancelOrder = new CancelOrder();
			cancelOrder.setCancelReason(message);
			cancelOrder.setContacts(order.getCustomerContact());
			cancelOrder.setDate(OrderUtility.getDate());
			cancelOrder.setName(order.getCustomerName());	
			cancelOrder.setPrice(order.getPrice());
			
			CancelOrderDaoImpl cancelOrderDaoImpl = new CancelOrderDaoImpl();
			int cancelId = cancelOrderDaoImpl.addCancelOrder(cancelOrder);
			
			OrderedItemDaoImpl impl = new OrderedItemDaoImpl(orderId);
			ArrayList<OrderedItem> itemList =  (ArrayList<OrderedItem>)impl.getOrderedItem();
			
			for(OrderedItem items:itemList) {
				CancelItem cancelItem = new CancelItem();
				cancelItem.setCancelId(cancelId);
				cancelItem.setItemName(items.getItemName());
				cancelItem.setPrice(items.getPrice());
				cancelOrderDaoImpl.addCancelItem(cancelItem);
			}
			impl.deleteItemDetails();		
			orderDaoImpl.deleteOrderDetails(orderId);
			request.setAttribute("CANCEL_DETAIL",cancelOrderDaoImpl.getCancelDetails());
			request.getRequestDispatcher("CancelList.jsp").forward(request, response);
		}catch (SQLException  e) {
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
