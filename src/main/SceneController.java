package main;

import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label nameLabel;
	@FXML
	private TextField nameTextField;

	public void setUsername(ActionEvent e) throws IOException {
		nameLabel.setText(nameTextField.getText());
	}
	
	public void switchToScene1(ActionEvent e) throws IOException {
		loadStage("Scene1.fxml", e);
	}
	
	public void switchToScene2(ActionEvent e) throws IOException {
		loadStage("Scene2.fxml", e);
	}
	
	public void loadStage(String fxml, ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
