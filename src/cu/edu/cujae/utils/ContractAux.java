package cu.edu.cujae.utils;

import java.time.LocalDate;


public class ContractAux {

	private String tourist;
	private LocalDate startDate;
    private LocalDate endDate;
    private String car;
    private String payMethod;
    private int prorroga;
    private boolean rentalDriver;
    private float totalImport;
        
	public ContractAux(String tourist, LocalDate startDate, LocalDate endDate, String car, String payMethod,
			int prorroga, boolean rentalDriver, float totalImport) {
		super();
		this.tourist = tourist;
		this.startDate = startDate;
		this.endDate = endDate;
		this.car = car;
		this.payMethod = payMethod;
		this.prorroga = prorroga;
		this.rentalDriver = rentalDriver;
		this.totalImport = totalImport;
	}
	
	public String getTourist() {
		return tourist;
	}
	public void setTourist(String tourist) {
		this.tourist = tourist;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public int getProrroga() {
		return prorroga;
	}
	public void setProrroga(int prorroga) {
		this.prorroga = prorroga;
	}
	public boolean isRentalDriver() {
		return rentalDriver;
	}
	public void setRentalDriver(boolean rentalDriver) {
		this.rentalDriver = rentalDriver;
	}
	public float getTotalImport() {
		return totalImport;
	}
	public void setTotalImport(float totalImport) {
		this.totalImport = totalImport;
	}
}
