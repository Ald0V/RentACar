package cu.edu.cujae.visuals;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import cu.edu.cujae.utils.DriverAux;
import cu.edu.cujae.utils.CarAux;
import cu.edu.cujae.utils.ContractAux;
import cu.edu.cujae.utils.TouristAux;

public class DataTableSceneReportsController {
	
	private double x = 0;
	private double y = 0;
	
	@FXML
    private AnchorPane reportsScenePane;
    
    @FXML
    private Button bttnBack;

    @FXML
    private AnchorPane mainScenePane;  

       
    
    //0ººººººººººººººººººººººººººº0    
    //0   REPORT TOURIST TABLE    0
    //0ººººººººººººººººººººººººººº0 
    
    @FXML
    private Button bttnReportTourists;

    @FXML
    private AnchorPane tableReportsTouristsPane;
    
    @FXML
    private TableView<TouristAux> reportTouristTable;
    
    @FXML
    private TableColumn<TouristAux, String> colReportTouristLastName1;

    @FXML
    private TableColumn<TouristAux, String> colReportTouristLastName2;
    
    @FXML
    private TableColumn<TouristAux, String> colReportTouristName;
    
    @FXML
    private TableColumn<TouristAux, String> colReportTouristPassport;
    
    @FXML
    private TableColumn<TouristAux, Integer> colReportTouristCantCars;
    
    @FXML
    private TableColumn<TouristAux, Float> colReportTouristTotalRent;
    
    @FXML
    private TableColumn<TouristAux, String> colReportTouristCountry;
    
    
    //0ºººººººººººººººººººººººº0    
    //0   REPORT CAR TABLE     0
    //0ºººººººººººººººººººººººº0 
    
    @FXML
    private Button bttnReportCar;

    @FXML
    private AnchorPane tableReportsCarPane;
    
    @FXML
    private TableView<CarAux> reportCarTable;
    
    @FXML
    private TableColumn<CarAux, String> colReportCarSPlate;
    
    @FXML
    private TableColumn<CarAux, Integer> colReportCarSKM;

    @FXML
    private TableColumn<CarAux, String> colReportCarSBrand;

    @FXML
    private TableColumn<CarAux, String> colReportCarSModel;

    @FXML
    private TableColumn<CarAux, String> colReportCarSColor;
    
    
    //0ºººººººººººººººººººººººººººº0    
    //0   REPORT CONTRACT TABLE    0
    //0ºººººººººººººººººººººººººººº0 
    
    @FXML
    private Button bttnReportContract;
    
    @FXML
    private AnchorPane tableReportsContractPane;
    
    @FXML
    private TableView<ContractAux> reportContractTable;
    
    @FXML
    private TableColumn<ContractAux, String> colReportContractTourist;
    
    @FXML
    private TableColumn<ContractAux, LocalDate> colReportContractStartDate;
    
    @FXML
    private TableColumn<ContractAux, LocalDate> colReportContractEndDate;
    
    @FXML
    private TableColumn<ContractAux, String> colReportContractCar;
    
    @FXML
    private TableColumn<ContractAux, String> colReportContractPayMethod;
    
    @FXML
    private TableColumn<ContractAux, Integer> colReportContractProrroga;
    
    @FXML
    private TableColumn<ContractAux, Boolean> colReportContractRentalCar;
    
//    colReportContractRentalCar.setCellFactory(tc -> new TableCell<ContractAux, Boolean>() {
//        private final CheckBox checkBox = new CheckBox();
//
//        protected void updateItem(Boolean item, boolean empty) {
//            super.updateItem(item, empty);
//            if (empty || item == null) {
//                setGraphic(null);
//            } else {
//                checkBox.setSelected(item);
//                checkBox.setDisable(true); // Deshabilita la casilla de verificación
//                setGraphic(checkBox);
//            }
//        }
//    });
    
    
    
    @FXML
    private TableColumn<ContractAux, Float> colReportContractTotalImport;
    
    
    //0ºººººººººººººººººººººººººº0    
    //0   REPORT DRIVER TABLE    0
    //0ºººººººººººººººººººººººººº0 
    
    @FXML
    private Button bttnReportDrivers;

    @FXML
    private AnchorPane tableReportsDriverPane;
  
    @FXML
    private TableView<DriverAux> reportDriverTable;
    
    @FXML
    private TableColumn<DriverAux, String> colReportDriverID;
    
    @FXML
    private TableColumn<DriverAux, String> colReportDriverName;
    
    @FXML
    private TableColumn<DriverAux, String> colReportDriverLastName1;

    @FXML
    private TableColumn<DriverAux, String> colReportDriverLastName2;
    
    @FXML
    private TableColumn<DriverAux, String> colReportDriverDirection;
    
    @FXML
    private TableColumn<DriverAux, String> colReportDriverLicense;
    
    @FXML
    private TableColumn<DriverAux, Integer> colReportDriverCantCars;
  
  
  //0ºººººººººººººººººººº0    
  //0   TOURIST TABLE    0
  //0ºººººººººººººººººººº0 
      
    @FXML
    private Button bttnTourists;
    
    @FXML
    private AnchorPane tableTouristsPane;
    
    @FXML
    private TableView<?> touristTable;
    
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
    
    @FXML
    private TableColumn<?, ?> colTouristName;

    
  //0ºººººººººººººººº0    
  //0   CAR TABLE    0
  //0ºººººººººººººººº0
    
    @FXML
    private Button bttnCarSituation;

