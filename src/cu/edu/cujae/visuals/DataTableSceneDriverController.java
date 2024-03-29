package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.dto.CarDTO;
import cu.edu.cujae.dto.DriverDTO;
import cu.edu.cujae.dto.TouristDTO;
import cu.edu.cujae.services.ServicesLocator;
import cu.edu.cujae.utils.CarAux;
import cu.edu.cujae.utils.DriverAux;
import cu.edu.cujae.utils.TouristAux;
import cu.edu.cujae.utils.Validator;
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
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;

public class DataTableSceneDriverController {
	
	private double x = 0;
	private double y = 0;

	@FXML
	private ImageView imgSearch;

	@FXML
	private ImageView imgCancelSearch;
	
	@FXML
	private AnchorPane mainScenePane;
	
	@FXML
	private AnchorPane addScenePane;
	
    @FXML
    private AnchorPane tableScenePane;
    
    @FXML
    private AnchorPane addParametersScenePane;
    
    @FXML
    private TableView<DriverAux> driverTable;
    
    @FXML
    private TextField search;
	
    @FXML
    private Label lblName;
    
    @FXML
    private Label lblErrorEmpty;
    
    @FXML
    private Label lblErrorCI;
    
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
    private TableColumn<DriverAux, String> colAddAddress;

    @FXML
    private TableColumn<DriverAux, String> colAddID;

    @FXML
    private TableColumn<DriverAux, String> colAddLastName1;

    @FXML
    private TableColumn<DriverAux, String> colAddLastName2;

    @FXML
    private TableColumn<DriverAux, String> colAddLicense;

    @FXML
    private TableColumn<DriverAux, String> colAddName;
 
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
    
    @FXML
    private Button bttnAddDriver;
    
    @FXML
    private Button bttnModifyDriver;
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	Validator val = new Validator();
	
	String rolAux;
	
	public void initializeAdminORWorkerORVisitor (String rol) {
		if(rol.equalsIgnoreCase("administrador")) {
			rolAux = "administrador";
			notVisitorVBox.setVisible(true);
			visitorVBox.setVisible(false);
		}else if(rol.equalsIgnoreCase("trabajador")){
			rolAux = "trabajador";
			notVisitorVBox.setVisible(true);
			visitorVBox.setVisible(false);
		}else if(rol.equalsIgnoreCase("visitante")) {
			rolAux = "visitante";
			visitorVBox.setVisible(true);
			notVisitorVBox.setVisible(false);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void driverTableChargeData()throws ClassNotFoundException, SQLException {
		// Configurar cellValueFactory para cada columna
	    colAddAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
	    colAddID.setCellValueFactory(new PropertyValueFactory<>("ID"));
	    colAddLastName1.setCellValueFactory(new PropertyValueFactory<>("lastName1"));
	    colAddLastName2.setCellValueFactory(new PropertyValueFactory<>("lastName2"));
	    colAddLicense.setCellValueFactory(new PropertyValueFactory<>("category"));
	    colAddName.setCellValueFactory(new PropertyValueFactory<>("name"));
	    
		 // Desactiva los botones al inicio
        bttnDelete.setDisable(true);
        bttnModify.setDisable(true);


	    // Obtener la lista de conductores
	    ArrayList<DriverDTO> list = ServicesLocator.getDriverServices().get_driver_all();	
	    ArrayList<DriverAux> listaux = new ArrayList<DriverAux>();
	    
	    for (DriverDTO a : list) {
			listaux.add(new DriverAux(a));
		}
	    
	    ObservableList<DriverAux> driversList = FXCollections.observableArrayList();
	    driversList.addAll(listaux);
//	    
//	    // Establecer los elementos de la tabla
	    driverTable.setItems(driversList);


        // Añade un ChangeListener a la propiedad selectedItemProperty de la tabla
        driverTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

            }
        });
	    
