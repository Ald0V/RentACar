package cu.edu.cujae.dto;

import java.time.LocalDate;

public class ContractDTO {
    private String plate;
    private LocalDate startDate;
    private String passport;
    private LocalDate endDate;
    private int startKm;
    private LocalDate deliveryDate;
    private int endKm;
    private int payMethod;
    private String driver;
    private float value;
    

    public ContractDTO(String plate, LocalDate startDate, String passport, LocalDate endDate, int startKm, LocalDate deliveryDate, int endKm, int payMethod, String driver, float value) {
        this.plate = plate;
        this.startDate = startDate;
        this.passport = passport; 
        this.endDate = endDate;
        this.startKm = startKm;
        this.deliveryDate = deliveryDate;
        this.endKm = endKm;
        this.payMethod = payMethod;
        this.driver = driver;
        this.value = value;
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

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
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

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
