package cu.edu.cujae.visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DataTableSceneCBMController {

	private double x = 0;
	private double y = 0;
	
	
	@FXML
	private AnchorPane CBMPane;

	@FXML
	private AnchorPane brandPane;

	@FXML
	private TableView<?> brandTable;

	@FXML
	private Button bttnBrands;

	@FXML
	private Button bttnCountry;

	@FXML
	private Button bttnGoBack;

	@FXML
	private Button bttnModels;

	@FXML
	private ComboBox<?> cmboxBrands;

	@FXML
	private TableColumn<?, ?> colBrands;

	@FXML
	private TableColumn<?, ?> colBrandsModels;

	@FXML
	private TableColumn<?, ?> colCountries;

	@FXML
	private TableColumn<?, ?> colModels;

	@FXML
	private AnchorPane countryPane;

	@FXML
	private TableView<?> countryTable;

	@FXML
	private AnchorPane modelPane;

	@FXML
	private TableView<?> modelTable;

	@FXML
	private TextField txtBrand;

	@FXML
	private TextField txtCountry;

	@FXML
	private TextField txtModel;


	private Stage stage;
	private Scene scene;
	private Parent root;
	
	

	public AnchorPane getBrandPane() {
		return brandPane;
	}

	public Button getBttnBrands() {
		return bttnBrands;
	}

	public Button getBttnCountry() {
		return bttnCountry;
	}

	public Button getBttnModels() {
		return bttnModels;
	}

	public AnchorPane getCountryPane() {
		return countryPane;
	}
	
	public AnchorPane getModelPane() {
		return modelPane;
	}


	public void backMain(ActionEvent event) throws IOException{

		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
		root = loader.load();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		root.setOnMousePressed((MouseEvent e) ->{
			x = e.getSceneX();
			y = e.getSceneY();
		});

		root.setOnMouseDragged((MouseEvent e) ->{
			stage.setX(e.getScreenX() - x);
			stage.setY(e.getScreenY() - y);

			stage.setOpacity(.9);
		});

		root.setOnMouseReleased((MouseEvent e) ->{
			stage.setOpacity(1);
		});

		Image image = new Image("/resources/Rental_car_login.png");

		stage.getIcons().add(image);

		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public void logout(ActionEvent event) {
		stage = (Stage)CBMPane.getScene().getWindow(); 
		stage.close();
	}
	
    @FXML
    void switchForm(ActionEvent event) {
    	
    	if(event.getSource() == bttnCountry) {
    		
    		countryPane.setVisible(true);
    		bttnCountry.setDisable(true);
    		bttnBrands.setDisable(false);
    		bttnModels.setDisable(false);
    		
    		brandPane.setVisible(false);
    		modelPane.setVisible(false);
    		
    	}else if(event.getSource() == bttnBrands) {
    		
    		brandPane.setVisible(true);
    		bttnBrands.setDisable(true);
    		bttnCountry.setDisable(false);
    		bttnModels.setDisable(false);
    		
    		modelPane.setVisible(false);
    		countryPane.setVisible(false);
    	}else if(event.getSource() == bttnModels) {
    		
    		modelPane.setVisible(true);
    		bttnModels.setDisable(true);
    		bttnBrands.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		countryPane.setVisible(true);
    		brandPane.setVisible(false);  		
    	}

    }
}
