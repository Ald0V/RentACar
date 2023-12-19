package cu.edu.cujae.dto;

public class PersonDTO {
	private String ID;
	private String name;
	private String lastName1;
	private String lastName2;
	
	public PersonDTO() {
	}
	
	public PersonDTO(String iD, String name, String lastName1, String lastName2) {
		super();
		ID = iD;
		this.name = name;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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
