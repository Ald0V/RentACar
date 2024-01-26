package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.UserDTO;
import cu.edu.cujae.services.ServicesLocator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private AnchorPane AnchorPaneData;
    
    @FXML
    private AnchorPane AnchorPaneData1;
	
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtUsername1;
    
    @FXML
    private PasswordField pfCheckPassword1;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private PasswordField pfPassword1;
    
    @FXML
    private Label lblUserError;  
    
    @FXML
    private Label lblUserError1;
    
    @FXML
    private Label lblPasswordError;
    
    @FXML
    private Label lblNewAcount;
    
    @FXML
    private Pane switchLoginPane;
    
    @FXML
    private Pane switchLoginPane1;
    
    @FXML
    private Label lblSwitchNewAccount;
    
    @FXML
    private Label lblSwitchSignIn;

    @FXML
    private Label lblSignIn;
    
    private String errorMessage = "";
    
    UserDTO aux = new UserDTO(0, "dummy", "gmail.com", "postgres", "visitante");


	
	public void login(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		
		errorMessage = "";
		
		/*Lo de abajo es temporal para acceder a lo visual mas rapido*/
//		txtUsername.setText(USERNAME);
//		pfPassword.setText(PASSWORD);
		/*Lo de arriba es temporal para acceder a lo visual mas rapido*/

		if(isFieldFilled() && isValid()) {
			((Node) event.getSource()).getScene().getWindow().hide();


			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			root = loader.load();		

			
			//		root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Stage stageMain = new Stage();
			
			MainSceneController mainSceneController = loader.getController();
			mainSceneController.initializeAdminORWorkerORVisitor(aux.getRol());

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
			
			Image image = new Image("/resources/Rental_car_login.png");
		    
			stageMain.getIcons().add(image);
			
			stageMain.setScene(scene);
			stageMain.centerOnScreen();
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
	
	private boolean isValid() throws ClassNotFoundException, SQLException {
	    boolean valid = false;
	    String errorMessage = "";
	    String username = txtUsername.getText();
	    String password = pfPassword.getText();

	    ArrayList<UserDTO> users = ServicesLocator.getUserServices().get_user_all();

	    for (UserDTO user : users) {
	        if (user.getUsername().equals(username)) {
	            if (user.getPassword().equals(password)) {
	                valid = true;
	                aux.setRol(user.getRol());
	                break;
	            } else {
	                errorMessage = "La contrase\u00f1a es incorrecta";
	                break;
	            }
	        }
	    }

	    if (!valid && errorMessage.isEmpty()) {
	        errorMessage = "El usuario introducido no existe";
	    }

	    lblUserError.setText(errorMessage);

	    return valid;
	}

	
	@FXML
    void switchForm(MouseEvent event) {
    	
    	if(event.getSource() == lblSwitchNewAccount) {
    		lblNewAcount.setVisible(true);
    		switchLoginPane1.setVisible(true);
    		AnchorPaneData1.setVisible(true);
    		lblSignIn.setVisible(false);
    		switchLoginPane.setVisible(false);
    		AnchorPaneData.setVisible(false);		
    	}else
    		if(event.getSource() == lblSwitchSignIn) {
        		lblSignIn.setVisible(true);
        		switchLoginPane.setVisible(true);
        		AnchorPaneData.setVisible(true);
        		lblNewAcount.setVisible(false);
        		switchLoginPane1.setVisible(false);
        		AnchorPaneData1.setVisible(false);
    		}

    }
}
