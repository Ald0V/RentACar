package cu.edu.cujae.utils;

import java.sql.SQLException;
import java.time.LocalDate;

import cu.edu.cujae.dto.ContractDTO;
import cu.edu.cujae.services.ServicesLocator;


public class ContractAux {

	private String tourist;
	private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate deliveryDate;
    private String car;
    private String payMethod;
    private String rentalDriver;
    private float totalImport;
        
	public ContractAux(ContractDTO contract) throws ClassNotFoundException, SQLException {
		setTourist(contract.getPassport());
		setStartDate(contract.getStartDate());
		setDeliveryDate(contract.getDeliveryDate());
		setEndDate(contract.getEndDate());
		setCar(contract.getPlate());
		setPayMethod(ServicesLocator.getPayMethodServices().get_paymethod_by_id(contract.getPayMethod()));
		setRentalDriver(contract.getDriver());
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
	public String isRentalDriver() {
		return rentalDriver;
	}
	public void setRentalDriver(String rentalDriver) {
		this.rentalDriver = rentalDriver;
	}
	public float getTotalImport() {
		return totalImport;
	}
	public void setTotalImport(float totalImport) {
		this.totalImport = totalImport;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
