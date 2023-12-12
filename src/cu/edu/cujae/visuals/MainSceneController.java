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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainSceneController {
	
	@FXML
	private AnchorPane mainScenePane;
	
	@FXML
	private Pane mainPane;
	
	@FXML
	private Pane secondaryPane;

    @FXML
    private Button bttnGoBack;

    @FXML
    private Button bttnReports;
    
    @FXML
    private Button bttnTourists;

    @FXML
    private Button bttnCarSituation;

    @FXML
    private Button bttnModelBrand;

    @FXML
    private Button bttnCountry;
    
    @FXML
    private Button bttnImport;
    
    @FXML
    private Label lblReports;
    
    @FXML
    private Label lblMainMenu;
    
    @FXML
    private VBox mainVBox;
    
    @FXML
    private VBox secondaryVBox;
	
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
	
	@FXML
    void switchForm(ActionEvent event) {
    	
    	if(event.getSource() == bttnReports) {
    		secondaryPane.setVisible(true);
    		secondaryVBox.setVisible(true);
    		lblReports.setVisible(true);
    		mainPane.setVisible(false);
    		mainVBox.setVisible(false);
    		lblMainMenu.setVisible(false);
    	}else
    		if(event.getSource() == bttnGoBack) {
    			mainPane.setVisible(true);
    			mainVBox.setVisible(true);
    			lblMainMenu.setVisible(true);
    			secondaryPane.setVisible(false);
    			secondaryVBox.setVisible(false);
    			lblReports.setVisible(false);
    		}
    }
	
	public void openReportTourist(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneReports.fxml"));
		root = loader.load();
		
		DataTableSceneReportsController reportsController = loader.getController();
		
		reportsController.getBttnTourists().setDisable(true);

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
	
	public void openReportCar(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneReports.fxml"));
		root = loader.load();
		
		DataTableSceneReportsController reportsController = loader.getController();
		
		reportsController.getBttnCarSituation().setDisable(true);

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
	
	public void openReportModelBrand(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneReports.fxml"));
		root = loader.load();
		
		DataTableSceneReportsController reportsController = loader.getController();
		
		reportsController.getBttnModelBrand().setDisable(true);

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
	
	public void openReportCountry(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneReports.fxml"));
		root = loader.load();
		
		DataTableSceneReportsController reportsController = loader.getController();
		
		reportsController.getBttnCountry().setDisable(true);

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
	
	public void openReportImports(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataTableSceneReports.fxml"));
		root = loader.load();
		
		DataTableSceneReportsController reportsController = loader.getController();
		
		reportsController.getBttnImports().setDisable(true);

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
	
//	public void disableButton(DataTableSceneReportsController reportsController, ActionEvent event) {
//		if(event.getSource() == bttnTourists) {
//			reportsController.getBttnTourists().setDisable(true);
//		} else if(event.getSource() == bttnCarSituation) {
//			reportsController.getBttnCarSituation().setDisable(true);
//		} else if(event.getSource() == bttnModelBrand) {
//			reportsController.getBttnModelBrand().setDisable(true);
//		} else if(event.getSource() == bttnCountry) {
//			reportsController.getBttnCountry().setDisable(true);
//		} else if(event.getSource() == bttnImport) {
//			reportsController.getBttnImports().setDisable(true);
//		}
//	}
}
