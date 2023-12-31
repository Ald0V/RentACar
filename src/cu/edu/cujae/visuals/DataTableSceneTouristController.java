package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.AuxiliaryDTO;
import cu.edu.cujae.utils.TouristAux;

import cu.edu.cujae.dto.TouristDTO;

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
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;

public class DataTableSceneTouristController {
	
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
    private TextField search;
    
    @FXML
    private TableView<TouristAux> touristTable;
	
    @FXML
    private Label lblName;

    @FXML
    private Label lblErrorAge;

    @FXML
    private Label lblErrorEmpty;

    @FXML
    private Label lblErrorPassport;

    @FXML
    private Label lblErrorPhone;
    
    @FXML
    private Button bttnAdd;

    @FXML
    private Button bttnBack;
    
    @FXML
    private Button bttnBack1;

    @FXML
    private Button bttnDelete;

    @FXML
    private Button bttnModify;
    
    @FXML
    private Button bttnAddNewCountry;
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
    
//0ºººººººººººººººº0    
//0   ADD TABLE    0
//0ºººººººººººººººº0 
    
    
    
    @FXML
    private TableColumn<TouristDTO, Integer> colAddAge;

    @FXML
    private TableColumn<TouristDTO, String> colAddCountry;

    @FXML
    private TableColumn<TouristDTO, String> colAddLastName1;

    @FXML
    private TableColumn<TouristDTO, String> colAddLastName2;

    @FXML
    private TableColumn<TouristDTO, String> colAddName;

    @FXML
    private TableColumn<TouristDTO, String> colAddPassport;

    @FXML
    private TableColumn<TouristDTO, String> colAddSex;
    
    @FXML
    private TableColumn<TouristDTO, String> colAddPhone;
  
//*****************    
//*   ADD PANE    *
//*****************    
    
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
    
    @FXML
    private Button bttnAddTourist;
    
