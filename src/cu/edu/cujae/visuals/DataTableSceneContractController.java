package cu.edu.cujae.visuals;

import java.io.IOException;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	private AnchorPane modifyScenePane;
	
    @FXML
    private AnchorPane tableScenePane;
    
    @FXML
    private AnchorPane addParametersScenePane;

    @FXML
    private AnchorPane addNewTourist;
    
    @FXML
    private AnchorPane addNewCar;
    
    @FXML
    private Button bttnAddNewTourist;
    
    @FXML
    private Button bttnAddNewCar;
    
    @FXML
    private Button bttnModifyNewTourist;
    
    @FXML
    private Button bttnModifyNewCar;
    
    @FXML
    private TableView<?> contractTable;
	
    @FXML
    private Label lblName;
    
    @FXML
    private Label lblErrorEmpty;

    @FXML
    private Label lblErrorEmpty1;
    
    @FXML
    private Label lblErrorEmptyTourist;
    
    @FXML
    private Label lblErrorEmptyCar;
    
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
    private Button bttnDelete;
    
    @FXML
    private Button bttnAddNewCountry;
    
//*****************    
//*   ADD PANE    *
//*****************  
    
    @FXML
    private ComboBox<?> cmboxCarAdd;

    @FXML
    private ComboBox<?> cmboxPayMethodAdd;

    @FXML
    private ComboBox<?> cmboxTouristAdd;
    
    @FXML
    private DatePicker pickdateStartAdd;
    
    @FXML
    private TextField txtTotalImportAdd;
    
    @FXML
    private CheckBox checkDriverRentalAdd;
    
//0ºººººººººººººººº0    
//0   ADD TABLE    0
//0ºººººººººººººººº0 
      
//0ººººººººººººººººººº0  
//0   MODIFY TABLE    0
//0ººººººººººººººººººº0
    
//********************   
//*   MODIFY PANE    *
//******************** 
    
    @FXML
    private ComboBox<?> cmboxCarModify;

    @FXML
    private ComboBox<?> cmboxPayMethodModify;

    @FXML
    private ComboBox<?> cmboxTouristModify;
    
    @FXML
    private DatePicker pickdateStartModify;
    
    @FXML
    private TextField txtTotalImportModify;
    
    @FXML
    private CheckBox checkDriverRentalModify;
    
//*************************    
//*   TOURIST ADD PANE    *
//*************************  
    
    @FXML
    private ComboBox<?> cmboxCountryAdd;

    @FXML
    private ComboBox<?> cmboxSexAdd;
    
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
    private ComboBox<?> cmboxBrandAdd;

    @FXML
    private ComboBox<?> cmboxCarStatusAdd;

    @FXML
    private ComboBox<?> cmboxModelAdd;
    
    @FXML
    private TextField txtColorAdd;

    @FXML
    private TextField txtPlateAdd;
    
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
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
		}else if(event.getSource() == bttnAdd){
			
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			tableScenePane.setMaxHeight(382);
			contractTable.setMaxHeight(286);
			
			modifyScenePane.setVisible(false);
		}			
	}
	
	public void switchNewTouristOrCar(ActionEvent event) {
		
		if(event.getSource() == bttnAddNewTourist) {
			addNewTourist.setVisible(true);
		}else if(event.getSource() == bttnAddNewCar) {
			addNewCar.setVisible(true);
		}else if(event.getSource() == bttnModifyNewTourist) {
			addNewTourist.setVisible(true);
			bttnModifyNewTourist.setDisable(true);
			bttnModifyNewCar.setDisable(true);
		}else if(event.getSource() == bttnModifyNewCar) {
			addNewCar.setVisible(true);
			bttnModifyNewTourist.setDisable(true);
			bttnModifyNewCar.setDisable(true);
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
		contractTable.setMaxHeight(554);
	}
	
	public void cancelNewTourist(ActionEvent event) {
		addNewTourist.setVisible(false);
		bttnModifyNewTourist.setDisable(false);
		bttnModifyNewCar.setDisable(false);
		
		cmboxCountryAdd.setVisible(true);
		imgCountryAdd.setVisible(true);
		bttnAddNewCountry.setDisable(false);
		txtCountryAdd.setVisible(false);
	}
	
	public void cancelNewCar(ActionEvent event) {
		addNewCar.setVisible(false);
		bttnModifyNewTourist.setDisable(false);
		bttnModifyNewCar.setDisable(false);
	}
	
//	public void cancelModifyNewTourist(ActionEvent event) {
//		addNewTourist.setVisible(false);
//		bttnModifyNewTourist.setDisable(false);
//		bttnModifyNewCar.setDisable(false);
//	}
//	
//	public void cancelModifyNewCar(ActionEvent event) {
//		addNewCar.setVisible(false);
//		bttnModifyNewTourist.setDisable(false);
//		bttnModifyNewCar.setDisable(false);
//	} 
	
	public void newTouristAdd(ActionEvent event) {
				
		txtCountryAdd.setVisible(true);
		bttnAddNewCountry.setDisable(true);
		cmboxCountryAdd.setVisible(false);
		imgCountryAdd.setVisible(false);

	}

}
