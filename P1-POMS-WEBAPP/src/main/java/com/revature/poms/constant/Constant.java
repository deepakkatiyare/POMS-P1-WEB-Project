package com.revature.poms.constant;

public class Constant {
	public static final String SELECT_ORDER_QUERY 	= "Select * from `order`";
	
	public static final String UPDATE_ORDER_CUSTOMER_CONTACT_WHERE_QUERY = "update `order` set customer_contact = ? where order_id = ?";
	public static final String UPDATE_ORDER_CUSTOMER_NAME_WHERE_QUERY = "update `order` set customer_name = ? where order_id = ?";
	public static final String UPDATE_ITEM_LIST 	= "Press 4: update ItemList";
	public static final String UPDATE_DELIVERY_ADDRESS = "Press 3: update Delivery Address";

	public static final String SELECT_ORDERED_ITEM_WHERE_QUERY = "select * from ordered_item where order_id =";
	public static final String DELETE_ORDER_WHERE_QUERY = "delete from `order` where order_id = ?";
	public static final String DELETE_ORDERED_ITEM_WHERE_QUERY = "delete from ordered_item where order_id = ?";
	public static final String SELECT_ORDER_WHERE_QUERY = "select * from `order` where order_id = ?";
	public static final String SELECT_CANCEL_ORDER_QUERY = "select * from cancel_order";
	public static final String SELECT_ORDER_LAST_INDEX_QUERY = "Select last_insert_id() from `order`";
	public static final String INSERT_ORDERED_ITEM_QUERY = "Insert into ordered_item(order_id,item_name,price) values(?,?,?)";
	public static final String INSERT_ORDER_QUERY 	= "Insert into `order`(customer_name,customer_contact,delivery_address,delivery_status,customer_email,price) values(?,?,?,?,?,?)";
	public static final String UPDATE_ORDER_DELIVERY_ADDRESS_WHERE_QUERY = "update `order` set delivery_address = ? where order_id = ?";

	public static final String SELECT_ALL_ADMIN = "select * from admin ";

	public static final String UPDATE_ORDER_PRICE_WHERE = "update `order` set price = ? where order_id = ?";
	public static final String SELECT_PRICE_ORDER_WHERE = "select price from `order` where order_id = ?";
	public static final String INSERT_CANCEL_ORDER_QUERY = "Insert into cancel_order(cancel_reason,cancel_date_time,order_id) values(?,?,?)";

}
