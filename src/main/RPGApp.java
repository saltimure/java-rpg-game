package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RPGApp extends Application{

	public static void main(String[] args) {
		
		Application.launch(args);
		
		/*
		Scanner scan = new Scanner(System.in);
		Event event = new Event();
		User user = new User();
		while(user.getHealth() > 0) {
			System.out.println("1.Go to the dungeon" + "\n" + "2.Check inventory"
					+ "\n" + "3.Check level"  + "\n" + "4.Check progress"  + "\n" + "5.Check stats"
					+ "\n" + "6.Restart game" + "\n" + "7.Exit game");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("Which difficulty do you want?");
				System.out.println(event.fight(user, new Enemy(scan.nextInt())));
				break;
			case 2:
				
				break;
			case 3:
				System.out.println(user.getLevel());
				break;
			case 4:
				System.out.println(user.getProgress());
				break;
			case 5:
				System.out.println("Your attack: " + user.getAttack());
				System.out.println("Your health: " + user.getHealth());
				break;
			case 6:
				user = new User();
				break;
			case 7:
				user.setHealth(0);
				break;
			default:
				break;
			}
		}
		*/
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Image image = new Image("1.jpeg");
		ImageView imageView = new ImageView(image);
		Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		Scene scene = new Scene(root);
		
		stage.getIcons().add(image);
		stage.setTitle("saltimure");
		
		stage.setScene(scene);
		stage.show();
	}
}
