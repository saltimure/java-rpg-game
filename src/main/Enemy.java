package main;

public class Enemy {

	private int health;
	private int attack;
	
	public Enemy() {
		this.health = (int)(Math.random() * (11 - 1) + 1);
		this.attack = (int)(Math.random() * (11 - 1) + 1);
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHealth() {
		return health;
	}
	
}
