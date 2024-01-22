package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.ContractDTO;
import cu.edu.cujae.services.ServicesLocator;
import cu.edu.cujae.utils.ContractAux;
import cu.edu.cujae.utils.Validator;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataTableSceneContractController {
	
	private double x = 0;
	private double y = 0;
	
	@FXML
	private AnchorPane mainScenePane;
	
	@FXML
	private AnchorPane addScenePane;
	
    @FXML
    private AnchorPane tableScenePane;
    
    @FXML
    private AnchorPane addParametersScenePane;

    @FXML
    private AnchorPane addNewTourist;
    
    @FXML
    private AnchorPane addNewCar;
    
    @FXML
    private AnchorPane addNewDriver;
    
    @FXML
    private AnchorPane deliveryDatePane;
    
    @FXML
    private Button bttnAddNewTourist;
    
    @FXML
    private Button bttnAddNewCar;
    
    @FXML
    private TableView<ContractDTO> contractTable;
    
    @FXML
    private TextField search;
	
    @FXML
    private Label lblName;
    
    @FXML
    private Label lblErrorEmpty;
    
    @FXML
    private Label lblErrorDate;
    
    @FXML
    private Label lblErrorEmptyTourist;
    
    @FXML
    private Label lblErrorEmptyCar;
    
    @FXML
    private Label lblErrorEmptyDriver;
    
    @FXML
    private Label lblErrorCI;
    
    @FXML
    private Label lblErrorAge;
    
    @FXML
    private Label lblErrorPassport;
    
    @FXML
    private Label lblErrorPhone;
    
    @FXML
    private Label lblErrorPlate;
    
    @FXML
    private Button bttnModify;
    
    @FXML
    private Button bttnAdd; 
    
    @FXML
    private Button bttnAddNewCountry;
    
    
    
//*****************    
//*   ADD PANE    *
//*****************  
    
    @FXML
    private ComboBox<String> cmboxCarAdd;

    @FXML
    private ComboBox<String> cmboxPayMethodAdd;

    @FXML
    private ComboBox<String> cmboxTouristAdd;
    
    @FXML
    private ComboBox<String> cmboxDriverAdd;
    
    @FXML
    private DatePicker pickdateStartAdd;
    
    @FXML
    private DatePicker pickdateEndDate;
     
    @FXML
    private Button bttnAddContract;
    
    @FXML
    private Button bttnModifyContract;
    
    @FXML
    private Button bttnCloseContract;
    
//0ºººººººººººººººº0    
//0   ADD TABLE    0
//0ºººººººººººººººº0 
    
    @FXML
    private TableColumn<ContractDTO, String> colAddCar;

    @FXML
    private TableColumn<ContractDTO, String> colAddDriverRental;

    @FXML
    private TableColumn<ContractDTO, LocalDate> colAddEndDate;

    @FXML
    private TableColumn<ContractDTO, String> colAddPayMethod;

    @FXML
    private TableColumn<ContractDTO, Integer> colAddProrroga;

    @FXML
    private TableColumn<ContractDTO, Float> colAddTotalImport;

    @FXML
    private TableColumn<ContractDTO, String> colAddTourist;

    @FXML
    private TableColumn<ContractDTO, LocalDate>  colAddstartDate;    
    
//*************************    
//*   TOURIST ADD PANE    *
//*************************  
    
    @FXML
    private ComboBox<String> cmboxCountryAdd;

    @FXML
    private ComboBox<String> cmboxSexAdd;
    
    @FXML
    private TextField txtAgeAdd;

    @FXML
    private TextField txtCountryAdd;

    @FXML
    private TextField txtLastName1Add;

    @FXML
    private TextField txtLastName2Add;

    @FXML
    private TextField txtNameAdd;

    @FXML
    private TextField txtPassportAdd;

    @FXML
    private TextField txtPhoneAdd;
    
    @FXML
    private ImageView imgCountryAdd;
    
//*********************    
//*   CAR ADD PANE    *
//*********************
    
    @FXML
    private ComboBox<String> cmboxBrandAdd;

    @FXML
    private ComboBox<String> cmboxCarStatusAdd;

    @FXML
    private ComboBox<String> cmboxModelAdd;
    
    @FXML
    private TextField txtColorAdd;

    @FXML
    private TextField txtPlateAdd;  
    
//************************    
//*   Driver ADD PANE    *
//************************
    
    @FXML
    private ComboBox<String> cmboxDriverLicenseAdd;
    
    @FXML
    private TextField txtDriverAddressAdd;

    @FXML
    private TextField txtDriverIDAdd;

    @FXML
    private TextField txtDriverLastName1Add;

    @FXML
    private TextField txtDriverLastName2Add;

    @FXML
    private TextField txtDriverNameAdd;
    
    @FXML
    private Button bttnAddNewDriver;
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	Validator val = new Validator();
	
	@SuppressWarnings("unchecked")
	private void contractTableChargeData()throws ClassNotFoundException, SQLException {
		 // Configurar cellValueFactory para cada columna
		
		colAddCar.setCellValueFactory(new PropertyValueFactory<>("Carro"));
	    colAddDriverRental.setCellValueFactory(new PropertyValueFactory<>("DriverRental"));
	    colAddEndDate.setCellValueFactory(new PropertyValueFactory<>("ContractEnd"));
	    colAddPayMethod.setCellValueFactory(new PropertyValueFactory<>("PayMethod"));
	    colAddProrroga.setCellValueFactory(new PropertyValueFactory<>("Prorroga"));
	    colAddstartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
	    colAddTotalImport.setCellValueFactory(new PropertyValueFactory<>("TotalImport"));
	    colAddTourist.setCellValueFactory(new PropertyValueFactory<>("Tourist"));

	    // Obtener la lista de turistas
//	    ArrayList<ContractDTO> list = ServiceLocator.getInstance().getContracts();		
//	    ObservableList<ContractDTO> contractList = FXCollections.observableArrayList();
//	    contractList.addAll(list);
//	    
//	    // Establecer los elementos de la tabla
//	    contractTable.setItems(contractList);
	    
	    // Añadir un listener a la propiedad selectedItemProperty
	    contractTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
                // Activa los botones cuando se selecciona una fila
                bttnModify.setDisable(false);
                bttnModifyContract.setVisible(true);
                bttnAddContract.setVisible(false);
	        	
                cmboxTouristAdd.setValue(newValue.getPassport());
                cmboxCarAdd.setValue(newValue.getPlate());
                cmboxPayMethodAdd.setValue(newValue.getPayMethod());
                cmboxDriverAdd.setValue(newValue.getDriver());
                pickdateStartAdd.setValue(newValue.getStartDate());
                pickdateEndDate.setValue(newValue.getEndDate());
                
//	            iTidTextField=(String.valueOf(newValue.getpassport()));
//	            iTnameTextField.setText(newValue.getName());	 
//	            iTprovinceChoiceBox.setValue(newValue.getCountry());
//	            iTPCHamountTextField.setText(String.valueOf(newValue.getCantRentalCars()));
//	            iTWCHamountTextField.setText(String.valueOf(newValue.getRentalTotalValue()));
//	            iTmascotTextField.setText(newValue.getLastName1());
//	            iTcolorTextField.setText(newValue.getLastName2());
	        } else {
                // Desactiva los botones cuando no hay ninguna fila seleccionada
                bttnModify.setDisable(true);
                bttnModifyContract.setVisible(false);
                bttnAddContract.setVisible(true);
            }
	    });
	}
	
	public void initializeContractTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        contractTableChargeData();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void logout(ActionEvent event) {
		stage = (Stage)mainScenePane.getScene().getWindow(); 
		stage.close();
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
	
	public void displayName(String table) {
		lblName.setText(table);
	}
	
	public void switchForm(ActionEvent event) {
		
		if(event.getSource() == bttnModify) {
			
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			bttnAddContract.setVisible(false);
			bttnModifyContract.setVisible(true);
			bttnCloseContract.setVisible(true);
			
			tableScenePane.setMaxHeight(382);
			contractTable.setMaxHeight(286);
			
		}else if(event.getSource() == bttnAdd){
			
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			bttnAddContract.setVisible(true);
			bttnModifyContract.setVisible(false);
			bttnCloseContract.setVisible(false);
			
			tableScenePane.setMaxHeight(382);
			contractTable.setMaxHeight(286);
			
		}
			
		
	}
		
	
	
	public void switchNewTouristCarOrDriver(ActionEvent event) {
		
		if(event.getSource() == bttnAddNewTourist) {
			addNewTourist.setVisible(true);
		}else if(event.getSource() == bttnAddNewCar) {
			addNewCar.setVisible(true);
		}else if(event.getSource() == bttnAddNewDriver) {
			addNewDriver.setVisible(true);
		}
	}
	
	public void cancelModify(ActionEvent event) {
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		bttnModify.setDisable(false);
		addScenePane.setVisible(true);
		tableScenePane.setMaxHeight(626);
		contractTable.setMaxHeight(554);
	}
	
	public void cancelAdd(ActionEvent event) {
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		bttnModify.setDisable(false);
		addScenePane.setVisible(true);
		tableScenePane.setMaxHeight(626);
		contractTable.setMaxHeight(554);
	}
	
	public void cancelNewTourist(ActionEvent event) {
		addNewTourist.setVisible(false);
		
		cmboxCountryAdd.setVisible(true);
		imgCountryAdd.setVisible(true);
		bttnAddNewCountry.setDisable(false);
		txtCountryAdd.setVisible(false);
	}
	
	public void cancelNewCar(ActionEvent event) {
		addNewCar.setVisible(false);
	}
	
	public void cancelNewDriver(ActionEvent event) {
		addNewDriver.setVisible(false);
	}
	
	public void newTouristAdd(ActionEvent event) {
				
		txtCountryAdd.setVisible(true);
		bttnAddNewCountry.setDisable(true);
		cmboxCountryAdd.setVisible(false);
		imgCountryAdd.setVisible(false);

	}
	
    public void insertContract(ActionEvent event)throws ClassNotFoundException, SQLException {
		lblErrorEmpty.setVisible(false);
		lblErrorDate.setVisible(false);
		
		if (cmboxCarAdd.getSelectionModel().getSelectedItem() != null && cmboxPayMethodAdd.getSelectionModel().getSelectedItem() != null && cmboxTouristAdd.getSelectionModel().getSelectedItem() != null && pickdateStartAdd.getValue() != null && pickdateEndDate.getValue() != null) {
			if(val.validateDate(pickdateStartAdd.getValue(), pickdateEndDate.getValue())) {
				
				String car = (String) cmboxCarAdd.getValue();
				String payMethod = (String) cmboxPayMethodAdd.getValue();
				String tourist = (String) cmboxTouristAdd.getValue();
				String driver = (String) cmboxDriverAdd.getValue();
				LocalDate startDate = pickdateStartAdd.getValue();
				LocalDate endDate = pickdateEndDate.getValue();
				
				try {
					//					ContractDTO contract = new ContractDTO(car, tourist, startDate, endDate, null, payMethod, driver);
					//					ServicesLocator.getContractsServices().insert_contract(car, tourist, startDate, endDate, null, payMethod, driver);

					cmboxCarAdd.setValue("");
					cmboxPayMethodAdd.setValue("");
					cmboxTouristAdd.setValue("");
					cmboxDriverAdd.setValue("");
					pickdateStartAdd.setValue(null);
					pickdateEndDate.setValue(null);
					try {
						contractTableChargeData();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}else
				lblErrorDate.setVisible(true);
		} else {
			lblErrorEmpty.setVisible(true);
		}

    }
    
    public void modifyContract(ActionEvent event) {
    	lblErrorEmpty.setVisible(false);
    	lblErrorDate.setVisible(false);

    	if (cmboxCarAdd.getSelectionModel().getSelectedItem() != null && cmboxPayMethodAdd.getSelectionModel().getSelectedItem() != null && cmboxTouristAdd.getSelectionModel().getSelectedItem() != null && pickdateStartAdd.getValue() != null && pickdateEndDate.getValue() != null) {
    		if(val.validateDate(pickdateStartAdd.getValue(), pickdateEndDate.getValue())) {

    			String car = (String) cmboxCarAdd.getValue();
    			String payMethod = (String) cmboxPayMethodAdd.getValue();
    			String tourist = (String) cmboxTouristAdd.getValue();
    			String driver = (String) cmboxDriverAdd.getValue();
    			LocalDate startDate = pickdateStartAdd.getValue();
    			LocalDate endDate = pickdateEndDate.getValue();

    			try {
    				//					ContractDTO contract = new ContractDTO(car, tourist, startDate, endDate, null, payMethod, driver);
    				//					ServicesLocator.getContractsServices().update_contract(car, tourist, startDate, endDate, null, payMethod, driver);

    				cmboxCarAdd.setValue("");
    				cmboxPayMethodAdd.setValue("");
    				cmboxTouristAdd.setValue("");
    				cmboxDriverAdd.setValue("");
    				pickdateStartAdd.setValue(null);
    				pickdateEndDate.setValue(null);
    				try {
    					contractTableChargeData();
    				} catch (ClassNotFoundException | SQLException e) {
    					e.printStackTrace();
    				}
    			} catch (Exception e) {
    				JOptionPane.showMessageDialog(null, e.getMessage());
    			}

    		}else
    			lblErrorDate.setVisible(true);
    	} else {
    		lblErrorEmpty.setVisible(true);
    	}

    }
	
	public void insertTourist(ActionEvent event) {
		
	}
	
	public void insertCar(ActionEvent event) {
		
	}
	
	public void insertDriver(ActionEvent event) {
		
	}
    
	public void openDeliveryDate(ActionEvent event) {
		
		addParametersScenePane.setVisible(false);
		deliveryDatePane.setVisible(true);
	}
	
	public void closeDeliveryDate(ActionEvent event) {
		
		addParametersScenePane.setVisible(true);
		deliveryDatePane.setVisible(false);
	}


    
    


}
