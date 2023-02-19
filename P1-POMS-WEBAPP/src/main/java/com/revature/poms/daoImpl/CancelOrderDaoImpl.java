package com.revature.poms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.model.CancelItem;
import com.revature.poms.model.CancelOrder;
import com.revature.poms.util.OrderUtility;

public class CancelOrderDaoImpl {
	private static Connection con = DatabaseConnection.getConnection();
	
	public int  addCancelOrder(CancelOrder cancel) throws SQLException{
		String query = "insert into cancel_order(cancel_reason,cancel_date_time,customer_name,customer_contact,price) values(?,?,?,?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, cancel.getCancelReason());
			preparedStatement.setString(2, cancel.getDate());
			preparedStatement.setString(3, cancel.getName());
			preparedStatement.setString(4, cancel.getContacts());
			preparedStatement.setInt(5, cancel.getPrice());
			preparedStatement.executeUpdate();
		}
		return OrderUtility.getLastCancelId(con);
	}
	public void addCancelItem(CancelItem cancelItem) throws SQLException{
		String query = "insert into CANCELLED_ITEM(cancel_id,item_name,price) values(?,?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setInt(1, cancelItem.getCancelId());
			preparedStatement.setString(2, cancelItem.getItemName());
			preparedStatement.setInt(3, cancelItem.getPrice());
			preparedStatement.executeUpdate();
		}
	}
	public ArrayList<CancelItem> getCancelItem(int id) throws SQLException{
		ResultSet rs = null;
		Statement stmt = null;
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from cancelled_item where cancel_id="+id);
		ArrayList<CancelItem> cancel = new ArrayList<>();
		while (rs.next()) {
			CancelItem cancelItem = new CancelItem();
			cancelItem.setCancelId(rs.getInt(1));
			cancelItem.setItemName(rs.getString(2));
			cancelItem.setPrice(rs.getInt(3));
			cancel.add(cancelItem);
		}
		return cancel;
	}
	
	public  ArrayList<CancelOrder> getCancelDetails() throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		stmt = con.createStatement();
		rs = stmt.executeQuery(Constant.SELECT_CANCEL_ORDER_QUERY);
		ArrayList<CancelOrder> cancel = new ArrayList<>();
		while(rs.next()) {
			CancelOrder cancelOrder = new CancelOrder();
			cancelOrder.setCanceId(rs.getInt(1));
			cancelOrder.setCancelReason(rs.getString(2));
			cancelOrder.setDate(rs.getString(3));
			cancelOrder.setName(rs.getString(4));
			cancelOrder.setContacts(rs.getString(5));
			cancelOrder.setPrice(rs.getInt(6));
			cancel.add(cancelOrder);
		}
		return cancel;
	}
}
