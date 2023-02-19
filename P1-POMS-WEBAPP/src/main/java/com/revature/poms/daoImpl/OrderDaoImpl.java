package com.revature.poms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.OrderDao;
import com.revature.poms.model.Order;
import com.revature.poms.model.OrderedItem;
import com.revature.poms.util.OrderUtility;

public class OrderDaoImpl implements OrderDao {
	private static Connection con;
	private List<Order> orderList;
	static {
		con = DatabaseConnection.getConnection();
	}
	public OrderDaoImpl() throws SQLException  {
		getOrderDetailsList();
	}
	private void getOrderDetailsList() throws SQLException {
		orderList = new ArrayList<>();
		try (PreparedStatement stmt = con.prepareStatement(Constant.SELECT_ORDER_QUERY)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				int x = rs.getInt(1); 
				order.setOrderId(x);
				order.setCustomerName(rs.getString(2));
				order.setCustomerContact(rs.getString(3));
				order.setDeliveryAddress(rs.getString(4));
				order.setDeliveryStatus(rs.getString(5));
				order.setEmail(rs.getString(6));	
				order.setPrice(rs.getInt(7));
				orderList.add(order);
			}
			
		}
	}
	public  Order getOrderById(int id) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement(Constant.SELECT_ORDER_QUERY+"where order_id=?")) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Order order = new Order();
			if(rs.next()) {
				int x = rs.getInt(1); 
				order.setOrderId(x);
				order.setCustomerName(rs.getString(2));
				order.setCustomerContact(rs.getString(3));
				order.setDeliveryAddress(rs.getString(4));
				order.setDeliveryStatus(rs.getString(5));
				order.setEmail(rs.getString(6));	
				order.setPrice(rs.getInt(7));
			}
			return order;
		}
	}

	@Override
	public void deleteOrderDetails(int id) throws SQLException {
		try (PreparedStatement preparedStatement = con.prepareStatement(Constant.DELETE_ORDER_WHERE_QUERY)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
	}
	
	

	@Override
	public List<Order> getOrderDetails() throws SQLException {
		return orderList;
	}
	@Override
	public int addOrderDetails(Order order) throws SQLException {
		try (PreparedStatement preparedStatement = con.prepareStatement(Constant.INSERT_ORDER_QUERY)) {
			preparedStatement.setString(1, order.getCustomerName());
			preparedStatement.setString(2, order.getCustomerContact());
			preparedStatement.setString(3, order.getDeliveryAddress());
			preparedStatement.setString(4, order.getDeliveryStatus());
			preparedStatement.setString(5, order.getEmail());
			preparedStatement.setInt(6, order.getPrice());
			preparedStatement.executeUpdate();
			return OrderUtility.getLastId(con);
		}
	}
	@Override
	public void updateOrderDetails(Order order, int id) throws SQLException {
		String query = "update `order` set customer_name = ?,customer_contact = ?,delivery_address = ?,delivery_status = ?, customer_email = ?,price = ? where order_id = ?";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, order.getCustomerName());
			preparedStatement.setString(2, order.getCustomerContact());
			preparedStatement.setString(3, order.getDeliveryAddress());
			preparedStatement.setString(4, order.getDeliveryStatus());
			preparedStatement.setString(5, order.getEmail());
			preparedStatement.setInt(6, order.getPrice());
			preparedStatement.setInt(7, id);
			preparedStatement.executeUpdate();
		}
		
	}
}
