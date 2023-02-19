package com.revature.poms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.OrderedItemDao;
import com.revature.poms.model.OrderedItem;
import com.revature.poms.util.OrderUtility;

public class OrderedItemDaoImpl implements OrderedItemDao {
	private static Connection con;
	private int orderId;
	private ArrayList<OrderedItem> itemList;
	static {
		con = DatabaseConnection.getConnection();
	}
	
	public OrderedItemDaoImpl(int orderId) throws SQLException {
		this.orderId = orderId;
		getOrderedItemList();
	}
	private void  getOrderedItemList() throws SQLException {
		itemList  = new ArrayList<>();
		
		String query  = Constant.SELECT_ORDERED_ITEM_WHERE_QUERY;
		try(PreparedStatement statement = con.prepareStatement(query+orderId)){
		ResultSet reSet = statement.executeQuery();
		while(reSet.next()) {
			OrderedItem item = new OrderedItem();
			int i = reSet.getInt(1);
			item.setId(i);
			item.setItemName(reSet.getString(2));
			item.setPrice(reSet.getInt(3));
			itemList.add(item);
		}
		}
	}
	
	@Override
	public List<OrderedItem> getOrderedItem() throws SQLException {
		return  itemList;
	}

	@Override
	public void addItemDetails(OrderedItem item) throws SQLException {
		try (PreparedStatement preparedStatement = con.prepareStatement(Constant.INSERT_ORDERED_ITEM_QUERY)) {
			preparedStatement.setInt(1, item.getId());
			preparedStatement.setString(2, item.getItemName());
			preparedStatement.setInt(3, item.getPrice());
			preparedStatement.executeUpdate();
		}
	}
	
	@Override
	public void deleteItemDetails() throws SQLException {
		// TODO Auto-generated method stub
		try (PreparedStatement preparedStatement = con.prepareStatement(Constant.DELETE_ORDERED_ITEM_WHERE_QUERY)) {
			preparedStatement.setInt(1, orderId);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
