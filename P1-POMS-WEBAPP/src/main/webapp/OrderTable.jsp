<%@page import="com.revature.poms.daoImpl.OrderedItemDaoImpl"%>
<%@page import="com.revature.poms.model.OrderedItem"%>
<%@page import="com.revature.poms.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.revature.poms.daoImpl.OrderDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="MyTable" class="table table-striped" cellspacing="0"
					width="100%" style="padding-top: 25px; text-align: center;border:2px solid black">
					
					<thead class="table-dark">
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Email</th>
							<th>Address</th>
							<th>Contact</th>
							<th>Status</th>
							<th>Price</th>
							<th>Items</th>
							<th>Edit</th>
							<th>Cancel</th>
						</tr>
					</thead>
					<tbody>
						<%
						ArrayList<Order> list = (ArrayList<Order>) (request.getAttribute("ORDER_DETAIL"));
						for (Order order : list) {
							OrderedItemDaoImpl impl = new OrderedItemDaoImpl(order.getOrderId());
							ArrayList<OrderedItem> itemList = (ArrayList<OrderedItem>) impl.getOrderedItem();
						%>
						<tr>
							<td class="id"><%=order.getOrderId()%></td>
							<td class="name"><%=order.getCustomerName()%></td>
							<td class="email"><%=order.getEmail()%></td>
							<td class="address"><%=order.getDeliveryAddress()%></td>
							<td class="contact"><%=order.getCustomerContact()%></td>
							<td class="status"><%=order.getDeliveryStatus()%></td>
							<td class="price"><%=order.getPrice()%></td>
							<td>
								<div class="btn-group">
									<button type="button"
										class="btn btn-success dropdown-toggle btn-sm"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Item</button>
									<div class="dropdown-menu">
										<%
										for (OrderedItem item : itemList) {
											
										%>
										<a class="dropdown-item" href="#"><%=item.getItemName() + " " + item.getPrice()%><span>&#8377</span></a>
										<%
										}
										%>
									</div>
								</div>
							</td>

							<td>
								<button class="edit btn btn-primary btn-sm" type="button"
									data-toggle="modal" data-target="#exampleModalCenter">
									Edit</button>
							</td>
							<td><button class="delete btn btn-danger btn-sm" type="button"
									data-toggle="modal" data-target="#DeleteModal">
									Delete</button></i></a></td>
						</tr>
						<%
						}
						%>
						</tbody>
				</table>
				