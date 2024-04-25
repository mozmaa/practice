package practice.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

	private final long id;
	private LocalDateTime orderDate;
	private String street;
	private int streetNum;
	
	Product product;

	public Order(long id, LocalDateTime orderDate, String street, int streetNum, Product product) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.street = street;
		this.streetNum = streetNum;
		this.product = product;
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
		Order other = (Order) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", street=" + street +
				", streetNum=" + streetNum + ", product=" + this.product.getName() + "]";
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}
	
	public boolean isDateInRange(LocalDateTime min, LocalDateTime max) {
		return this.orderDate.compareTo(min) >= 0 && orderDate.compareTo(max) <= 0;
	}
	
}
