package cu.edu.cujae.utils;

import java.sql.SQLException;

import cu.edu.cujae.dto.DriverDTO;
import cu.edu.cujae.services.ServicesLocator;

public class DriverAux {
	
	private String iD;
    private String name;
    private String lastName1;
    private String lastName2;
    private String address;
    private String license;
    
    public DriverAux (DriverDTO driver) throws SQLException {
    	setID(driver.getID());
    	setName(driver.getName());
    	setLastName1(driver.getLastName1());
    	setLastName2(driver.getLastName2());
    	setAddress(driver.getAddress());
    	setCategory(ServicesLocator.getLicenseServices().select_license_by_id(driver.getCategory()));
    }
    
	public String getID() {
		return iD;
	}
	public void setID(String iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String direction) {
		this.address = direction;
	}
	public String getCategory() {
		return license;
	}
	public void setCategory(String license) {
		this.license = license;
	}

}
