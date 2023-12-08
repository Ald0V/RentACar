package cu.edu.cujae.visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainSceneController {
	
	@FXML
	private AnchorPane mainScenePane;
	
	private double x = 0;
	private double y = 0;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void logout(ActionEvent event) {
		
		stage = (Stage)mainScenePane.getScene().getWindow(); 
		stage.close();
	}
	
	public void openTourist(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneTourist.fxml"));
		root = loader.load();
		
		DataTableSceneTouristController dataTableSceneController = loader.getController();
		dataTableSceneController.displayName("Turistas");
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
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
		
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public void openCars(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneCar.fxml"));
		root = loader.load();
		
		DataTableSceneCarController dataTableSceneController = loader.getController();
		dataTableSceneController.displayName("Carros");
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
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
		
		stage.setScene(scene);
		stage.centerOnScreen();
	}
	
	public void openContracts(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneContract.fxml"));
		root = loader.load();
		
		DataTableSceneContractController dataTableSceneController = loader.getController();
		dataTableSceneController.displayName("Contratos");
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
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
		
		stage.setScene(scene);
		stage.centerOnScreen();
	}
	
	public void openChofers(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneDriver.fxml"));
		root = loader.load();
		
		DataTableSceneDriverController dataTableSceneController = loader.getController();
		dataTableSceneController.displayName("Chofers");
				
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
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
		
		stage.setScene(scene);
		stage.centerOnScreen();
	}
}
