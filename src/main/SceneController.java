package main;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private User user = new User();
	private int difficulty = 1;
	private String consoleInfo = "";
	private ArrayList<Image> imgArList = new ArrayList<Image>();
	private String[] itemPool = {"Sword", "Axe"};
	
	@FXML
	private TextArea textArea;
	@FXML
	private TextArea inventoryTextArea;
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView gallery;
	
	public void fightResult(ActionEvent e) {
		if (user.fight(user, new Enemy(difficulty)) == "Player won") {
			consoleInfo += "\n" + "Player won";
		} else {
			consoleInfo += "\n" + "Enemy won" + "\n" + "You died.";
			user = new User();
		}
		textArea.setText(consoleInfo);
		if ((int)(Math.random() * 10 + 1) == 1) {
			int itemPower = (int)(Math.random() * 10 + 1);
			user.addItem(itemPool[0] + " +" + itemPower);
			consoleInfo += "\n" + "You found Sword +" + itemPower;
			textArea.setText(consoleInfo);
			inventoryTextArea.setText(user.showInventory());
		}
	}
	
	public void restart(ActionEvent e) {
		user = new User();
		consoleInfo += "\n" + "You restared the game";
		textArea.setText(consoleInfo);
	}
	
	public void plusDifficulty(ActionEvent e) {
		difficulty++;
		consoleInfo += "\n" + "Difficulty: " + difficulty + "\n"
						+ "Maximun enemy health and attack is " + difficulty * 10;
		textArea.setText(consoleInfo);
	}
	
	public void minusDifficulty(ActionEvent e) {
		difficulty--;
		consoleInfo += "\n" + "Difficulty: " + difficulty + "\n"
				+ "Maximun enemy health and attack is " + difficulty * 10;
		textArea.setText(consoleInfo);
	}
	
	public void showStats(ActionEvent e) {
		consoleInfo += "\n" + "Your health: " + user.getHealth()
				+ "\n" + "Your attack: " + user.getAttack()
				+ "\n" + "Your level: " + user.getLevel()
				+ "\n" + "Your progress: " + user.getProgress();
		textArea.setText(consoleInfo);
	}
	
	public void clearTextArea(ActionEvent e) {
		textArea.clear();
		consoleInfo = "";
	}
	
	public void switchToScene1(ActionEvent e) throws IOException {
		loadScene("Scene1.fxml", e);
	}
	
	public void switchToScene2(ActionEvent e) throws IOException {
		loadScene("Scene2.fxml", e);
	}
	
	public void loadScene(String fxml, ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
