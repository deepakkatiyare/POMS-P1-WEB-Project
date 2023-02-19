package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.poms.model.OrderedItem;

public interface OrderedItemDao {
	public List<OrderedItem> getOrderedItem() throws SQLException;
	public void addItemDetails(OrderedItem item) throws SQLException;
	public void deleteItemDetails() throws SQLException;
}
