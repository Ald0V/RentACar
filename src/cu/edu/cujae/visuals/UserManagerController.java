package cu.edu.cujae.visuals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cu.edu.cujae.dto.UserDTO;
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

public class UserManagerController {
	
	private double x = 0;
	private double y = 0;
	
    @FXML
    private Button bttnDelete;

    @FXML
    private Button bttnModify;

    @FXML
    private ComboBox<String> cmboxRol;
    
    ObservableList<String> list = FXCollections.observableArrayList("Administrador", "Trabajador", "Visitante");

    @FXML
    private AnchorPane mainScenePane;

    @FXML
    private TableView<UserDTO> usersTable;
    
    @FXML
    private TextField search;
    
    @FXML
    private Label lblErrorEmpty;
    
//0ººººººººººººººººº0    
//0   USER TABLE    0
//0ººººººººººººººººº0 
    
    @FXML
    private TableColumn<UserDTO, String> colRol;

    @FXML
    private TableColumn<UserDTO, String> colEmail;

    @FXML
    private TableColumn<UserDTO, String> colUsername;
    

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	private void userTableChargeData() throws ClassNotFoundException, SQLException{
		colEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
		colRol.setCellValueFactory(new PropertyValueFactory<>("Rol"));
		colUsername.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
		
		bttnDelete.setDisable(true);
		bttnModify.setDisable(true);
		
		ArrayList<UserDTO> list = ServicesLocator.getUserServices().get_user_all();
		ObservableList<UserDTO> userList = FXCollections.observableArrayList();
		userList.addAll(list);
		
		usersTable.setItems(userList);
		
		usersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
	        	
	    		bttnDelete.setDisable(false);
	    		bttnModify.setDisable(false);
	    		
	    		cmboxRol.setValue(newValue.getRol());
	        	
	        } else {
	    		bttnDelete.setDisable(true);
	    		bttnModify.setDisable(true);
	        }
	    });
	}
	
	public void initializeUserTable() {
		try {
	        // Llama al método touristTableChargeData() aquí
	        userTableChargeData();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public ComboBox<String> getCmboxRol() {
		return cmboxRol;
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
		stage = (Stage)mainScenePane.getScene().getWindow(); 
		stage.close();
	}
	
	public void deleteUser(ActionEvent event) {
		ObservableList<UserDTO> allUsers, singleUsers;
		allUsers = usersTable.getItems();
		singleUsers = usersTable.getSelectionModel().getSelectedItems();


		if (singleUsers.size() == 1) {
			singleUsers.forEach(allUsers::remove);
			UserDTO deleteUsers= singleUsers.get(0);
//			ServicesLocator.getUserServices().delete_users(deleteUsers.getId());
		} else {
			JOptionPane.showMessageDialog(null, "Solo se puede eliminar un país a la vez");
		}
		
	}
	
    public void modifyUser(ActionEvent event) throws ClassNotFoundException, SQLException {
		lblErrorEmpty.setVisible(false);
		if(cmboxRol.getValue() != "") {
			String rol = (String) cmboxRol.getValue();
			
//			Esto va a ser cambiado por Brenda
			ServicesLocator.getUserServices().update_user(rol, rol, rol, rol);
//			Esto va a ser cambiado por Brenda
			
			cmboxRol.setValue("");
			try {
				userTableChargeData();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else
			lblErrorEmpty.setVisible(true);
		
	}
}
