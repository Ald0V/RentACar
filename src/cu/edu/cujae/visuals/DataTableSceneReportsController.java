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
import cu.edu.cujae.services.ReportServices;
import cu.edu.cujae.utils.BadTouristAux;
import cu.edu.cujae.utils.CarStatusAux;
import cu.edu.cujae.utils.ModelBrandAux;
import cu.edu.cujae.utils.CountryContractAux;
import cu.edu.cujae.utils.ImportsAux;
import java.time.format.DateTimeFormatter;

public class DataTableSceneReportsController {
	
	private double x = 0;
	private double y = 0;
	
	@FXML
    private AnchorPane reportsScenePane;
    
    @FXML
    private Button bttnBack;

    @FXML
    private AnchorPane mainScenePane;  
    
    @FXML
    private Label lblCurrentDate;
    
    
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
    private TableView<BadTouristAux> touristTable;
    
    @FXML
    private TableColumn<BadTouristAux, LocalDate> colTouristDateCar;

    @FXML
    private TableColumn<BadTouristAux, LocalDate> colTouristEndDate;

    @FXML
    private TableColumn<BadTouristAux, String> colTouristLastName1;

    @FXML
    private TableColumn<BadTouristAux, String> colTouristLastName2;
    
    @FXML
    private TableColumn<BadTouristAux, String> colTouristName;

    
  //0ºººººººººººººººº0    
  //0   CAR TABLE    0
  //0ºººººººººººººººº0
    
    @FXML
    private Button bttnCarSituation;

    @FXML
    private AnchorPane tableCarSituationPane;
    
    @FXML
    private TableView<CarStatusAux> carTable;
    
    @FXML
    private TableColumn<CarStatusAux, String> colCarSPlate;

    @FXML
    private TableColumn<CarStatusAux, String> colCarSBrand;

    @FXML
    private TableColumn<CarStatusAux, LocalDate> colCarSEndDate;

    @FXML
    private TableColumn<CarStatusAux, String> colCarSSituation;
      
  //0ºººººººººººººººººººººººº0  
  //0   BRAND/MODEL TABLE    0
  //0ºººººººººººººººººººººººº0
    
    @FXML
    private Button bttnModelBrand;
    
    @FXML
    private AnchorPane tableModelBrandPane;
    
    @FXML
    private TableView<ModelBrandAux> modelBrandTable;
    
    @FXML
    private TableColumn<ModelBrandAux, Float> colBrand$Cheque;

    @FXML
    private TableColumn<ModelBrandAux, Float> colBrand$CreditCard;

    @FXML
    private TableColumn<ModelBrandAux, Float> colBrand$Paper;

    @FXML
    private TableColumn<ModelBrandAux, String> colBrandBrand;

    @FXML
    private TableColumn<ModelBrandAux, Integer> colBrandCantRentalDays;

    @FXML
    private TableColumn<ModelBrandAux, Float> colBrandImportBrand;

    @FXML
    private TableColumn<ModelBrandAux, String> colBrandModel;

    @FXML
    private TableColumn<ModelBrandAux, Float> colBrandTotalImport;
    
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
    private TableView<CountryContractAux> countryTable;
   
    @FXML
    private TableColumn<CountryContractAux, Float> colCountry$PaperTotal;

    @FXML
    private TableColumn<CountryContractAux, String> colCountryBrand;

    @FXML
    private TableColumn<CountryContractAux, Integer> colCountryCantRentalDays;

    @FXML
    private TableColumn<CountryContractAux, String> colCountryCountry;

    @FXML
    private TableColumn<CountryContractAux, String> colCountryModel;

    @FXML
    private TableColumn<CountryContractAux, Integer> colCountryProrroga;

    @FXML
    private TableColumn<CountryContractAux, Float> colCountryTotal;
    
  //0ºººººººººººººººººººººººººº0    
  //0   TOTAL IMPORTS TABLE    0
  //0ºººººººººººººººººººººººººº0   
    
    @FXML
    private Button bttnImport;

    @FXML
    private AnchorPane tableImportsPane;

    @FXML
    private TableView<ImportsAux> importsBrandTable;
    
    @FXML
    private TableView<ImportsAux> importsTable;
    

    @FXML
    private TableColumn<ImportsAux, Float> colImports;

    @FXML
    private TableColumn<ImportsAux, String> colImportsYear;

    @FXML
    private TableColumn<ImportsAux, String> colImportsMonth;
    
    
    
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
	
	@FXML
	public void initializeDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        lblCurrentDate.setText(currentDate.format(formatter));
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
    		//tableTouristsPane.setVisible(true);
    		ReportServices.reports.CargarReporte_5();
    		
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
    		//tableCarSituationPane.setVisible(true);
    		ReportServices.reports.CargarReporte_6();
    		
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
    		//tableModelBrandPane.setVisible(true);
    		ReportServices.reports.CargarReporte_7();
    		
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
    		//tableCountryPane.setVisible(true);
    		ReportServices.reports.CargarReporte_8();
    		
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
    		//tableImportsPane.setVisible(true);
    		ReportServices.reports.CargarReporte_9();
    		
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
    		//tableReportsTouristsPane.setVisible(true);
    		ReportServices.reports.CargarReporte_1();
    		
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
    		//tableReportsCarPane.setVisible(true);
    		ReportServices.reports.CargarReporte_2();
    		
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
    		//tableReportsContractPane.setVisible(true);
    		ReportServices.reports.CargarReporte_3();
    		
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
    		//tableReportsDriverPane.setVisible(true);
    		ReportServices.reports.CargarReporte_4();
    		
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
