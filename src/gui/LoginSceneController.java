package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginSceneController {
	
	public static final String USERNAME = "Admin";
	public static final String PASSWORD = "123456";
	
	private double x = 0;
	private double y = 0;
	
	@FXML
	private AnchorPane loginScenePane;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField txtUsername;
    
	@FXML
    private PasswordField pfPassword;
    
    @FXML
    private Label lblUserError;  
    
    @FXML
    private Label lblPasswordError;
    
    private String errorMessage = "";


	
	public void login(ActionEvent event) throws IOException {
		
		errorMessage = "";
		
		/*Lo de abajo es temporal para acceder a lo visual mas rapido*/
		txtUsername.setText(USERNAME);
		pfPassword.setText(PASSWORD);
		/*Lo de arriba es temporal para acceder a lo visual mas rapido*/

		if(isFieldFilled() && isValid()) {
			((Node) event.getSource()).getScene().getWindow().hide();


			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			root = loader.load();		

			
			//		root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Stage stageMain = new Stage();
			

			scene = new Scene(root);
			
			root.setOnMousePressed((MouseEvent e) ->{
				x = e.getSceneX();
				y = e.getSceneY();
			});
			
			root.setOnMouseDragged((MouseEvent e) ->{
				stageMain.setX(e.getScreenX() - x);
				stageMain.setY(e.getScreenY() - y);
				
				stageMain.setOpacity(.9);
			});
			
			root.setOnMouseReleased((MouseEvent e) ->{
				stageMain.setOpacity(1);
			});
			
			stageMain.setScene(scene);
			stageMain.initStyle(StageStyle.UNDECORATED);
			stageMain.setResizable(false);
			stageMain.show();
		}
	}
	
	public void logout(MouseEvent event) {
		stage = (Stage)loginScenePane.getScene().getWindow(); 
		stage.close();
	}
	
	private boolean isFieldFilled() {
		boolean isFilled = true;
		if(txtUsername.getText().isEmpty()) {
			isFilled = false;
			errorMessage = "El nombre de usuario est\u00e1 vac\u00edo";
		}

		
		if(pfPassword.getText().isEmpty()) {
			isFilled = false;
			if(errorMessage.isEmpty()) {
				errorMessage = "La contrase\u00f1a est\u00e1 vac\u00eda";
			}else {
				errorMessage += "\nLa contrase\u00f1a est\u00e1 vac\u00eda";
			}
		}
		

		
		lblUserError.setText(errorMessage);
		
		return isFilled;	
	}
	
	private boolean isValid() {
		boolean valid = true;
		String username = txtUsername.getText();
		String password = pfPassword.getText();
		
		if(!username.equals(USERNAME)) {
			valid = false;
			errorMessage = "El nombre de usuario es incorrecto";
		}
		
		if(!password.equals(PASSWORD)) {
			valid = false;
			if(errorMessage.isEmpty()) {
			errorMessage = "La contrase\u00f1a es incorrecta";
			}else {
				errorMessage += "\nLa contrase\u00f1a es incorrecta";
			}
		}
		
		lblUserError.setText(errorMessage);
		
		return valid;
	}
}
