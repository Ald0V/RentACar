package cu.edu.cujae.visuals;

import java.io.IOException;

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
    private TableView<?> carTable;
    
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
    private TableColumn<?, ?> colAddBrand;

    @FXML
    private TableColumn<?, ?> colAddCarSituation;

    @FXML
    private TableColumn<?, ?> colAddColor;

    @FXML
    private TableColumn<?, ?> colAddKM;

    @FXML
    private TableColumn<?, ?> colAddModel;

    @FXML
    private TableColumn<?, ?> colAddPlate;

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
    private ComboBox<?> cmboxBrandAdd;

    @FXML
    private ComboBox<?> cmboxCarStatusAdd;

    @FXML
    private ComboBox<?> cmboxModelAdd;
    
    @FXML
    private TextField txtColorAdd;

    @FXML
    private TextField txtPlateAdd;
    
//********************   
//*   MODIFY PANE    *
//******************** 
    
    @FXML
    private ComboBox<?> cmboxBrandModify;

    @FXML
    private ComboBox<?> cmboxCarStatusModify;

    @FXML
    private ComboBox<?> cmboxModelModify;
    
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
			
		}else if(event.getSource() == bttnAdd){
			bttnAdd.setDisable(true);
			bttnModify.setDisable(true);
			bttnDelete.setDisable(true);
			addScenePane.setVisible(true);
			addParametersScenePane.setVisible(true);
			tableScenePane.setVisible(true);
			
			tableScenePane.setMaxHeight(382);
			carTable.setMaxHeight(286);
			
			modifyScenePane.setVisible(false);
			
		}else if(event.getSource() == bttnDelete) {
			
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
		
		
	}
	
    public void modifyCar(ActionEvent event) {
		
		
	}
}

