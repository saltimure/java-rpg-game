package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RPGApp extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Scene1.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("saltimure");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}
