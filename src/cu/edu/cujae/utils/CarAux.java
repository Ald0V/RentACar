package cu.edu.cujae.utils;

import java.sql.SQLException;

import cu.edu.cujae.dto.CarDTO;
import cu.edu.cujae.services.ServicesLocator;

public class CarAux {
	
	private String plate;
	private String brand;
	private String model;
	private String color;
	private String situation;
	private int km;
	
	
	
	public CarAux(CarDTO car) throws ClassNotFoundException, SQLException {
		setPlate(car.getPlate());
		setColor(car.getColor());
		setKm(car.getCantKm());
		setModel(ServicesLocator.getModelServices().get_model_by_id(car.getModel()));
		setSituation(ServicesLocator.getSituationServices().get_situation_by_id(car.getSituation()));
		setBrand(ServicesLocator.getBrandServices().get_brand_by_id(car.getBrand()));
		
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

}
