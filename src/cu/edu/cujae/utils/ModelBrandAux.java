package cu.edu.cujae.utils;

import java.sql.SQLException;

import cu.edu.cujae.dto.ModelDTO;
import cu.edu.cujae.services.ServicesLocator;

public class ModelBrandAux {
	
	private String brand;
	private String model;
	
	public ModelBrandAux (ModelDTO model) throws ClassNotFoundException, SQLException {
		setBrand(ServicesLocator.getBrandServices().get_brand_by_id(model.getBrand()));
		setModel(model.getName());
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	
	

}
