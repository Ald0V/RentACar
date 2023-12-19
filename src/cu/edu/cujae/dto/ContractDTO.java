package cu.edu.cujae.dto;

import java.time.LocalDate;

public class ContractDTO {
	private String plate;
    private String passport;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate deliveryDate;
    private AuxiliaryDTO payMethod;
    private String driver;
    private int startKm;
    private int endKm;

    public ContractDTO() {
    }

    public ContractDTO(String plate, String passport, LocalDate startDate, LocalDate endDate, LocalDate deliveryDate, AuxiliaryDTO payMethod, String driver) {
        this.plate = plate;
        this.passport = passport;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deliveryDate = deliveryDate;
        this.payMethod = payMethod;
        this.driver = driver;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
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

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public AuxiliaryDTO getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(AuxiliaryDTO payMethod) {
        this.payMethod = payMethod;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getStartKm() {
        return startKm;
    }

    public void setStartKm(int startKm) {
        this.startKm = startKm;
    }

    public int getEndKm() {
        return endKm;
    }

    public void setEndKm(int endKm) {
        this.endKm = endKm;
    }

}
