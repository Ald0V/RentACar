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
    
    ObservableList<String> list = FXCollections.observableArrayList("administrador", "trabajador", "visitante");

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
	
	UserDTO aux = new UserDTO(0, "dummy", "gmail.com", "postgres", "visitante");
	
	
	private void userTableChargeData() throws ClassNotFoundException, SQLException{
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
		colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
		
		bttnDelete.setDisable(true);
		bttnModify.setDisable(true);
		
		ArrayList<UserDTO> list = ServicesLocator.getUserServices().get_user_all();
		ObservableList<UserDTO> userList = FXCollections.observableArrayList();
		userList.addAll(list);
		
//		for (UserDTO user : list) {
//		    System.out.println("ID: " + user.getId());
//		    System.out.println("Username: " + user.getUsername());
//		    System.out.println("Email: " + user.getEmail());
//		    System.out.println("Password: " + user.getPassword());
//		    System.out.println("Rol: " + user.getRol());
//		    System.out.println("-------------------");
//		}

		
		usersTable.setItems(userList);
		
		usersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
	        	
	        	aux.setEmail(newValue.getEmail());
	        	aux.setId(newValue.getId());
	        	aux.setPassword(newValue.getPassword());
	        	aux.setRol(newValue.getRol());
	        	aux.setUsername(newValue.getUsername());
	        	
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
	
	public void deleteUser(ActionEvent event) throws ClassNotFoundException, SQLException {
	    ObservableList<UserDTO> allUsers, singleUsers;
	    allUsers = usersTable.getItems();
	    singleUsers = usersTable.getSelectionModel().getSelectedItems();

	    if (singleUsers.size() == 1) {
	        UserDTO deleteUser = singleUsers.get(0);
	        
	        Object[] options = {"Sí", "No"};
	        int dialogResult = JOptionPane.showOptionDialog(null, "¿Estás seguro de que quieres eliminar el usuario " + deleteUser.getUsername() + "?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	        if(dialogResult == JOptionPane.YES_OPTION){
	            singleUsers.forEach(allUsers::remove);
	            ServicesLocator.getUserServices().delete_user(deleteUser.getId());
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Solo se puede eliminar un usuario a la vez");
	    }
	}

	
    public void modifyUser(ActionEvent event) throws ClassNotFoundException, SQLException {
		lblErrorEmpty.setVisible(false);
		if(cmboxRol.getValue() != "") {
			String rol = (String) cmboxRol.getValue();
			

			ServicesLocator.getUserServices().update_user(aux.getId(), aux.getUsername(), aux.getEmail(), aux.getPassword(), rol);

			JOptionPane.showMessageDialog(null, "El usuario ha sido modificado con éxito");
			
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
