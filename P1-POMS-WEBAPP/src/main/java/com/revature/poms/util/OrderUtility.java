package com.revature.poms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.revature.poms.constant.Constant;
import com.revature.poms.model.Order;



public class OrderUtility {
	private  OrderUtility() {
	}
	public static void sortOrderByName(List<Order> list) {
		list.sort(new Comparator<Order>() {
			public int compare(Order o1,  Order o2) {
				return o1.getCustomerName().compareToIgnoreCase(o2.getCustomerName());
			}
		});
	}
	public static void sortByPrice(List<Order> list) {
		list.sort(new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getPrice()-o2.getPrice();
			}
		});
	}
	public static int getLastId(Connection con) throws SQLException {
		int id = 0;
		try(PreparedStatement preStatement = con.prepareStatement(Constant.SELECT_ORDER_LAST_INDEX_QUERY)){
		ResultSet rs = preStatement.executeQuery();
		rs.next();
		id = Integer.valueOf(rs.getString(1));
		}
		return id;
	}
	public static int getLastCancelId(Connection con) throws SQLException {
		int id = 0;
		try(PreparedStatement preStatement = con.prepareStatement("Select last_insert_id() from cancel_order")){
		ResultSet rs = preStatement.executeQuery();
		rs.next();
		id = Integer.valueOf(rs.getString(1));
		}
		return id;
	}
	public static String  getDate(){
		 Date date = new Date();
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	      return formatter.format(date);
	}
	public static boolean checkOrderId(int id,Connection con) throws SQLException {
		String query = Constant.SELECT_ORDER_WHERE_QUERY;
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet check = preparedStatement.executeQuery();
		return check.next();
	}
}
