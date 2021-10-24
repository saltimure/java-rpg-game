package main;

import java.util.Scanner;

public class RPGApp {

	public static void main(String[] args) {
		
		Event event = new Event();
		System.out.println(event.fight(new User(), new Enemy()));
		
		/*
		Scanner scan = new Scanner(System.in);
		User user;
		while(true) {
			System.out.println("Start game?");
			if (scan.nextInt() == 1) {
				user = new User();
			} else {
				break;
			}
			System.out.println("Do you want to go outside the castle?");
			if (scan.nextInt() == 1) {
				Event event = new Event();
				event.fight(user, new Enemy());
			}
		}
		*/
	}
}
