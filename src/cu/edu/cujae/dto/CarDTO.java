package cu.edu.cujae.dto;

public class CarDTO {
	private String plate;
    private String model;
    private int cantKm;
    private String color;
    private String situation;

    public CarDTO() {
    }

    public CarDTO(String plate, String model, int cantKm, String color, String situation) {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
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

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

}
