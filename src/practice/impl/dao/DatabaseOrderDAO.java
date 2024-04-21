package practice.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import practice.dao.OrderDAO;
import practice.model.Order;
import practice.model.Product;

public class DatabaseOrderDAO implements OrderDAO {

	private final Connection conn;
	
	public DatabaseOrderDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Collection<Order> getAll() throws Exception {
		Collection<Order> orders = new ArrayList<Order>();
	
		String sql = "SELECT o.id, o.orderDate, o.street, o.streetNum, p.id,  p.referenceCode, p.productName, p.price, p.freeDeliv " +
					 "FROM orders o LEFT JOIN products p ON o.idProduct = p.id";
		
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					int count = 0;
					
					long oId = rset.getLong(++count);
					LocalDateTime orderDate = rset.getTimestamp(++count).toLocalDateTime();
					String street = rset.getString(++count);
					int streetNum = rset.getInt(++count);
					
					Order order = new Order (oId, orderDate, street, streetNum, null);
					
					long pId = rset.getLong(++count);
					if(pId != 0) {
						String pReference = rset.getString(++count);
						String pName = rset.getString(++count);
						double pPrice = rset.getDouble(++count);
						boolean pFreeD = rset.getBoolean(++count);
						
						Product product = new Product(pId, pReference, pName, pPrice, pFreeD);
						order.setProduct(product);
					}
					orders.add(order);
				}
			}
		}
		return orders;
	}

	@Override
	public void add(Order order) throws Exception {
		String sql = "INSERT INTO orders (orderDate, street, streetNum, idProduct) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			int arg = 0;
			stmt.setTimestamp(++arg, Timestamp.valueOf(order.getOrderDate()));
			stmt.setString(++arg, order.getStreet());
			stmt.setInt(++arg, order.getStreetNum());
			stmt.setLong(++arg, order.getProduct().getId());
			
			stmt.executeUpdate();
		}
		
	}

}