    @FXML
    private AnchorPane tableCarSituationPane;
    
    @FXML
    private TableView<?> carTable;
    
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
    private Button bttnModelBrand;
    
    @FXML
    private AnchorPane tableModelBrandPane;
    
    @FXML
    private TableView<?> modelBrandTable;
    
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
    private Button bttnCountry;

    @FXML
    private AnchorPane tableCountryPane;
    
    @FXML
    private TableView<?> countryTable;
    
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
    private Button bttnImport;

    @FXML
    private AnchorPane tableImportsPane;

    @FXML
    private TableView<?> importsBrandTable;
    
    @FXML
    private TableView<?> importsTable;
    
    @FXML
    private TableView<?> importsMonthTable;
    
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
	
	public Button getBttnReportTourists() {
		return bttnReportTourists;
	}

	public AnchorPane getTableReportsTouristsPane() {
		return tableReportsTouristsPane;
	}

	public Button getBttnReportCar() {
		return bttnReportCar;
	}

	public AnchorPane getTableReportsCarPane() {
		return tableReportsCarPane;
	}

	public Button getBttnReportContract() {
		return bttnReportContract;
	}

	public AnchorPane getTableReportsContractPane() {
		return tableReportsContractPane;
	}

	public Button getBttnReportDrivers() {
		return bttnReportDrivers;
	}

	public AnchorPane getTableReportsDriverPane() {
		return tableReportsDriverPane;
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
    		bttnReportTourists.setDisable(false);
    		bttnReportCar.setDisable(false);
    		bttnReportContract.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnCountry.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableReportsTouristsPane.setVisible(false);
    		tableReportsCarPane.setVisible(false);
    		tableReportsContractPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnCarSituation) {
    		tableCarSituationPane.setVisible(true);
    		
    		bttnCarSituation.setDisable(true);
    		bttnReportTourists.setDisable(false);
    		bttnReportCar.setDisable(false);
    		bttnReportContract.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnCountry.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableReportsTouristsPane.setVisible(false);
    		tableReportsCarPane.setVisible(false);
    		tableReportsContractPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableTouristsPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnModelBrand) {
    		tableModelBrandPane.setVisible(true);
    		
    		bttnModelBrand.setDisable(true);
    		bttnReportTourists.setDisable(false);
    		bttnReportCar.setDisable(false);
    		bttnReportContract.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableReportsTouristsPane.setVisible(false);
    		tableReportsCarPane.setVisible(false);
    		tableReportsContractPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableTouristsPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnCountry) {
    		tableCountryPane.setVisible(true);
    		
    		bttnCountry.setDisable(true);
    		bttnReportTourists.setDisable(false);
    		bttnReportCar.setDisable(false);
    		bttnReportContract.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnImport.setDisable(false);
    		
    		tableReportsTouristsPane.setVisible(false);
    		tableReportsCarPane.setVisible(false);
    		tableReportsContractPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableTouristsPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnImport) {
    		tableImportsPane.setVisible(true);
    		
    		bttnImport.setDisable(true);
    		bttnReportTourists.setDisable(false);
    		bttnReportCar.setDisable(false);
    		bttnReportContract.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		tableReportsTouristsPane.setVisible(false);
    		tableReportsCarPane.setVisible(false);
    		tableReportsContractPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableTouristsPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnReportTourists) {
    		tableReportsTouristsPane.setVisible(true);
    		
    		bttnReportTourists.setDisable(true);
    		bttnImport.setDisable(false);
    		bttnReportCar.setDisable(false);
    		bttnReportContract.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		tableTouristsPane.setVisible(false);
    		tableReportsCarPane.setVisible(false);
    		tableReportsContractPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnReportCar) {
    		tableReportsCarPane.setVisible(true);
    		
    		bttnReportCar.setDisable(true);
    		bttnReportTourists.setDisable(false);
    		bttnImport.setDisable(false);
    		bttnReportContract.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		tableReportsTouristsPane.setVisible(false);
    		tableTouristsPane.setVisible(false);
    		tableReportsContractPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnReportContract) {
    		tableReportsContractPane.setVisible(true);
    		
    		bttnReportContract.setDisable(true);
    		bttnReportCar.setDisable(false);
    		bttnReportTourists.setDisable(false);
    		bttnImport.setDisable(false);
    		bttnReportDrivers.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		tableReportsCarPane.setVisible(false);
    		tableReportsTouristsPane.setVisible(false);
    		tableTouristsPane.setVisible(false);
    		tableReportsDriverPane.setVisible(false);
    		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    	else if(event.getSource() == bttnReportDrivers) {
    		tableReportsDriverPane.setVisible(true);
    		
    		bttnReportDrivers.setDisable(true);
    		bttnReportContract.setDisable(false);
    		bttnReportCar.setDisable(false);
    		bttnReportTourists.setDisable(false);
    		bttnImport.setDisable(false);
    		bttnModelBrand.setDisable(false);
    		bttnTourists.setDisable(false);
    		bttnCarSituation.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		tableReportsContractPane.setVisible(false);
    		tableReportsCarPane.setVisible(false);
    		tableReportsTouristsPane.setVisible(false);
    		tableTouristsPane.setVisible(false);
       		tableCarSituationPane.setVisible(false);
    		tableImportsPane.setVisible(false);
    		tableModelBrandPane.setVisible(false);
    		tableCountryPane.setVisible(false);
    	}
    }
    
		

}
