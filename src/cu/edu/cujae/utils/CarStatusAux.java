package cu.edu.cujae.utils;

import java.time.LocalDate;

public class CarStatusAux {
	
	private String situation;
	private String brand;
	private LocalDate endDate;
	
	
	
	
	public CarStatusAux(String situation, String brand, LocalDate endDate) {
		this.situation = situation;
		this.brand = brand;
		this.endDate = endDate;
	}
	
	
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	

}
