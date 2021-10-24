package main;

public class Enemy {

	private int health;
	private int attack;
	
	public Enemy() {
		this.health = ((int)Math.random() * (9 - 1) + 1);
		this.attack = ((int)Math.random() * (9 - 1) + 1);
	}
}
