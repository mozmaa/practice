package practice.ui;

import java.time.LocalDateTime;
import java.util.Collection;

import practice.dao.OrderDAO;
import practice.model.Order;
import practice.model.Product;
import practice.util.Konzola;

public class OrderUI {

	public static OrderDAO orderDAO;
	
	public static void setKartaDAO(OrderDAO orderDAO) {
		OrderUI.orderDAO = orderDAO;
	}

	public static void showAll() {
		
		try {
			Collection<Order> orders = orderDAO.getAll();
			
			for (Order tempOrd : orders) {
				System.out.println(tempOrd);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unexpected error!");
		}
	}

	public static void add() {
		try {
			Product product = ProductUI.find();
			if(product == null)
				return;
			
			String street = "";
			while(street.equals("")){
				street = Konzola.ocitajString("Street name");
			}
			
			int streetNum = 0;
			while (streetNum <= 0)
				streetNum = Konzola.ocitajInt("Street number");
			
			LocalDateTime date = LocalDateTime.now();
			
			Order order = new Order(streetNum, date, street, streetNum, product);
			
			orderDAO.add(order);
			System.out.println("Added!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unexpected error!");
		}
		
	}

}
