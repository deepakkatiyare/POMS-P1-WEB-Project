package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.poms.model.Order;
public interface OrderDao {
	public int addOrderDetails(Order order) throws SQLException;
	public List<Order> getOrderDetails() throws SQLException;
	public void deleteOrderDetails(int id) throws SQLException;
	public void updateOrderDetails(Order order,int id) throws SQLException;
}
