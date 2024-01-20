package cu.edu.cujae.dto;

public class TouristDTO extends PersonDTO {
		private int age;
	    private String sex;
	    private String contact;
	    private String country;
	    
	    public TouristDTO() {
	    	super();
	    }
	    
	    public TouristDTO(String iD, String name, String lastName1, String lastName2, int age, String sex,
				String contact, String country) {
			super(iD, name, lastName1, lastName2);
			this.age = age;
			this.sex = sex;
			this.contact = contact;
			this.country = country;
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

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

}
