<%@page import="com.revature.poms.model.CancelItem"%>
<%@page import="com.revature.poms.daoImpl.CancelOrderDaoImpl"%>

<%@page import="com.revature.poms.model.CancelOrder"%>
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
							<th>Cancel Id</th>
							<th>Cancel Reason</th>
							<th>Cancel Date</th>
							<th>Name</th>
							<th>Contacts</th>
							<th>Price</th>
							<th>Items</th>
							
						</tr>
					</thead>
					<tbody>
						<%
						ArrayList<CancelOrder> list = (ArrayList<CancelOrder>) (request.getAttribute("CANCEL_DETAIL"));
						for (CancelOrder order : list) {
						CancelOrderDaoImpl impl = new CancelOrderDaoImpl();
							ArrayList<CancelItem> itemList = (ArrayList<CancelItem>) impl.getCancelItem(order.getCanceId());
						%>
						<tr>
							<td class="id"><%=order.getCanceId()%></td>
							<td class="reason"><%=order.getCancelReason()%></td>
							<td class="date"><%=order.getDate()%></td>
							<td class="address"><%=order.getName()%></td>
							<td class="contact"><%=order.getContacts()%></td>
							<td class="price"><%=order.getPrice()%></td>
							<td>
								<div class="btn-group">
									<button type="button"
										class="btn btn-success dropdown-toggle btn-sm"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Item</button>
									<div class="dropdown-menu">
										<%
										for (CancelItem item : itemList) {
										%>
										<a class="dropdown-item" href="#"><%=item.getItemName() + " " + item.getPrice()%><span>&#8377</span></a>
										<%
										}
										%>
									</div>
								</div>
							</td>

						</tr>
						<%
						}
						%>
						</tbody>
				</table>