	    // Añadir un listener a la propiedad selectedItemProperty
	    driverTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
                // Activa los botones cuando se selecciona una fila
	        	bttnAdd.setDisable(true);
                bttnDelete.setDisable(false);
                bttnModify.setDisable(false);
                bttnModifyDriver.setVisible(true);
                bttnAddDriver.setVisible(false);
                
                
                txtIDAdd.setText(newValue.getID());
                txtNameAdd.setText(newValue.getName());
                txtLastName1Add.setText(newValue.getLastName1());
                txtLastName2Add.setText(newValue.getLastName2());
                txtAddressAdd.setText(newValue.getAddress());
                cmboxLicenseAdd.setValue(newValue.getCategory());

	        } else {
                // Desactiva los botones cuando no hay ninguna fila seleccionada
                bttnDelete.setDisable(true);
                bttnModify.setDisable(true);
                bttnModifyDriver.setVisible(false);
                bttnAddDriver.setVisible(true);
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
		
		MainSceneController mainSceneController = loader.getController();
		mainSceneController.initializeAdminORWorkerORVisitor(rolAux);
		
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
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			bttnAddDriver.setVisible(false);
			bttnModifyDriver.setVisible(true);
			
			tableScenePane.setMaxHeight(382);
			driverTable.setMaxHeight(286);
			
			ObservableList<String> list = FXCollections.observableArrayList("B", "C", "D", "E");
	        cmboxLicenseAdd.setItems(list);
	        
			lblErrorCI.setVisible(false);
			lblErrorEmpty.setVisible(false);
			
		}else if(event.getSource() == bttnAdd){
			
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			bttnAddDriver.setVisible(true);
			bttnModifyDriver.setVisible(false);
			
			tableScenePane.setMaxHeight(382);
			driverTable.setMaxHeight(286);
			
			ObservableList<String> list = FXCollections.observableArrayList("B", "C", "D", "E");
	        cmboxLicenseAdd.setItems(list);
	        
			lblErrorCI.setVisible(false);
			lblErrorEmpty.setVisible(false);
			
		}
	}
	
	public void cancelModify(ActionEvent event) {
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		addScenePane.setVisible(true);
		tableScenePane.setMaxHeight(626);
		driverTable.setMaxHeight(554);
	}
	
	public void cancelAdd(ActionEvent event) {
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		addScenePane.setVisible(true);
		tableScenePane.setMaxHeight(626);
		driverTable.setMaxHeight(554);
	}


	public void insertDriver(ActionEvent event) throws ClassNotFoundException, SQLException {
		lblErrorCI.setVisible(false);
		lblErrorEmpty.setVisible(false);
		if(txtAddressAdd.getText() != "" && txtIDAdd.getText() != "" && txtLastName1Add.getText() != "" && txtLastName2Add.getText() != "" && txtNameAdd.getText() != "" && cmboxLicenseAdd.getValue() != "") {
			if(val.isIDCorrect(txtIDAdd.getText())) {
				String name = txtNameAdd.getText();
				String lastName1 = txtLastName1Add.getText();
				String lastName2 = txtLastName2Add.getText();
				String id = txtIDAdd.getText();
				String address = txtAddressAdd.getText();
				int license = cmboxLicenseAdd.getSelectionModel().getSelectedIndex() + 1;

				try {

					ServicesLocator.getDriverServices().insert_driver(id, name, lastName1, lastName2, license, address);

					txtNameAdd.setText("");
					txtLastName1Add.setText("");
					txtLastName2Add.setText("");
					txtIDAdd.setText("");
					txtAddressAdd.setText("");
					cmboxLicenseAdd.setValue("");


					try {
						driverTableChargeData();
					} catch (ClassNotFoundException | SQLException e) {
						Validator.formatError(e);
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "El conductor ha sido insertado con éxito");
					
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}else
				lblErrorCI.setVisible(true);
		}else
			lblErrorEmpty.setVisible(true);

	}
	
	public void modifyDriver(ActionEvent event) throws ClassNotFoundException, SQLException {
		lblErrorCI.setVisible(false);
		lblErrorEmpty.setVisible(false);
		if(txtAddressAdd.getText() != "" && txtIDAdd.getText() != "" && txtLastName1Add.getText() != "" && txtLastName2Add.getText() != "" && txtNameAdd.getText() != "" && cmboxLicenseAdd.getValue() != "") {
			if(val.isIDCorrect(txtIDAdd.getText())) {
				String name = txtNameAdd.getText();
				String lastName1 = txtLastName1Add.getText();
				String lastName2 = txtLastName2Add.getText();
				String id = txtIDAdd.getText();
				String address = txtAddressAdd.getText();
				int license = cmboxLicenseAdd.getSelectionModel().getSelectedIndex() + 1;

				try {

					ServicesLocator.getDriverServices().update_driver(id, name, lastName1, lastName2, license, address);

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
					
					JOptionPane.showMessageDialog(null, "El conductor ha sido modificado con éxito");
					
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}else
				lblErrorCI.setVisible(true);
		}else
			lblErrorEmpty.setVisible(true);

	}
	
    
	
	public void deleteDriver(ActionEvent event) throws ClassNotFoundException, SQLException {
	    ObservableList<DriverAux> allDrivers, singleDriver;
	    allDrivers = driverTable.getItems();
	    singleDriver = driverTable.getSelectionModel().getSelectedItems();

	    if (singleDriver.size() == 1) {
	    	DriverAux deleteDriver = singleDriver.get(0);
	        
	        int dialogButton = JOptionPane.YES_NO_OPTION;
	        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar el conductor con ID " + deleteDriver.getID() + "?", "Confirmación", dialogButton);
	        if(dialogResult == JOptionPane.YES_OPTION){
	            singleDriver.forEach(allDrivers::remove);
	            ServicesLocator.getDriverServices().delete_driver(deleteDriver.getID());
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Solo se puede eliminar un conductor a la vez");
	    }
	}
	
	public void searchUser(ActionEvent event) throws ClassNotFoundException, SQLException{
	    if(imgSearch.isVisible()) {
	        if(!search.getText().isEmpty()) {
	            driverTable.getItems().clear();
	            DriverDTO driverAux = ServicesLocator.getDriverServices().find_driver(search.getText());
	            if(driverAux != null) {
	            	DriverAux driver = new DriverAux(driverAux);
	                driverTable.getItems().add(driver);
	            } else {
	                // Mostrar un mensaje al usuario cuando no se encuentra el coche
	                JOptionPane.showMessageDialog(null, "No se encontró el coche: " + search.getText());
	            }
	            imgSearch.setVisible(false);
	            imgCancelSearch.setVisible(true);
	        }
	    } else {
	    	driverTable.getItems().clear();
	        driverTableChargeData();
	        search.setText("");
	        imgSearch.setVisible(true);
	        imgCancelSearch.setVisible(false);
	    }
	}

}
