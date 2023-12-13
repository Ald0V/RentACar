package cu.edu.cujae.visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
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
	private AnchorPane modifyScenePane;
	
    @FXML
    private AnchorPane tableScenePane;
    
    @FXML
    private AnchorPane addParametersScenePane;
    
    @FXML
    private TableView<?> touristTable;
	
    @FXML
    private Label lblName;
    
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
    private Button bttnModifyNewCountry;
    
    @FXML
    private VBox notVisitorVBox;
    
    @FXML
    private VBox visitorVBox;
    
//*****************    
//*   ADD PANE    *
//*****************    
    
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

//********************   
//*   MODIFY PANE    *
//******************** 
    
    @FXML
    private ComboBox<?> cmboxCountryModify;

    @FXML
    private ComboBox<?> cmboxSexModify;
    
    @FXML
    private TextField txtAgeModify;

    @FXML
    private TextField txtCountryModify;

    @FXML
    private TextField txtLastName1Modify;

    @FXML
    private TextField txtLastName2Modify;

    @FXML
    private TextField txtNameModify;

    @FXML
    private TextField txtPassportModify;

    @FXML
    private TextField txtPhoneModify;
    
    @FXML
    private ImageView imgCountryModify;
    
	
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
			touristTable.setMaxHeight(286);
			
			modifyScenePane.setVisible(false);
		}	
		
	}
	
	public void cancelModify(ActionEvent event) {
		addScenePane.setVisible(true);
		modifyScenePane.setVisible(false);
		bttnAdd.setDisable(false);
		bttnModify.setDisable(false);
		bttnDelete.setDisable(false);
		
		cmboxCountryModify.setVisible(true);
		imgCountryModify.setVisible(true);
		bttnModifyNewCountry.setDisable(false);
		txtCountryModify.setVisible(false);
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
			
		}else if(event.getSource() == bttnModifyNewCountry) {
			
			txtCountryModify.setVisible(true);
			bttnModifyNewCountry.setDisable(true);
			cmboxCountryModify.setVisible(false);
			imgCountryModify.setVisible(false);
		}
	}
}
