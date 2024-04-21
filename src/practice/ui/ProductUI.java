package practice.ui;


import java.util.Collection;

import practice.dao.ProductDAO;
import practice.model.Product;
import practice.util.Konzola;

public class ProductUI {

	public static ProductDAO productDAO;
	
	public static void setVozDAO(ProductDAO productDAO) {
		ProductUI.productDAO = productDAO;
	}
	
	public static Product find() throws Exception {
		showAll();

		String referenceCode = Konzola.ocitajString("Product reference code");

		Product product = productDAO.get(referenceCode);
		if (product == null)
			Konzola.prikazi("Product not found!");

		return product;
	}
	
	public static void showAll() {
		try {
			Collection<Product> products = productDAO.getAll();
			
			for (Product tempProd : products) {
				System.out.println(tempProd);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unexpected error!");
		}
	}

}
