package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.dto.DriverDTO;
import cu.edu.cujae.dto.TouristDTO;
import cu.edu.cujae.utils.TouristAux;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.control.ComboBox;

public class DataTableSceneDriverController {
	
	private double x = 0;
	private double y = 0;
	
	@FXML
	private AnchorPane mainScenePane;
	
	@FXML
	private AnchorPane addScenePane;
	
	@FXML
	private AnchorPane modifyScenePane;
	
    @FXML
    private AnchorPane tableScenePane;
    
    @FXML
    private AnchorPane addParametersScenePane;
    
    @FXML
    private TableView<DriverDTO> driverTable;
    
    @FXML
    private TextField search;
	
    @FXML
    private Label lblName;
    
    @FXML
    private Label lblErrorEmpty;

    @FXML
    private Label lblErrorEmpty1;
    
    @FXML
    private Label lblErrorCI;

    @FXML
    private Label lblErrorCI1;
    
    @FXML
    private Button bttnModify;
    
    @FXML
    private Button bttnAdd;
    
    @FXML
    private Button bttnDelete;
    
//0ºººººººººººººººº0    
//0   ADD TABLE    0
//0ºººººººººººººººº0 
    
    @FXML
    private TableColumn<DriverDTO, String> colAddAddress;

    @FXML
    private TableColumn<DriverDTO, String> colAddID;

    @FXML
    private TableColumn<DriverDTO, String> colAddLastName1;

    @FXML
    private TableColumn<DriverDTO, String> colAddLastName2;

    @FXML
    private TableColumn<DriverDTO, String> colAddLicense;

    @FXML
    private TableColumn<DriverDTO, String> colAddName;

    @FXML
    private TableColumn<DriverDTO, Integer> colAddNumerOfCars;
 
//*****************    
//*   ADD PANE    *
//***************** 
    
    @FXML
    private ComboBox<String> cmboxLicenseAdd;
    
    @FXML
    private TextField txtAddressAdd;

    @FXML
    private TextField txtIDAdd;

    @FXML
    private TextField txtLastName1Add;

    @FXML
    private TextField txtLastName2Add;

    @FXML
    private TextField txtNameAdd;
    
//********************   
//*   MODIFY PANE    *
//******************** 
    
    @FXML
    private ComboBox<String> cmboxLicenseModify;
    
    @FXML
    private TextField txtAddressModify;

    @FXML
    private TextField txtIDModify;

    @FXML
    private TextField txtLastName1Modify;

    @FXML
    private TextField txtLastName2Modify;

