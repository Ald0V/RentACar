package cu.edu.cujae.utils;

public class CountryContractAux {
	
	private String country;
    private String brand;
    private String model;
    private int rentDays;
    private int prorroga;
    private float paper$;
    private float totalCash;
     
	public CountryContractAux(String country, String brand, String model, int rentDays, int prorroga, float paper$,
			float totalCash) {
		this.country = country;
		this.brand = brand;
		this.model = model;
		this.rentDays = rentDays;
		this.prorroga = prorroga;
		this.paper$ = paper$;
		this.totalCash = totalCash;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public int getProrroga() {
		return prorroga;
	}
	public void setProrroga(int prorroga) {
		this.prorroga = prorroga;
	}
	public float getPaper$() {
		return paper$;
	}
	public void setPaper$(float paper$) {
		this.paper$ = paper$;
	}
	public float getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(float totalCash) {
		this.totalCash = totalCash;
	}
    
    

}
