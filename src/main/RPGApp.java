package main;

import java.util.Scanner;

public class RPGApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Event event = new Event();
		User user = new User();
		while(user.getHealth() > 0) {
			System.out.println("1.Go to the dungeon" + "\n" + "2.Check inventory"
					+ "\n" + "3.Check level"  + "\n" + "4.Check progress"  + "\n" + "5.Check stats"
					+ "\n" + "6.Restart game" + "\n" + "7.Exit game");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("Which difficulty do you whant?");
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
	}
}
