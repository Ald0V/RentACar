package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.dto.CarDTO;
import cu.edu.cujae.dto.ModelDTO;
import cu.edu.cujae.services.ServicesLocator;
import cu.edu.cujae.utils.CarAux;
import cu.edu.cujae.utils.Validator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private TableView<CarAux> carTable;
    
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
    private TableColumn<CarAux, String> colAddBrand;

    @FXML
    private TableColumn<CarAux, String> colAddCarSituation;

    @FXML
    private TableColumn<CarAux, String> colAddColor;

//    ?????
    @FXML
    private TableColumn<CarAux, Integer> colAddKM;

    @FXML
    private TableColumn<CarAux, String> colAddModel;

    @FXML
    private TableColumn<CarAux, String> colAddPlate;
    
    @FXML
    private TableColumn<CarAux, Integer> colCantKm;
 
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
	
	private int km;
	
    String rolAux;
	
	Validator val = new Validator();
	
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
	private void carTableChargeData() throws ClassNotFoundException, SQLException {	
	    // Configurar cellValueFactory para cada columna
		colAddBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
		colAddCarSituation.setCellValueFactory(new PropertyValueFactory<>("Situation"));
		colAddColor.setCellValueFactory(new PropertyValueFactory<>("Color"));
		colAddModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
		colAddPlate.setCellValueFactory(new PropertyValueFactory<>("Plate"));
		colCantKm.setCellValueFactory(new PropertyValueFactory<>("Km"));

		// Desactiva los botones al inicio
        bttnDelete.setDisable(true);
        bttnModify.setDisable(true);

	    // Obtener la lista de turistas
	    ArrayList<CarDTO> list = ServicesLocator.getCarServices().get_car_all();
	    ArrayList<CarAux> listaux = new ArrayList<CarAux>();
	    
	    for (CarDTO a : list) {
			listaux.add(new CarAux(a));
		}
	    
	    
	    ObservableList<CarAux> carList = FXCollections.observableArrayList();
	    carList.addAll(listaux);
//	    
//	    // Establecer los elementos de la tabla
	    carTable.setItems(carList);
		
		// Añades un listener a tu primer ComboBox para que, cuando cambie el valor seleccionado, cambie el contenido del segundo ComboBox
		cmboxBrandAdd.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
		        // Aquí obtienes los modelos de la base de datos en función de la marca seleccionada
		        LinkedList<ModelDTO> models;
				try {
					models = ServicesLocator.getModelServices().select_model_by_brand(newValue);


		        // Creas una nueva lista para guardar solo los nombres de los modelos
		        ArrayList<String> namesList = new ArrayList<String>();

		        // Recorres tu lista original y vas añadiendo los nombres a la nueva lista
		        for (ModelDTO model : models) {
		            namesList.add(model.getName());
		        }

		        // Conviertes la lista de nombres a un ObservableList
		        ObservableList<String> observableList = FXCollections.observableArrayList(namesList);

		        // Añades los nombres al segundo ComboBox
		        cmboxModelAdd.setItems(observableList);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
	    
//	    cmboxBrandAdd.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//	        @Override
//	        public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//	            // Imprime los valores antiguo y nuevo cada vez que cambia la selección
//	            System.out.println("Valor antiguo: " + oldValue);
//	            System.out.println("Valor nuevo: " + newValue);
//
//	            // Aquí obtienes los modelos de la base de datos en función de la marca seleccionada
//	            LinkedList<ModelDTO> models;
//	            try {
//	                models = ServicesLocator.getModelServices().select_model_by_brand(newValue);
//
//	                // Imprime el número de modelos recuperados
//	                System.out.println("Número de modelos recuperados: " + models.size());
//
//	                // Creas una nueva lista para guardar solo los nombres de los modelos
//	                ArrayList<String> namesList = new ArrayList<String>();
//
//	                // Recorres tu lista original y vas añadiendo los nombres a la nueva lista
//	                for (ModelDTO model : models) {
//	                    namesList.add(model.getName());
//	                }
//
//	                // Conviertes la lista de nombres a un ObservableList
//	                ObservableList<String> observableList = FXCollections.observableArrayList(namesList);
//
//	                // Añades los nombres al segundo ComboBox
//	                cmboxModelAdd.setItems(observableList);
//	            } catch (SQLException e) {
//	                // Imprime el mensaje de error
//	                System.out.println("Error al recuperar los modelos: " + e.getMessage());
//	                e.printStackTrace();
//	            }
//	        }
//	    });



	    // Añadir un listener a la propiedad selectedItemProperty
		carTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
	        	bttnAdd.setDisable(true);
	        	bttnDelete.setDisable(false);
                bttnModify.setDisable(false);
                bttnModifyCar.setVisible(true);
                bttnAddCar.setVisible(false);
	        	
	        	txtPlateAdd.setText(newValue.getPlate());
	        	cmboxBrandAdd.setValue(newValue.getBrand());
	        	cmboxModelAdd.setValue(newValue.getModel());
	        	txtColorAdd.setText(newValue.getColor());
	        	cmboxCarStatusAdd.setValue(newValue.getSituation());
	        	km=newValue.getKm();
	        	
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
		
		MainSceneController mainSceneController = loader.getController();
		mainSceneController.initializeAdminORWorkerORVisitor(rolAux);
				
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
			
			ObservableList<String> list = FXCollections.observableArrayList("disponible", "alquilado", "en taller");
			cmboxCarStatusAdd.setItems(list);
			
	        ArrayList<AuxiliaryDTO> auxiliaryList = ServicesLocator.getBrandServices().get_brand_all();
	        ArrayList<String> namesList = new ArrayList<String>();
	        for (AuxiliaryDTO aux : auxiliaryList) {
	            namesList.add(aux.getName());
	        }
	        ObservableList<String> observableList = FXCollections.observableArrayList(namesList);
	        cmboxBrandAdd.setItems(observableList);
	        
	        
			tableScenePane.setMaxHeight(382);
			carTable.setMaxHeight(286);
			

			
		}else if(event.getSource() == bttnAdd){
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);

			
			bttnAddCar.setVisible(true);
			bttnModifyCar.setVisible(false);
			
			ObservableList<String> list = FXCollections.observableArrayList("disponible", "alquilado", "en taller");
			cmboxCarStatusAdd.setItems(list);
			
			lblErrorPlate.setVisible(false);
			lblErrorEmpty.setVisible(false);
			
			
	        ArrayList<AuxiliaryDTO> auxiliaryList = ServicesLocator.getBrandServices().get_brand_all();
	        ArrayList<String> namesList = new ArrayList<String>();
	        for (AuxiliaryDTO aux : auxiliaryList) {
	            namesList.add(aux.getName());
	        }
	        ObservableList<String> observableList = FXCollections.observableArrayList(namesList);
	        cmboxBrandAdd.setItems(observableList);
	        
			
			tableScenePane.setMaxHeight(382);
			carTable.setMaxHeight(286);
			
			lblErrorPlate.setVisible(false);
			lblErrorEmpty.setVisible(false);

			
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
	
	public void insertCar(ActionEvent event) throws SQLException {
		lblErrorPlate.setVisible(false);
		lblErrorEmpty.setVisible(false);

		if(txtColorAdd.getText() != "" && txtPlateAdd.getText() != "" && cmboxBrandAdd.getValue() != "" && cmboxCarStatusAdd.getValue() != "" && cmboxModelAdd.getValue() != "" ) {
			if(val.ValidatePlate(txtPlateAdd.getText())) {
				String color = txtColorAdd.getText();
				String plate = txtPlateAdd.getText();
				int itemBrand = cmboxBrandAdd.getSelectionModel().getSelectedIndex() + 5;
				
				int itemSituation = cmboxCarStatusAdd.getSelectionModel().getSelectedIndex() + 4;
				String brand = (String)cmboxBrandAdd.getValue();
				
				int codeModel = cmboxModelAdd.getSelectionModel().getSelectedIndex();
				
				LinkedList<ModelDTO> models;
				System.out.println(brand);
				models = ServicesLocator.getModelServices().select_model_by_brand(brand);
				ArrayList<Integer> codeList = new ArrayList<Integer>();
		        for (ModelDTO modelaux : models) {
		        	codeList.add(modelaux.getId());
		        }
		        int modelSelection = codeList.get(codeModel);
		        
				
				try {
					System.out.println(itemSituation);
                    ServicesLocator.getCarServices().insert_car(plate, itemBrand, modelSelection, 0, color, itemSituation);

					txtColorAdd.setText("");
					txtPlateAdd.setText("");
					cmboxBrandAdd.setValue("");
					cmboxCarStatusAdd.setValue("");
					cmboxModelAdd.setValue("");
					


					try {
						carTableChargeData();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "El carro ha sido insertado con éxito");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}

			}else
				lblErrorPlate.setVisible(true);
		}else
			lblErrorEmpty.setVisible(true);

	}
	
	public void modifyCar(ActionEvent event) throws SQLException {
		lblErrorPlate.setVisible(false);
		lblErrorEmpty.setVisible(false);

		if(txtColorAdd.getText() != "" && txtPlateAdd.getText() != "" && cmboxBrandAdd.getValue() != "" && cmboxCarStatusAdd.getValue() != "" && cmboxModelAdd.getValue() != "" ) {
			if(val.ValidatePlate(txtPlateAdd.getText())) {
//				String color = txtColorAdd.getText();
//				String plate = txtPlateAdd.getText();
//				int itemBrand = cmboxBrandAdd.getSelectionModel().getSelectedIndex() + 4;
//				int itemSituation = cmboxCarStatusAdd.getSelectionModel().getSelectedIndex() + 4;
//				int itenModel = cmboxModelAdd.getSelectionModel().getSelectedIndex() + 1;
				String color = txtColorAdd.getText();
				String plate = txtPlateAdd.getText();
				int itemBrand = cmboxBrandAdd.getSelectionModel().getSelectedIndex() + 5;
				int itemSituation = cmboxCarStatusAdd.getSelectionModel().getSelectedIndex() + 4;
				System.out.println(cmboxCarStatusAdd.getSelectionModel().getSelectedIndex());
				String brand = (String)cmboxBrandAdd.getValue();
				
				int codeModel = cmboxModelAdd.getSelectionModel().getSelectedIndex();
				
				LinkedList<ModelDTO> models;
				System.out.println(brand);
				models = ServicesLocator.getModelServices().select_model_by_brand(brand);
				ArrayList<Integer> codeList = new ArrayList<Integer>();
		        for (ModelDTO modelaux : models) {
		        	codeList.add(modelaux.getId());
		        }
		        int modelSelection = codeList.get(codeModel);
		        
		        System.out.print(codeModel);;
				
				try {
					
//                    ServicesLocator.getCarServices().update_car(plate, itemBrand, itenModel, 0, color, itemSituation);
//
//					txtColorAdd.setText("");
//					txtPlateAdd.setText("");
//					cmboxBrandAdd.setValue("");
//					cmboxCarStatusAdd.setValue("");
//					cmboxModelAdd.setValue("");
					ServicesLocator.getCarServices().update_car(plate, itemBrand, modelSelection, km, color, itemSituation);

					txtColorAdd.setText("");
					txtPlateAdd.setText("");
					cmboxBrandAdd.setValue("");
					cmboxCarStatusAdd.setValue("");
					cmboxModelAdd.setValue("");
					


					try {
						carTableChargeData();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "El carro ha sido modificado con éxito");
				}
				catch(Exception e) {
					//JOptionPane.showMessageDialog(null, Validator.formatError(e));
					e.printStackTrace();
				}

			}
			else
				lblErrorPlate.setVisible(true);
		}else
			lblErrorEmpty.setVisible(true);
	}
	
	public void deleteCar(ActionEvent event) throws ClassNotFoundException, SQLException {
	    ObservableList<CarAux> allCarss, singleCar;
	    allCarss = carTable.getItems();
	    singleCar = carTable.getSelectionModel().getSelectedItems();

	    if (singleCar.size() == 1) {
	        CarAux deleteCar= singleCar.get(0);
	        
	        Object[] options = {"Sí", "No"};
	        int dialogResult = JOptionPane.showOptionDialog(null, "¿Estás seguro de que quieres eliminar el carro con placa " + deleteCar.getPlate() + "?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	        if(dialogResult == JOptionPane.YES_OPTION){
	            singleCar.forEach(allCarss::remove);
	            ServicesLocator.getCarServices().delete_car(deleteCar.getPlate());
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Solo se puede eliminar un carro a la vez");
	    }
	}


}

