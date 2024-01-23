package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.dto.ModelDTO;
import cu.edu.cujae.dto.TouristDTO;
import cu.edu.cujae.services.ServicesLocator;
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
import javafx.stage.Stage;

public class DataTableSceneCBMController {

	private double x = 0;
	private double y = 0;
	
	
	@FXML
	private AnchorPane CBMPane;

	@FXML
	private AnchorPane brandPane;

	@FXML
	private TableView<String> brandTable;

	@FXML
	private Button bttnBrands;

	@FXML
	private Button bttnCountry;

	@FXML
	private Button bttnGoBack;

	@FXML
	private Button bttnModels;

	@FXML
	private ComboBox<String> cmboxBrands;

	@FXML
	private TableColumn<String, String> colBrands;

	@FXML
	private TableColumn<String, String> colCountries;

	@FXML
	private TableColumn<ModelDTO, String> colModels;

	@FXML
	private TableColumn<ModelDTO, String> colBrandsModels;

	@FXML
	private AnchorPane countryPane;

	@FXML
	private TableView<String> countryTable;

	@FXML
	private AnchorPane modelPane;

	@FXML
	private TableView<String> modelTable;

	@FXML
	private TextField txtBrand;

	@FXML
	private TextField txtCountry;

	@FXML
	private TextField txtModel;
	
    @FXML
    private Button bttnDeleteBrand;

    @FXML
    private Button bttnDeleteCountry;

    @FXML
    private Button bttnDeleteModel;
    
    @FXML
    private Button bttnUpdateBrand;

    @FXML
    private Button bttnUpdateCountry;

    @FXML
    private Button bttnUpdateModel;
    
    @FXML
    private Label lblErrorBrand;

    @FXML
    private Label lblErrorCountry;

    @FXML
    private Label lblErrorModel;


	private Stage stage;
	private Scene scene;
	private Parent root;
	
	

	public AnchorPane getBrandPane() {
		return brandPane;
	}

	public Button getBttnBrands() {
		return bttnBrands;
	}

	public Button getBttnCountry() {
		return bttnCountry;
	}

	public Button getBttnModels() {
		return bttnModels;
	}

	public AnchorPane getCountryPane() {
		return countryPane;
	}
	
