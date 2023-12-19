package cu.edu.cujae.dto;

public class ModelDTO {
	private int id;
    private String name;
    private AuxiliaryDTO brand;

    public ModelDTO() {
    }

    public ModelDTO(int id, String name, AuxiliaryDTO brand) {
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

    public AuxiliaryDTO getBrand() {
        return brand;
    }

    public void setBrand(AuxiliaryDTO brand) {
        this.brand = brand;
    }
}