    @FXML
    private TextField txtNameModify;
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@SuppressWarnings("unchecked")
	public void driverTableChargeData()throws ClassNotFoundException, SQLException {
		// Configurar cellValueFactory para cada columna
	    colAddAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
	    colAddID.setCellValueFactory(new PropertyValueFactory<>("ID"));
	    colAddLastName1.setCellValueFactory(new PropertyValueFactory<>("LastName1"));
	    colAddLastName2.setCellValueFactory(new PropertyValueFactory<>("LastName2"));
	    colAddLicense.setCellValueFactory(new PropertyValueFactory<>("Passport"));
	    colAddName.setCellValueFactory(new PropertyValueFactory<>("Name"));
	    colAddNumerOfCars.setCellValueFactory(new PropertyValueFactory<>("NumberofCars"));

	    // Obtener la lista de conductores
//	    ArrayList<DriverDTO> list = ServiceLocator.getInstance().getDrivers();		
//	    ObservableList<DriverDTO> driversList = FXCollections.observableArrayList();
//	    driversList.addAll(list);
//	    
//	    // Establecer los elementos de la tabla
//	    driverTable.setItems(driversList);

	    
	    
	    // Añadir un listener a la propiedad selectedItemProperty
	    driverTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
//	            iTidTextField=(String.valueOf(newValue.getpassport()));
//	            iTnameTextField.setText(newValue.getName());	 
//	            iTprovinceChoiceBox.setValue(newValue.getCountry());
//	            iTPCHamountTextField.setText(String.valueOf(newValue.getCantRentalCars()));
//	            iTWCHamountTextField.setText(String.valueOf(newValue.getRentalTotalValue()));
//	            iTmascotTextField.setText(newValue.getLastName1());
//	            iTcolorTextField.setText(newValue.getLastName2());
	        }
	    });
	}
	
	public void initializeDriverTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        driverTableChargeData();
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
			bttnDelete.setDisable(true);
			modifyScenePane.setVisible(true);
			addScenePane.setVisible(false);
			
			ObservableList<String> list = FXCollections.observableArrayList("B", "C", "D", "E");
	        cmboxLicenseModify.setItems(list);
			
		}else if(event.getSource() == bttnAdd){
			
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			tableScenePane.setMaxHeight(382);
			driverTable.setMaxHeight(286);
			
			modifyScenePane.setVisible(false);
			
			ObservableList<String> list = FXCollections.observableArrayList("B", "C", "D", "E");
	        cmboxLicenseAdd.setItems(list);
			
		}
	}
	
	public void cancelModify(ActionEvent event) {
		modifyScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		bttnModify.setDisable(false);
		bttnDelete.setDisable(false);
		addScenePane.setVisible(true);
	}
	
	public void cancelAdd(ActionEvent event) {
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		bttnModify.setDisable(false);
		bttnDelete.setDisable(false);
		addScenePane.setVisible(true);
		tableScenePane.setMaxHeight(626);
		driverTable.setMaxHeight(554);
	}


	public void insertDriver(ActionEvent event) {
		if(txtAddressAdd.getText() != "" && txtIDAdd.getText() != "" && txtLastName1Add.getText() != "" && txtLastName2Add.getText() != "" && txtNameAdd.getText() != "" && cmboxLicenseAdd.getValue() != "") {
			String name = txtNameAdd.getText();
			String lastName1 = txtLastName1Add.getText();
			String lastName2 = txtLastName2Add.getText();
			String id = txtIDAdd.getText();
			String address = txtAddressAdd.getText();
			String license = cmboxLicenseAdd.getValue();
			
			try {
				AuxiliaryDTO aux = new AuxiliaryDTO(-1, license);
				DriverDTO tourist = new DriverDTO(id, name, lastName1, lastName2, aux, address);
				
//				serviceLocator.insertDriver(driver);

			     txtNameAdd.setText("");
			     txtLastName1Add.setText("");
			     txtLastName2Add.setText("");
			     txtIDAdd.setText("");
			     txtAddressAdd.setText("");
			     cmboxLicenseAdd.setValue("");


				try {
					driverTableChargeData();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}else
			lblErrorEmpty.setVisible(true);

	}
	
    public void modifyDriver(ActionEvent event) {
		if(txtAddressAdd.getText() != "" && txtIDAdd.getText() != "" && txtLastName1Add.getText() != "" && txtLastName2Add.getText() != "" && txtNameAdd.getText() != "" && cmboxLicenseAdd.getValue() != "") {
			String name = txtNameAdd.getText();
			String lastName1 = txtLastName1Add.getText();
			String lastName2 = txtLastName2Add.getText();
			String id = txtIDAdd.getText();
			String address = txtAddressAdd.getText();
			String license = cmboxLicenseAdd.getValue();
			
			try {
				AuxiliaryDTO aux = new AuxiliaryDTO(-1, license);
				DriverDTO tourist = new DriverDTO(id, name, lastName1, lastName2, aux, address);
				
//				serviceLocator.updateDriver(driver);

				txtNameAdd.setText("");
				txtLastName1Add.setText("");
				txtLastName2Add.setText("");
				txtIDAdd.setText("");
				txtAddressAdd.setText("");
				cmboxLicenseAdd.setValue("");


				try {
					driverTableChargeData();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}else
			lblErrorEmpty.setVisible(true);

	}
	
    
    public void deleteDriver(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<DriverDTO> allDrivers, singleDriver;
        allDrivers = driverTable.getItems();
        singleDriver = driverTable.getSelectionModel().getSelectedItems();

        if (singleDriver.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero se debe seleccionar un item");
        } else {
            singleDriver.forEach(allDrivers::remove);
        }
    }
}
