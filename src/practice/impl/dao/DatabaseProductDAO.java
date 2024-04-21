package practice.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import practice.dao.ProductDAO;
import practice.model.Order;
import practice.model.Product;

public class DatabaseProductDAO implements ProductDAO{

	private final Connection conn;
	
	public DatabaseProductDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Collection<Product> getAll() throws Exception {
		Map<Long, Product> products = new LinkedHashMap<Long, Product>();
		
		String sql = "SELECT p.id,  p.referenceCode, p.productName, p.price, p.freeDeliv, o.id, o.orderDate, o.street, o.streetNum " +
					 "FROM products p LEFT JOIN orders o ON o.idProduct = p.id";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					int count = 0;
					
					long pId = rset.getLong(++count);
					String pReference = rset.getString(++count);
					String pName = rset.getString(++count);
					double pPrice = rset.getDouble(++count);
					boolean pFreeD = rset.getBoolean(++count);
					
					Product product = products.get(pId);
					if(product == null) {
						product = new Product(pId, pReference, pName, pPrice, pFreeD);
						products.put(pId, product);
					}
					
					long oId = rset.getLong(++count);
					if(oId != 0) {
						LocalDateTime orderDate = rset.getTimestamp(++count).toLocalDateTime();
						String street = rset.getString(++count);
						int streetNum = rset.getInt(++count);
						
						Order order = new Order(oId, orderDate, street, streetNum, product);
						product.add(order);
					}
				}
			}
		}
		return products.values();
	}

	@Override
	public Product get(String referenceCode) throws Exception {
		Product product = null;
		
		String sql = "SELECT p.id, p.productName, p.price, p.freeDeliv, o.id, o.orderDate, o.street, o.streetNum " +
				     "FROM products p LEFT JOIN orders o ON o.idProduct = p.id WHERE p.referenceCode = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			
			int arg = 0;
			stmt.setString(++arg, referenceCode);
			
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					
					int count = 0;
					
					long pId = rset.getLong(++count);
					String pName = rset.getString(++count);
					double pPrice = rset.getDouble(++count);
					boolean pFreeD = rset.getBoolean(++count);
					
					if(product == null) {
						product = new Product(pId, referenceCode, pName, pPrice, pFreeD);
					}
					
					long oId = rset.getLong(++count);
					if(oId != 0) {
						LocalDateTime orderDate = rset.getTimestamp(++count).toLocalDateTime();
						String street = rset.getString(++count);
						int streetNum = rset.getInt(++count);
						
						Order order = new Order(oId, orderDate, street, streetNum, product);
						product.add(order);
					}
				}
			}
		}
		 
		return product;
	}

}