	public AnchorPane getModelPane() {
		return modelPane;
	}
	
	
	@SuppressWarnings("unchecked")
	private void countryTableChargeData() throws ClassNotFoundException, SQLException {
		colCountries.setCellValueFactory(new PropertyValueFactory<>("Países"));
		
	    ArrayList<AuxiliaryDTO> list = ServicesLocator.getCountryServices().get_country_all();
	    ArrayList<String> namesList = new ArrayList<String>();
        for (AuxiliaryDTO aux : list) {
            namesList.add(aux.getName());
        }
	    ObservableList<String> countryList = FXCollections.observableArrayList();
	    countryList.addAll(namesList);
	    
	    countryTable.setItems(countryList);
	    
	    bttnDeleteCountry.setDisable(true);
        bttnUpdateCountry.setDisable(true);
        
        countryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
                // Activa los botones cuando se selecciona una fila
	        	bttnDeleteCountry.setDisable(false);
	        	bttnUpdateCountry.setDisable(false);
                
                // Carga los datos
                txtCountry.setText(newValue);

                
	        }else {
                // Desactiva los botones cuando no hay ninguna fila seleccionada
	    	    bttnDeleteCountry.setDisable(true);
	            bttnUpdateCountry.setDisable(true);

            }
	    });      
	}
	
	@SuppressWarnings("unchecked")
	private void brandTableChargeData() throws ClassNotFoundException, SQLException {
		colBrands.setCellValueFactory(new PropertyValueFactory<>("Marcas"));
		
		ArrayList<AuxiliaryDTO> list = ServicesLocator.getBrandServices().get_brand_all();
	    ArrayList<String> namesList = new ArrayList<String>();
        for (AuxiliaryDTO aux : list) {
            namesList.add(aux.getName());
        }
	    ObservableList<String> brandList = FXCollections.observableArrayList();
	    brandList.addAll(namesList);
	    
	    brandTable.setItems(brandList);
	    
	    bttnDeleteBrand.setDisable(true);
        bttnUpdateBrand.setDisable(true);
        
        brandTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
                // Activa los botones cuando se selecciona una fila
	        	bttnDeleteBrand.setDisable(false);
	            bttnUpdateBrand.setDisable(false);
                
                // Carga los datos
                txtBrand.setText(newValue);
                
	        }else {
                // Desactiva los botones cuando no hay ninguna fila seleccionada
	        	bttnDeleteBrand.setDisable(true);
	            bttnUpdateBrand.setDisable(true);

            }
	    });      
	}
	
	@SuppressWarnings("unchecked")
	private void modelTableChargeData() throws ClassNotFoundException, SQLException {
		colModels.setCellValueFactory(new PropertyValueFactory<>("Modelos"));
		
		ArrayList<ModelDTO> list = ServicesLocator.getModelServices().get_model_all();
	    ArrayList<String> namesList = new ArrayList<String>();
        for (ModelDTO aux : list) {
            namesList.add(aux.getName());
        }
	    ObservableList<String> modelList = FXCollections.observableArrayList();
	    modelList.addAll(namesList);
	    
		modelTable.setItems(modelList);
		
		ArrayList<AuxiliaryDTO> list2 = ServicesLocator.getBrandServices().get_brand_all();
	    ArrayList<String> namesList2 = new ArrayList<String>();
        for (AuxiliaryDTO aux : list2) {
            namesList2.add(aux.getName());
        }
	    ObservableList<String> brandList = FXCollections.observableArrayList();
	    cmboxBrands.setItems(brandList);
	    
	    bttnDeleteModel.setDisable(true);
        bttnUpdateModel.setDisable(true);
        
        modelTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
                // Activa los botones cuando se selecciona una fila
	        	bttnDeleteModel.setDisable(false);
	        	bttnUpdateModel.setDisable(false);
                
                // Carga los datos
                txtBrand.setText(newValue);
                
	        }else {
                // Desactiva los botones cuando no hay ninguna fila seleccionada
	    	    bttnDeleteModel.setDisable(true);
	            bttnUpdateModel.setDisable(true);

            }
	    });      
		
	}



	public void initializeCountryTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        countryTableChargeData();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void initializeBrandTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        brandTableChargeData();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void initializeModelTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        modelTableChargeData();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }		
	}
	
	public void insertCountry(ActionEvent event) throws ClassNotFoundException, SQLException{
		lblErrorCountry.setVisible(false);
		if(txtCountry.getText() != "") {
			String name = txtCountry.getText();
			ServicesLocator.getCountryServices().insert_country(name);
			txtCountry.setText("");
			try {
				countryTableChargeData();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else
			lblErrorCountry.setVisible(true);
	}
	
	public void insertBrand(ActionEvent event) throws ClassNotFoundException, SQLException{
		lblErrorBrand.setVisible(false);
		if(txtBrand.getText() != "") {
			String name = txtBrand.getText();
			ServicesLocator.getBrandServices().insert_brand(name);
			txtBrand.setText("");
			try {
				brandTableChargeData();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else
			lblErrorBrand.setVisible(true);
	}
	
	public void insertModel(ActionEvent event) throws ClassNotFoundException, SQLException{
		lblErrorModel.setVisible(false);
		if(cmboxBrands.getValue() != "" && txtModel.getText() != "") {
			int brand = cmboxBrands.getSelectionModel().getSelectedIndex() + 1;
			String model = txtModel.getText();
			ServicesLocator.getModelServices().insert_model(brand, model);
			cmboxBrands.setValue("");
			txtModel.setText("");
			try {
				modelTableChargeData();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else
			lblErrorModel.setVisible(true);
	}
	
	public void updateCountry(ActionEvent event) throws ClassNotFoundException, SQLException{
		lblErrorCountry.setVisible(false);
		if(txtCountry.getText() != "") {
			String name = txtCountry.getText();
//			ServicesLocator.getCountryServices().update_country(name);
			txtCountry.setText("");
			try {
				countryTableChargeData();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else
			lblErrorCountry.setVisible(true);
	}
	
	public void updateBrand(ActionEvent event) throws ClassNotFoundException, SQLException{
		lblErrorBrand.setVisible(false);
		if(txtBrand.getText() != "") {
			String name = txtBrand.getText();
//			ServicesLocator.getBrandServices().update_brand(name);
			txtBrand.setText("");
			try {
				brandTableChargeData();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else
			lblErrorBrand.setVisible(true);
	}
	
	public void updateModel(ActionEvent event) throws ClassNotFoundException, SQLException{
		lblErrorModel.setVisible(false);
		if(cmboxBrands.getValue() != "" && txtModel.getText() != "") {
			int brand = cmboxBrands.getSelectionModel().getSelectedIndex() + 1;
			String model = txtModel.getText();
//			ServicesLocator.getModelServices().update_model(brand, model);
			cmboxBrands.setValue("");
			txtModel.setText("");
			try {
				modelTableChargeData();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else
			lblErrorModel.setVisible(true);
	}
	
	public void deleteCountry(ActionEvent event) throws ClassNotFoundException, SQLException{
		
	}
	
	public void deleteBrand(ActionEvent event) throws ClassNotFoundException, SQLException{
		
	}
	
	public void deleteModel(ActionEvent event) throws ClassNotFoundException, SQLException{
		
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
		stage = (Stage)CBMPane.getScene().getWindow(); 
		stage.close();
	}
	
    @FXML
    void switchForm(ActionEvent event) {
    	
    	if(event.getSource() == bttnCountry) {
    		
    		countryPane.setVisible(true);
    		bttnCountry.setDisable(true);
    		bttnBrands.setDisable(false);
    		bttnModels.setDisable(false);
    		
    		brandPane.setVisible(false);
    		modelPane.setVisible(false);
    		
    		initializeCountryTable();
    		
    	}else if(event.getSource() == bttnBrands) {
    		
    		brandPane.setVisible(true);
    		bttnBrands.setDisable(true);
    		bttnCountry.setDisable(false);
    		bttnModels.setDisable(false);
    		
    		modelPane.setVisible(false);
    		countryPane.setVisible(false);
    		
    		initializeBrandTable();
    		
    	}else if(event.getSource() == bttnModels) {
    		
    		modelPane.setVisible(true);
    		bttnModels.setDisable(true);
    		bttnBrands.setDisable(false);
    		bttnCountry.setDisable(false);
    		
    		countryPane.setVisible(true);
    		brandPane.setVisible(false);  
    		
    		initializeModelTable();
    	}

    }
}
