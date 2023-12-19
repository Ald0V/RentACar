package cu.edu.cujae.dto;

public class CarDTO {
	private String plate;
    private ModelDTO model;
    private int cantKm;
    private String color;
    private AuxiliaryDTO situation;

    public CarDTO() {
    }

    public CarDTO(String plate, ModelDTO model, int cantKm, String color, AuxiliaryDTO situation) {
        this.plate = plate;
        this.model = model;
        this.cantKm = cantKm;
        this.color = color;
        this.situation = situation;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public ModelDTO getModel() {
        return model;
    }

    public void setModel(ModelDTO model) {
        this.model = model;
    }

    public int getCantKm() {
        return cantKm;
    }

    public void setCantKm(int cantKm) {
        this.cantKm = cantKm;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AuxiliaryDTO getSituation() {
        return situation;
    }

    public void setSituation(AuxiliaryDTO situation) {
        this.situation = situation;
    }

}
