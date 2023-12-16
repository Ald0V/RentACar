package cu.edu.cujae.visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private AnchorPane tableImportsPane;

    @FXML
    private TableView<?> touristTable;

	@FXML
    private TableView<?> carTable;

    @FXML
    private TableView<?> modelBrandTable;
    
    @FXML
    private TableView<?> importsBrandTable;
    
    @FXML
    private TableView<?> countryTable;
    
    @FXML
    private TableView<?> importsTable;
    
    @FXML
    private TableView<?> importsMonthTable;
       
    
  //0ºººººººººººººººººººº0    
  //0   TOURIST TABLE    0
  //0ºººººººººººººººººººº0 
    
    @FXML
    private TextField touristSearch;
    
    @FXML
    private TableColumn<?, ?> colTouristDate;

    @FXML
    private TableColumn<?, ?> colTouristDateCar;

    @FXML
    private TableColumn<?, ?> colTouristEndDate;

    @FXML
    private TableColumn<?, ?> colTouristLastName1;

    @FXML
    private TableColumn<?, ?> colTouristLastName2;

    
  //0ºººººººººººººººº0    
  //0   CAR TABLE    0
  //0ºººººººººººººººº0
    
    @FXML
    private TextField carSSearch;
    
    @FXML
    private TableColumn<?, ?> colCarS;

    @FXML
    private TableColumn<?, ?> colCarSBrand;

    @FXML
    private TableColumn<?, ?> colCarSEndDate;

    @FXML
    private TableColumn<?, ?> colCarSSituation;
      
  //0ºººººººººººººººººººººººº0  
  //0   BRAND/MODEL TABLE    0
  //0ºººººººººººººººººººººººº0
    
    @FXML
    private TextField brandModelSearch;
    
    @FXML
    private TableColumn<?, ?> colBrand$Cheque;

    @FXML
    private TableColumn<?, ?> colBrand$CreditCard;

    @FXML
    private TableColumn<?, ?> colBrand$Paper;

    @FXML
    private TableColumn<?, ?> colBrandBrand;

    @FXML
    private TableColumn<?, ?> colBrandCantRentalDays;

    @FXML
    private TableColumn<?, ?> colBrandDate;

    @FXML
    private TableColumn<?, ?> colBrandImportBrand;

    @FXML
    private TableColumn<?, ?> colBrandModel;

    @FXML
    private TableColumn<?, ?> colBrandTotalImport;
    
    @FXML
    private Label lblTotalImport;
      
  //0ººººººººººººººººººººº0  
  //0   COUNTRY TABLE     0
  //0ººººººººººººººººººººº0
    
    @FXML
    private TextField countrySearch;
    
    @FXML
    private TableColumn<?, ?> colCountry$PaperTotal;

    @FXML
    private TableColumn<?, ?> colCountryBrand;

    @FXML
    private TableColumn<?, ?> colCountryCantRentalDays;

    @FXML
    private TableColumn<?, ?> colCountryCountry;

    @FXML
    private TableColumn<?, ?> colCountryDate;

    @FXML
    private TableColumn<?, ?> colCountryModel;

    @FXML
    private TableColumn<?, ?> colCountryProrroga;

    @FXML
    private TableColumn<?, ?> colCountryTotal;
    
  //0ºººººººººººººººººººººººººº0    
  //0   TOTAL IMPORTS TABLE    0
  //0ºººººººººººººººººººººººººº0 
      
    @FXML
    private TableColumn<?, ?> colImports$Month;

    @FXML
    private TableColumn<?, ?> colImports$Year;

    @FXML
    private TableColumn<?, ?> colImportsDate;

    @FXML
    private TableColumn<?, ?> colImportsDateMonth;
    
    @FXML
    private Label lblYearImport;
    
    
    
	private Stage stage;
	private Scene scene;
	private Parent root;
	
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
    
    public AnchorPane getTableTouristsPane() {
		return tableTouristsPane;
	}

	public AnchorPane getTableCarSituationPane() {
		return tableCarSituationPane;
	}

	public AnchorPane getTableModelBrandPane() {
		return tableModelBrandPane;
	}

	public AnchorPane getTableCountryPane() {
		return tableCountryPane;
	}

	public AnchorPane getTableImportsPane() {
		return tableImportsPane;
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
		stage = (Stage)mainScenePane.getScene().getWindow(); 
		stage.close();
	}

    @FXML
    void switchForm(ActionEvent event) {
    	
    	if(event.getSource() == bttnTourists) {
    		tableTouristsPane.setVisible(true);
    		
    		bttnTourists.setDisable(true);
    		bttnCarSituation.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnCountry.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnCarSituation) {
    		tableCarSituationPane.setVisible(true);
    		
    		bttnCarSituation.setDisable(true);
    		bttnTourists.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnCountry.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableTouristsPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnModelBrand) {
    		tableModelBrandPane.setVisible(true);
    		
    		bttnModelBrand.setDisable(true);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableTouristsPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnCountry) {
    		tableCountryPane.setVisible(true);
    		
    		bttnCountry.setDisable(true);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableTouristsPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnImport) {
    		tableImportsPane.setVisible(true);
    		
    		bttnImport.setDisable(true);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		tableTouristsPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    	}
    		

    }
    
		

}
