package practice.model;

import java.sql.Connection;
import java.sql.DriverManager;

import practice.dao.OrderDAO;
import practice.dao.ProductDAO;
import practice.impl.dao.DatabaseOrderDAO;
import practice.impl.dao.DatabaseProductDAO;
import practice.ui.OrderUI;
import practice.ui.ProductUI;
import practice.ui.ReportUI;
import practice.util.Meni;
import practice.util.Meni.FunkcionalnaStavkaMenija;
import practice.util.Meni.IzlaznaStavkaMenija;
import practice.util.Meni.StavkaMenija;


public class Application {


	private static void initDatabase() throws Exception {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/voz?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade", 
				"root", 
				"root");

		ProductDAO productDAO = new DatabaseProductDAO(conn);
		OrderDAO orderDAO = new DatabaseOrderDAO(conn);

		ProductUI.setVozDAO(productDAO);
		OrderUI.setKartaDAO(orderDAO);
		ReportUI.setVozDAO(productDAO);
	}

	static {
		try {
			initDatabase();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Greška pri povezivanju sa izvorom podataka!");
			
			System.exit(1);
		}
	}

	public static void main(String[] args) throws Exception {
		Meni.pokreni("Online orders", new StavkaMenija[] {
			new IzlaznaStavkaMenija("Izlaz"),
			new FunkcionalnaStavkaMenija("Show all products") {

				@Override
				public void izvrsi() { ProductUI.showAll(); }
				
			}, 
			new FunkcionalnaStavkaMenija("Show all orders with products") {

				@Override
				public void izvrsi() { OrderUI.showAll(); }
				
			}, 
			new FunkcionalnaStavkaMenija("Add order") {

				@Override
				public void izvrsi() { OrderUI.add(); }
				
			}, 
			new FunkcionalnaStavkaMenija("Report") {

				@Override
				public void izvrsi() { ReportUI.showProductInDateRange(); }
				
			}
		});
	}

}
