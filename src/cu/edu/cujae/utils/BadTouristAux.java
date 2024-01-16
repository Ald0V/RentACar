package cu.edu.cujae.utils;

import java.time.LocalDate;

public class BadTouristAux {
	
	private LocalDate endDate;
	private LocalDate dateCar;
	private String lastName1;
    private String lastName2;
    private String name;
       
	public BadTouristAux(LocalDate endDate, LocalDate dateCar, String lastName1, String lastName2, String name) {
		this.endDate = endDate;
		this.dateCar = dateCar;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.name = name;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getDateCar() {
		return dateCar;
	}
	public void setDateCar(LocalDate dateCar) {
		this.dateCar = dateCar;
	}
	public String getLastName1() {
		return lastName1;
	}
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	public String getLastName2() {
		return lastName2;
	}
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
