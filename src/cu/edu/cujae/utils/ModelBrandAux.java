package cu.edu.cujae.utils;

public class ModelBrandAux {
	
	private String brand;
	private String model;
	private int rentDays;
	private float cheque$;
	private float creditCard$;
	private float paper$;
	private float brandImport;
	private float totalImport;
	
	public ModelBrandAux(String brand, String model, int rentDays, float cheque$, float creditCard$, float paper$,
			float brandImport, float totalImport) {
		this.brand = brand;
		this.model = model;
		this.rentDays = rentDays;
		this.cheque$ = cheque$;
		this.creditCard$ = creditCard$;
		this.paper$ = paper$;
		this.brandImport = brandImport;
		this.totalImport = totalImport;
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
	public int getRentDays() {
		return rentDays;
	}
	public void setRentDays(int rentDays) {
		this.rentDays = rentDays;
	}
	public float getCheque$() {
		return cheque$;
	}
	public void setCheque$(float cheque$) {
		this.cheque$ = cheque$;
	}
	public float getCreditCard$() {
		return creditCard$;
	}
	public void setCreditCard$(float creditCard$) {
		this.creditCard$ = creditCard$;
	}
	public float getPaper$() {
		return paper$;
	}
	public void setPaper$(float paper$) {
		this.paper$ = paper$;
	}
	public float getBrandImport() {
		return brandImport;
	}
	public void setBrandImport(float brandImport) {
		this.brandImport = brandImport;
	}
	public float getTotalImport() {
		return totalImport;
	}
	public void setTotalImport(float totalImport) {
		this.totalImport = totalImport;
	}
	
	

}
