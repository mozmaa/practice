package practice.model;

import java.time.LocalDateTime;

import practice.util.Konzola;


public class ReportHolder {
	
	public final String ReferenceCode;
	public final String Name;
	public final double totalRevenue;
	public final LocalDateTime lastSellDate;
	
	public ReportHolder(String referenceCode, String name, double totalRevenue, LocalDateTime lastSellDate) {
		super();
		ReferenceCode = referenceCode;
		Name = name;
		this.totalRevenue = totalRevenue;
		this.lastSellDate = lastSellDate;
	}

	@Override
	public String toString() {
		return "ReportHolder [ReferenceCode=" + ReferenceCode + ", Name=" + Name + ", TotalRevenue=" + totalRevenue
				+ ", lastSellDate=" + Konzola.formatiraj(lastSellDate) + "]";
	}
	
}
