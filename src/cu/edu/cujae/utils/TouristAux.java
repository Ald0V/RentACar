package cu.edu.cujae.utils;

import java.sql.SQLException;

import cu.edu.cujae.dto.TouristDTO;
import cu.edu.cujae.services.ServicesLocator;

public class TouristAux {
	
	private String passport;
    private String name;
    private String lastName1;
    private String lastName2;
    private String country;
	private int age;
    private String sex;
    private String contact;
    
    public TouristAux(TouristDTO tourist) throws ClassNotFoundException, SQLException {
    	
        setpassport(tourist.getID());
        setName(tourist.getName());
        setLastName1(tourist.getLastName1());
        setLastName2(tourist.getLastName2());
        setAge(tourist.getAge());
        setSex(tourist.getSex());
        setContact(tourist.getContact());
		setCountry(ServicesLocator.getCountryServices().get_country_by_id(tourist.getCountry()));
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}	
	
}
