package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.dto.CarDTO;
import cu.edu.cujae.dto.ModelDTO;
import cu.edu.cujae.services.ServicesLocator;
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
    private Label lblErrorPlate;
    
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
    
    @FXML
    private TableColumn<CarDTO, Integer> colCantKm;
 
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
    
    @FXML
    private Button bttnAddCar;
    
    @FXML
    private Button bttnModifyCar;
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	

	Validator val = new Validator();


	@SuppressWarnings("unchecked")
	private void carTableChargeData() throws ClassNotFoundException, SQLException {	
	    // Configurar cellValueFactory para cada columna
		colAddBrand.setCellValueFactory(new PropertyValueFactory<>("CarsBrand"));
		colAddCarSituation.setCellValueFactory(new PropertyValueFactory<>("Situation"));
		colAddColor.setCellValueFactory(new PropertyValueFactory<>("Color"));
		colAddModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
		colAddPlate.setCellValueFactory(new PropertyValueFactory<>("Plate"));	   

	    // Obtener la lista de turistas
//	    ArrayList<CarDTO> list = ServiceLocator.getInstance().getCars();		
//	    ObservableList<CarDTO> carList = FXCollections.observableArrayList();
//	    carList.addAll(list);
//	    
//	    // Establecer los elementos de la tabla
//	    carTable.setItems(carList);

		// Desactiva los botones al inicio
        bttnDelete.setDisable(true);
        bttnModify.setDisable(true);

	    // Añadir un listener a la propiedad selectedItemProperty
		carTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
	        	bttnDelete.setDisable(false);
                bttnModify.setDisable(false);
                bttnModifyCar.setVisible(true);
                bttnAddCar.setVisible(false);
	        	
	        	txtPlateAdd.setText(newValue.getPlate());
//	        	cmboxBrandAdd.setValue(newValue.getBrand());
//	        	cmboxModelAdd.setValue(newValue.getModel());
	        	txtColorAdd.setText(newValue.getColor());
//	        	cmboxCarStatusAdd.setValue(newValue.getSituation());
	        } else {
                // Desactiva los botones cuando no hay ninguna fila seleccionada
                bttnDelete.setDisable(true);
                bttnModify.setDisable(true);
                bttnModifyCar.setVisible(false);
                bttnAddCar.setVisible(true);
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
	
	public void switchForm(ActionEvent event) throws ClassNotFoundException, SQLException  {
		
		if(event.getSource() == bttnModify) {
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			bttnAddCar.setVisible(false);
			bttnModifyCar.setVisible(true);
			
	        ArrayList<AuxiliaryDTO> auxiliaryList = ServicesLocator.getBrandServices().get_brand_all();
	        ArrayList<String> namesList = new ArrayList<String>();
	        for (AuxiliaryDTO aux : auxiliaryList) {
	            namesList.add(aux.getName());
	        }
	        ObservableList<String> observableList = FXCollections.observableArrayList(namesList);
	        cmboxBrandAdd.setItems(observableList);
	        
	        //Si no sirve lo que le dije a Brenda
	        ArrayList<ModelDTO> auxiliaryList2 = ServicesLocator.getModelServices().get_model_all();
	        ArrayList<String> namesList2 = new ArrayList<String>();
	        for (ModelDTO aux2 : auxiliaryList2) {
	            namesList2.add(aux2.getName());
	        }
	        ObservableList<String> observableList2 = FXCollections.observableArrayList(namesList2);
	        cmboxBrandAdd.setItems(observableList2);
		
			tableScenePane.setMaxHeight(382);
			carTable.setMaxHeight(286);
			ObservableList<String> list = FXCollections.observableArrayList("Disponible", "Alquilado", "En taller");
			cmboxCarStatusAdd.setItems(list);
			
		}else if(event.getSource() == bttnAdd){
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			cmboxModelAdd.setDisable(true);
			
			bttnAddCar.setVisible(true);
			bttnModifyCar.setVisible(false);
			
			
	        ArrayList<AuxiliaryDTO> auxiliaryList = ServicesLocator.getBrandServices().get_brand_all();
	        ArrayList<String> namesList = new ArrayList<String>();
	        for (AuxiliaryDTO aux : auxiliaryList) {
	            namesList.add(aux.getName());
	        }
	        ObservableList<String> observableList = FXCollections.observableArrayList(namesList);
	        cmboxBrandAdd.setItems(observableList);
	        
	        //Si no sirve lo que le dije a Brenda
	        ArrayList<ModelDTO> auxiliaryList2 = ServicesLocator.getModelServices().get_model_all();
	        ArrayList<String> namesList2 = new ArrayList<String>();
	        for (ModelDTO aux2 : auxiliaryList2) {
	            namesList2.add(aux2.getName());
	        }
	        ObservableList<String> observableList2 = FXCollections.observableArrayList(namesList2);
	        cmboxBrandAdd.setItems(observableList2);
			
			
			tableScenePane.setMaxHeight(382);
			carTable.setMaxHeight(286);
			ObservableList<String> list = FXCollections.observableArrayList("Disponible", "Alquilado", "En taller");
			cmboxCarStatusAdd.setItems(list);
			
		}
	}
	
	public void cancelModify(ActionEvent event) {
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		addScenePane.setVisible(true);
		tableScenePane.setMaxHeight(626);
		carTable.setMaxHeight(554);
	}
	
	public void cancelAdd(ActionEvent event) {
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		addScenePane.setVisible(true);
		tableScenePane.setMaxHeight(626);
		carTable.setMaxHeight(554);
	}
	
	public void insertCar(ActionEvent event) {
		lblErrorPlate.setVisible(false);
		lblErrorEmpty.setVisible(false);

		if(txtColorAdd.getText() != "" && txtPlateAdd.getText() != "" && cmboxBrandAdd.getValue() != "" && cmboxCarStatusAdd.getValue() != "" && cmboxModelAdd.getValue() != "" ) {
			if(val.ValidatePlate(txtPlateAdd.getText())) {
				String color = txtColorAdd.getText();
				String plate = txtPlateAdd.getText();
				int itemBrand = cmboxBrandAdd.getSelectionModel().getSelectedIndex() + 1;
				int itemSituation = cmboxCarStatusAdd.getSelectionModel().getSelectedIndex() + 1;
				int itenModel = cmboxModelAdd.getSelectionModel().getSelectedIndex() + 1;
				
				try {
					
                    ServicesLocator.getCarServices().insert_car(plate, itemBrand, itenModel, 0, color, itemSituation);

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
				lblErrorPlate.setVisible(true);
		}else
			lblErrorEmpty.setVisible(true);

	}
	
	public void modifyCar(ActionEvent event) {
		lblErrorPlate.setVisible(false);
		lblErrorEmpty.setVisible(false);

		if(txtColorAdd.getText() != "" && txtPlateAdd.getText() != "" && cmboxBrandAdd.getValue() != "" && cmboxCarStatusAdd.getValue() != "" && cmboxModelAdd.getValue() != "" ) {
			if(val.ValidatePlate(txtPlateAdd.getText())) {
				String color = txtColorAdd.getText();
				String plate = txtPlateAdd.getText();
				int itemBrand = cmboxBrandAdd.getSelectionModel().getSelectedIndex() + 1;
				int itemSituation = cmboxCarStatusAdd.getSelectionModel().getSelectedIndex() + 1;
				int itenModel = cmboxModelAdd.getSelectionModel().getSelectedIndex() + 1;
				
				try {
					
                    ServicesLocator.getCarServices().update_car(plate, itemBrand, itenModel, 0, color, itemSituation);

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

			}
			else
				lblErrorPlate.setVisible(true);
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

