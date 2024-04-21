package practice.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {
	
	private final long id;
	private String referenceCode;
	private String name;
	private double price;
	private boolean freeDeliv;
	
	Set<Order> orders = new HashSet<Order>();

	public Product(long id, String referenceCode, String name, double price, boolean freeDeliv) {
		super();
		this.id = id;
		this.referenceCode = referenceCode;
		this.name = name;
		this.price = price;
		this.freeDeliv = freeDeliv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", referenceCode=" + referenceCode + ", name=" + name + ", price=" + price
				+ ", freeDeliv=" + freeDeliv + "]";
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isFreeDeliv() {
		return freeDeliv;
	}

	public void setFreeDeliv(boolean freeDeliv) {
		this.freeDeliv = freeDeliv;
	}

	public Set<Order> getOrders() {
		return Collections.unmodifiableSet(orders) ;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public long getId() {
		return id;
	}

	public void add(Order order) {
		this.orders.add(order);
		order.product = this;;
	}
	
}