    @FXML
    private Button bttnModifyTourist;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@SuppressWarnings("unchecked")
	private void touristTableChargeData() throws ClassNotFoundException, SQLException {	
	    // Configurar cellValueFactory para cada columna
		colAddAge.setCellValueFactory(new PropertyValueFactory<>("Edad"));
	    colAddCountry.setCellValueFactory(new PropertyValueFactory<>("País"));
	    colAddLastName1.setCellValueFactory(new PropertyValueFactory<>("Primer apellido"));
	    colAddLastName2.setCellValueFactory(new PropertyValueFactory<>("Segundo apellido"));
	    colAddName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
	    colAddPassport.setCellValueFactory(new PropertyValueFactory<>("Pasaporte"));
	    colAddSex.setCellValueFactory(new PropertyValueFactory<>("RentalTotalValue"));
	    colAddPhone.setCellValueFactory(new PropertyValueFactory<>("RentalTotalValue"));

	    // Obtener la lista de turistas
//	    ArrayList<TouristDTO> list = ServiceLocator.getInstance().getTourists();		
//	    ObservableList<TouristDTO> touristList = FXCollections.observableArrayList();
//	    touristList.addAll(list);
//	    
//	    // Establecer los elementos de la tabla
//	    touristTable.setItems(touristList);

	    
	    
	    // Añadir un listener a la propiedad selectedItemProperty
	    touristTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
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
	
	public void initializeTouristTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        touristTableChargeData();
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
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
	        ObservableList<String> list = FXCollections.observableArrayList("Hombre", "Mujer");
	        cmboxSexAdd.setItems(list);
	        
	        bttnAddTourist.setVisible(false);
			bttnModifyTourist.setVisible(true);
	        
			tableScenePane.setMaxHeight(382);
			touristTable.setMaxHeight(286);
			
		}else if(event.getSource() == bttnAdd){
			
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			bttnAddTourist.setVisible(true);
			bttnModifyTourist.setVisible(false);
			
	        ObservableList<String> list = FXCollections.observableArrayList("Hombre", "Mujer");
	        cmboxSexAdd.setItems(list);
			
			tableScenePane.setMaxHeight(382);
			touristTable.setMaxHeight(286);
				
		}
		
	}
	
	public void cancelModify(ActionEvent event) {
		addScenePane.setVisible(true);
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		bttnModify.setDisable(false);
		bttnDelete.setDisable(false);
		
		cmboxCountryAdd.setVisible(true);
		imgCountryAdd.setVisible(true);
		bttnAddNewCountry.setDisable(false);
		txtCountryAdd.setVisible(false);
		
		tableScenePane.setMaxHeight(626);
		touristTable.setMaxHeight(554);
	}
	
	public void cancelAdd(ActionEvent event) {
		addScenePane.setVisible(true);
		addParametersScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		bttnModify.setDisable(false);
		bttnDelete.setDisable(false);
		
		cmboxCountryAdd.setVisible(true);
		imgCountryAdd.setVisible(true);
		bttnAddNewCountry.setDisable(false);
		txtCountryAdd.setVisible(false);
		
		tableScenePane.setMaxHeight(626);
		touristTable.setMaxHeight(554);
	}
	
	public void newTouristModorAdd(ActionEvent event) {
		
		if(event.getSource() == bttnAddNewCountry) {
			
			txtCountryAdd.setVisible(true);
			bttnAddNewCountry.setDisable(true);
			cmboxCountryAdd.setVisible(false);
			imgCountryAdd.setVisible(false);
			
		}
	}
	
	public static boolean isAgeCorrect(int edad) {
		return edad >= 18 && edad <= 60;
	}
	
    public static boolean isPassportCorrect(String str) {
        return str.matches("\\d{11}");
    }
	
    public static boolean isPhoneCorrect(String str) {
        return str.matches("[\\d+\\-\\)\\(]{1,15}");
    }
	
	public void insertTourist(ActionEvent event) throws ClassNotFoundException, SQLException {
		
		if(txtAgeAdd.getText() != "" && txtLastName1Add.getText() != "" && txtLastName2Add.getText() != "" && txtNameAdd.getText() != "" && txtPassportAdd.getText() != "" && txtPhoneAdd.getText() != "" && cmboxCountryAdd.getValue() != "" && cmboxSexAdd.getValue() != "") { 
			if(isAgeCorrect(Integer.parseInt(txtAgeAdd.getText())) ) {
				if(isPassportCorrect(txtPassportAdd.getText()) && isPhoneCorrect(txtPhoneAdd.getText())) {

					String name = txtNameAdd.getText();
					String lastName1 = txtLastName1Add.getText();
					String lastName2 = txtLastName2Add.getText();
					String passport = txtPassportAdd.getText();
					String sex = (String) cmboxSexAdd.getValue();
					String contact = txtPhoneAdd.getText();
					String country = (String) cmboxCountryAdd.getValue();
					int age = Integer.parseInt(txtAgeAdd.getText());

					try {
						AuxiliaryDTO aux = new AuxiliaryDTO(-1, country);
						TouristDTO tourist = new TouristDTO(passport, name, lastName1, lastName2, age, sex, contact, aux);
						
//						serviceLocator.insertTourist(tourist);

						txtNameAdd.setText("");
						txtLastName1Add.setText("");
						txtLastName2Add.setText("");
						txtPassportAdd.setText("");
						cmboxSexAdd.setValue("");
						txtPhoneAdd.setText("");
						cmboxCountryAdd.setValue("");
						txtAgeAdd.setText("");

						try {
							touristTableChargeData();
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}else if(isPassportCorrect(txtPassportAdd.getText()) != false) {
					lblErrorPassport.setVisible(true);
				}else
					lblErrorPhone.setVisible(true);		
			}else
				lblErrorAge.setVisible(true);			
		}else
			lblErrorEmpty.setVisible(true);
		
	}
	
    public void modifyTourist(ActionEvent event)throws ClassNotFoundException, SQLException {
		
    	if(txtAgeAdd.getText() != "" && txtLastName1Add.getText() != "" && txtLastName2Add.getText() != "" && txtNameAdd.getText() != "" && txtPassportAdd.getText() != "" && txtPhoneAdd.getText() != "" && cmboxCountryAdd.getValue() != "" && cmboxSexAdd.getValue() != "") { 
			if(isAgeCorrect(Integer.parseInt(txtAgeAdd.getText())) ) {
				if(isPassportCorrect(txtPassportAdd.getText()) && isPhoneCorrect(txtPhoneAdd.getText())) {

					String name = txtNameAdd.getText();
					String lastName1 = txtLastName1Add.getText();
					String lastName2 = txtLastName2Add.getText();
					String passport = txtPassportAdd.getText();
					String sex = (String) cmboxSexAdd.getValue();
					String contact = txtPhoneAdd.getText();
					String country = (String) cmboxCountryAdd.getValue();
					int age = Integer.parseInt(txtAgeAdd.getText());

					try {
						AuxiliaryDTO aux = new AuxiliaryDTO(-1 ,country);
						TouristDTO tourist = new TouristDTO(passport, name, lastName1, lastName2, age, sex, contact, aux);
						
//						serviceLocator.updateTourist(tourist);

						txtNameAdd.setText("");
						txtLastName1Add.setText("");
						txtLastName2Add.setText("");
						txtPassportAdd.setText("");
						cmboxSexAdd.setValue("");
						txtPhoneAdd.setText("");
						cmboxCountryAdd.setValue("");
						txtAgeAdd.setText("");

						try {
							touristTableChargeData();
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}else if(isPassportCorrect(txtPassportAdd.getText()) != false) {
					lblErrorPassport.setVisible(true);
				}else
					lblErrorPhone.setVisible(true);		
			}else
				lblErrorAge.setVisible(true);			
		}else
			lblErrorEmpty.setVisible(true);
	}
    
    public void deleteTourist(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<TouristAux> allTourists, singleTourist;
        allTourists = touristTable.getItems();
        singleTourist = touristTable.getSelectionModel().getSelectedItems();

        if (singleTourist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero se debe seleccionar un item");
        } else {
            singleTourist.forEach(allTourists::remove);
        }
    }

    
}
