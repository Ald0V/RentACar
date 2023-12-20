package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.dto.CarDTO;
import cu.edu.cujae.dto.ModelDTO;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataTableSceneCarController {
	
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
    private TableView<CarDTO> carTable;
    
    @FXML
    private TextField search;
	
    @FXML
    private Label lblName;
    
    @FXML
    private Label lblErrorEmpty;

    @FXML
    private Label lblErrorEmpty1;
    
    @FXML
    private Label lblErrorPlate;

    @FXML
    private Label lblErrorPlate1;
    
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
    private TableColumn<CarDTO, String> colAddBrand;

    @FXML
    private TableColumn<CarDTO, String> colAddCarSituation;

    @FXML
    private TableColumn<CarDTO, String> colAddColor;

    @FXML
    private TableColumn<CarDTO, Integer> colAddKM;

    @FXML
    private TableColumn<CarDTO, String> colAddModel;

    @FXML
    private TableColumn<CarDTO, String> colAddPlate;

//0ººººººººººººººººººº0  
//0   MODIFY TABLE    0
//0ººººººººººººººººººº0
    
    @FXML
    private TableColumn<?, ?> colModifyBrand;

    @FXML
    private TableColumn<?, ?> colModifyCarSituation;

    @FXML
    private TableColumn<?, ?> colModifyColor;

    @FXML
    private TableColumn<?, ?> colModifyKM;

    @FXML
    private TableColumn<?, ?> colModifyModel;

    @FXML
    private TableColumn<?, ?> colModifyPlate;
 
//*****************    
//*   ADD PANE    *
//*****************  
    
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
    
//********************   
//*   MODIFY PANE    *
//******************** 
    
    @FXML
    private ComboBox<String> cmboxBrandModify;

    @FXML
    private ComboBox<String> cmboxCarStatusModify;

    @FXML
    private ComboBox<String> cmboxModelModify;
    
    @FXML
    private TextField txtColorModify;

    @FXML
    private TextField txtPlateModify;
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	@SuppressWarnings("unchecked")
	private void carTableChargeData() throws ClassNotFoundException, SQLException {	
	    // Configurar cellValueFactory para cada columna
		colAddBrand.setCellValueFactory(new PropertyValueFactory<>("CarsBrand"));
		colAddCarSituation.setCellValueFactory(new PropertyValueFactory<>("Situation"));
		colAddColor.setCellValueFactory(new PropertyValueFactory<>("Color"));
		colAddKM.setCellValueFactory(new PropertyValueFactory<>("KM"));
		colAddModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
		colAddPlate.setCellValueFactory(new PropertyValueFactory<>("Plate"));	   

	    // Obtener la lista de turistas
//	    ArrayList<CarDTO> list = ServiceLocator.getInstance().getCars();		
//	    ObservableList<CarDTO> carList = FXCollections.observableArrayList();
//	    carList.addAll(list);
//	    
//	    // Establecer los elementos de la tabla
//	    carTable.setItems(carList);

	    
	    
	    // Añadir un listener a la propiedad selectedItemProperty
		carTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
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
	
	public void initializeCarTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        carTableChargeData();
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
			ObservableList<String> list = FXCollections.observableArrayList("En taller", "Alquilado", "Disponible");
			cmboxCarStatusModify.setItems(list);
			
		}else if(event.getSource() == bttnAdd){
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			tableScenePane.setMaxHeight(382);
			carTable.setMaxHeight(286);
			ObservableList<String> list = FXCollections.observableArrayList("En taller", "Alquilado", "Disponible");
			cmboxCarStatusAdd.setItems(list);
			
			modifyScenePane.setVisible(false);
			
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
		carTable.setMaxHeight(554);
	}
	
    public void insertCar(ActionEvent event) {
		if(txtColorAdd.getText() != "" && txtPlateAdd.getText() != "" && cmboxBrandAdd.getValue() != "" && cmboxCarStatusAdd.getValue() != "" && cmboxModelAdd.getValue() != "" ) {
			
			String color = txtColorAdd.getText();
			String plate = txtPlateAdd.getText();
			String brand = cmboxBrandAdd.getValue();
			String situation = cmboxCarStatusAdd.getValue();
			String model = cmboxModelAdd.getValue();
			
			try {
				AuxiliaryDTO brandAux = new AuxiliaryDTO(-1 ,brand);
				ModelDTO carAux = new ModelDTO(-1, model, brandAux);
				AuxiliaryDTO carAux2 = new AuxiliaryDTO(-1 ,situation);
				CarDTO car = new CarDTO(plate, carAux, 0, color, carAux2);
				
//				serviceLocator.createCar(car);

				txtColorAdd.setText("");
				txtPlateAdd.setText("");
				cmboxBrandAdd.setValue("");
				cmboxCarStatusAdd.setValue("");
				cmboxModelAdd.getValue();

				try {
					carTableChargeData();
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
	
    public void modifyCar(ActionEvent event) {
		
if(txtColorAdd.getText() != "" && txtPlateAdd.getText() != "" && cmboxBrandAdd.getValue() != "" && cmboxCarStatusAdd.getValue() != "" && cmboxModelAdd.getValue() != "" ) {
			
			String color = txtColorModify.getText();
			String plate = txtPlateModify.getText();
			String brand = cmboxBrandModify.getValue();
			String situation = cmboxCarStatusModify.getValue();
			String model = cmboxModelModify.getValue();
			
			try {
				AuxiliaryDTO brandAux = new AuxiliaryDTO(-1 ,brand);
				ModelDTO carAux = new ModelDTO(-1, model, brandAux);
				AuxiliaryDTO carAux2 = new AuxiliaryDTO(-1 ,situation);
				CarDTO car = new CarDTO(plate, carAux, 0, color, carAux2);
				
//				serviceLocator.updateCar(car);

				txtColorModify.setText("");
				txtPlateModify.setText("");
				cmboxBrandModify.setValue("");
				cmboxCarStatusModify.setValue("");
				cmboxModelModify.getValue();

				try {
					carTableChargeData();
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
    
    public void deleteCar(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<CarDTO> allCarss, singleCar;
        allCarss = carTable.getItems();
        singleCar = carTable.getSelectionModel().getSelectedItems();

        if (singleCar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero se debe seleccionar un item");
        } else {
            singleCar.forEach(allCarss::remove);
        }
    }
}

