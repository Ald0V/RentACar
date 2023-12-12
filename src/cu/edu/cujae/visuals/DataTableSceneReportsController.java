package cu.edu.cujae.visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DataTableSceneReportsController {
	
	private double x = 0;
	private double y = 0;
	
	@FXML
    private AnchorPane reportsScenePane;

    @FXML
    private Button bttnTourists;

    @FXML
    private Button bttnCarSituation;

    @FXML
    private Button bttnModelBrand;

    @FXML
    private Button bttnCountry;
    
    @FXML
    private Button bttnImport;
    
    @FXML
    private Button bttnBack;

    @FXML
    private AnchorPane mainScenePane;

    @FXML
    private AnchorPane tableTouristsPane;
    
    @FXML
    private AnchorPane tableCarSituationPane;
    
    @FXML
    private AnchorPane tableModelBrandPane;
    
    @FXML
    private AnchorPane tableCountryPane;

    @FXML
    private TableView<?> touristTable;
    
	private Stage stage;
	private Scene scene;
	private Parent root;

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
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public void logout(ActionEvent event) {
		stage = (Stage)mainScenePane.getScene().getWindow(); 
		stage.close();
	}

    @FXML
    void switchForm(ActionEvent event) {

    }
    
    public Button getBttnTourists() {
        return bttnTourists;
    }

    public Button getBttnCarSituation() {
        return bttnCarSituation;
    }

    public Button getBttnModelBrand() {
        return bttnModelBrand;
    }

    public Button getBttnCountry() {
        return bttnCountry;
    }

    public Button getBttnImports() {
        return bttnImport;
    }



}
