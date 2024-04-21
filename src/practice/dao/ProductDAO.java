package practice.dao;

import java.util.Collection;

import practice.model.Product;

public interface ProductDAO {

	Collection<Product> getAll() throws Exception;
	Product get(String referenceCode) throws Exception;
	
}
