package cu.edu.cujae.dto;

import java.sql.SQLException;

import cu.edu.cujae.services.ServicesLocator;

public class ModelDTO {
    private int brand;
	private int id;
    private String name;
    

    public ModelDTO() {
    }

    public ModelDTO(int brand, int id, String name) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }
    
    public String getBrandName(int id) throws ClassNotFoundException, SQLException {
    	String brand;
    	
    	brand = ServicesLocator.getBrandServices().get_brand_by_id(id);
    	
    	return brand;
    }
}
