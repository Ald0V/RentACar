package cu.edu.cujae.dto;

public class DriverDTO extends PersonDTO{
    private String category;
    private String address;
    
    public DriverDTO() {
    	super();
    }
    
	public DriverDTO(String iD, String name, String lastName1, String lastName2, String category,
			String address) {
		super(iD, name, lastName1, lastName2);
		this.category = category;
		this.address = address;
	}

	public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

