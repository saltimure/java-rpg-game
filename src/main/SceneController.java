package main;

import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void switchToScene1(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToScene2(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
