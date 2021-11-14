package main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
	//private ArrayList<Image> imageArayList = new ArrayList<Image>();
	private String[] itemPool = {"Sword", "Axe","Shield","Revolver","Desert Eagle",
								"Saber", "Dagger", "Sledgehammer", "Machete", "Knife"};
	private int difficulty = 1;
	private int countDefeatedEnemy = 0;
	private int itemPower = 0;
	private int tempItemPower = 0;
	private String equipedItem = "";
	private ArrayList<Integer> itemPowerSequence = new ArrayList<Integer>();
	private int itemIndex = 0;
	private String item;
	
	@FXML
	private TextArea consoleTextArea;
	@FXML
	private TextArea statsTextArea;
	@FXML
	private TextArea inventoryTextArea;
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView gallery;
	
	public void fightResult(ActionEvent e) {
		if (user.fight(user, new Enemy(difficulty)) == "Player won") {
			consoleTextArea.setText("You defeated the enemy. " + ++countDefeatedEnemy);
			itemDrop();
			showStats();
		} else {
			consoleTextArea.setText("Enemy won" + "\n" + "You died.");
			countDefeatedEnemy = 0;
			itemPowerSequence.clear();
			user = new User();
			showStats();
		}
	}
	
	public void itemDrop() {
		if (randomNumber() == 1) {
			item = itemPool[randomNumber() - 1];
			itemPower = randomNumber();
			itemPowerSequence.add(itemPower);
			user.addItem(item + " +" + itemPower);
			consoleTextArea.setText("You defeated the enemy. " + countDefeatedEnemy + "\n" + 
									"You found: " + item + "+ " + itemPower);
			inventoryTextArea.setText(user.showInventory());
		}
	}
	
	public void chooseLeftItem(ActionEvent e) {
		--itemIndex;			
		consoleTextArea.setText(user.getItem(itemIndex) + " " + "(index: " + itemIndex + ")");				
	}
	
	public void chooseRightItem(ActionEvent e) {
		++itemIndex;			
		consoleTextArea.setText(user.getItem(itemIndex) + " " + "(index: " + itemIndex + ")");				
	}	
	
	public void equipItem(ActionEvent e) {
		user.setAttack(user.getAttack() - tempItemPower + itemPowerSequence.get(itemIndex));
		equipedItem = user.getItem(itemIndex);
		tempItemPower = itemPowerSequence.get(itemIndex);
		consoleTextArea.setText("You equiped item" + " " + "(index: " + itemIndex + ")");
		showStats();
	}
	
	public void dropItem(ActionEvent e) {
		if (user.getItem(itemIndex) == equipedItem) {
			user.setAttack(user.getAttack() - tempItemPower);
			tempItemPower = 0;
			equipedItem = "";
		}
		user.removeItem(itemIndex);
		itemPowerSequence.remove(itemIndex);
		consoleTextArea.setText("You dropped item" + " " + "(index: " + itemIndex + ")");
		inventoryTextArea.setText(user.showInventory());
		showStats();
	}
	
	public int randomNumber() {
		return (int)(Math.random() * 10 + 1);
	}
	
	public void showStats() {
		statsTextArea.setText("Your health: " + user.getHealth()
		+ "\n" + "Your attack: " + user.getAttack()
		+ "\n" + "Your level: " + user.getLevel()
		+ "\n" + "Your progress: " + user.getProgress()
		+ "\n" + "Weapon: " + equipedItem);
	}
	
	public void restart(ActionEvent e) {
		user = new User();
		itemPowerSequence.clear();
		equipedItem = "";
		tempItemPower = 0;
		consoleTextArea.setText("You restared the game");
		inventoryTextArea.setText(user.showInventory());
		showStats();
	}
	
	public void plusDifficulty(ActionEvent e) {
		difficulty++;
		consoleTextArea.setText("Difficulty: " + difficulty + "\n"
				+ "Maximun enemy health and attack is " + difficulty * 10);
	}
	
	public void minusDifficulty(ActionEvent e) {
		difficulty--;
		consoleTextArea.setText("Difficulty: " + difficulty + "\n"
				+ "Maximun enemy health and attack is " + difficulty * 10);
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
