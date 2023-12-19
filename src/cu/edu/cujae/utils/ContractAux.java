package cu.edu.cujae.utils;

import java.time.LocalDate;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.dto.CarDTO;
import cu.edu.cujae.dto.TouristDTO;

public class ContractAux {

	private TouristDTO tourist;
	private LocalDate startDate;
    private LocalDate endDate;
    private CarDTO car;
    private AuxiliaryDTO payMethod;
    private int prorroga;
    private boolean rentalDriver;
    private float totalImport;
        
	public ContractAux(TouristDTO tourist, LocalDate startDate, LocalDate endDate, CarDTO car, AuxiliaryDTO payMethod,
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
	
	public TouristDTO getTourist() {
		return tourist;
	}
	public void setTourist(TouristDTO tourist) {
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
	public CarDTO getCar() {
		return car;
	}
	public void setCar(CarDTO car) {
		this.car = car;
	}
	public AuxiliaryDTO getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(AuxiliaryDTO payMethod) {
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
