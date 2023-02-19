package com.revature.poms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.poms.daoImpl.CancelOrderDaoImpl;
import com.revature.poms.daoImpl.OrderDaoImpl;
import com.revature.poms.model.CancelOrder;

/**
 * Servlet implementation class CancelledList
 */
@WebServlet("/CancelledList")
public class GetCancelOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCancelOrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CancelOrderDaoImpl impl = new CancelOrderDaoImpl();
			for(CancelOrder order:impl.getCancelDetails()) {
				System.out.println(order);
			}
 			request.setAttribute("CANCEL_DETAIL", impl.getCancelDetails());
			request.getRequestDispatcher("CancelList.jsp").forward(request, response);
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
