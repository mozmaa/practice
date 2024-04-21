package practice.dao;

import java.util.Collection;

import practice.model.Order;

public interface OrderDAO {

	Collection<Order> getAll() throws Exception;

	void add(Order order) throws Exception;

}
