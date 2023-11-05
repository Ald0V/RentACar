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
import javafx.scene.input.MouseEvent;

public class LoginSceneController {
	
	@FXML
	private AnchorPane loginScenePane;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void login(ActionEvent event) throws IOException {
		
		((Node) event.getSource()).getScene().getWindow().hide();
			
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
		root = loader.load();		
		
//		root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Stage stageMain = new Stage();

		scene = new Scene(root);
		stageMain.setScene(scene);
		stageMain.initStyle(StageStyle.DECORATED);
		stageMain.setResizable(false);
		stageMain.show();
	}
	
	public void logout(MouseEvent event) {
		stage = (Stage)loginScenePane.getScene().getWindow(); 
		stage.close();
	}

}
