package practice.ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import practice.dao.ProductDAO;
import practice.model.Order;
import practice.model.Product;
import practice.model.ReportHolder;
import practice.util.Konzola;

public class ReportUI {

	public static ProductDAO productDAO;
	
	public static void setProductDAO(ProductDAO productDAO) {
		ReportUI.productDAO = productDAO;
	}

	public static void showProductInDateRange() {
		LocalDateTime min = null;
		
		while(min == null) {
			min = Konzola.ocitajDateTime("Pocetak");
			if(min == null)
				System.out.println("Unesite datum u formtu dd.MM.yyyy. HH:mm");
		}
		
		LocalDateTime max = null;
		
		while(max == null) {
			max = Konzola.ocitajDateTime("Kraj");
			if(max == null)
				System.out.println("Unesite datum u formtu dd.MM.yyyy. HH:mm");
		}
		try {
			Collection<Product> products = productDAO.getAll();
			
			List<ReportHolder> statements = new ArrayList<>();
			
			String referCode = "";
			String name = "";
			
			
			for (Product tempProd : products) {
				
				double totalRevenue = 0;
				LocalDateTime lastSellDate = LocalDateTime.MIN;
				for (Order tempOrd: tempProd.getOrders()) {
					lastSellDate = tempOrd.getOrderDate();
					
					if(tempOrd.isDateInRange(min, max)) {
						referCode = tempProd.getReferenceCode();
						name = tempProd.getName();
						if(!tempProd.isFreeDeliv())
							totalRevenue += 1000;
						totalRevenue += tempProd.getPrice();
						if(tempOrd.getOrderDate().compareTo(lastSellDate) > 0)
							lastSellDate = tempOrd.getOrderDate();
					}
				}
				if(!name.equals(""))
				statements.add(new ReportHolder(referCode, name, totalRevenue, lastSellDate));
			}
			
			statements = statements.stream()
					.sorted((stat1, stat2) -> -Double.compare(stat1.totalRevenue, stat2.totalRevenue))
					.toList();
			
			for (ReportHolder tempStat : statements) {
				System.out.println(tempStat);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Doslo je do greske!");
		}
	}

}
