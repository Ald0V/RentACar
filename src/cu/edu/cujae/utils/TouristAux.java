package cu.edu.cujae.utils;

public class TouristAux {
	
	private String passport;
    private String name;
    private String lastName1;
    private String lastName2;
    private int cantRentalCars;
    private float rentalTotalValue;
    private String country;
    
    public TouristAux(String passport, String name, String lastName1, String lastName2, int cantRentalCars,
    		float rentalTotalValue, String country) {
    	
		super();
		this.passport = passport;
		this.name = name;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.cantRentalCars = cantRentalCars;
		this.rentalTotalValue = rentalTotalValue;
		this.country = country;
	}

	public double getRentalTotalValue() {
		return rentalTotalValue;
	}

	public void setRentalTotalValue(float rentalTotalValue) {
		this.rentalTotalValue = rentalTotalValue;
	}
    
    public int getCantRentalCars() {
		return cantRentalCars;
	}

	public void setCantRentalCars(int cantRentalCars) {
		this.cantRentalCars = cantRentalCars;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getpassport() {
        return passport;
    }

    public void setpassport(String passport) {
        this.passport = passport;
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
	
}
