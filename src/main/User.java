package main;

public class User {
	
	private int health;
	private int attack;
	private String[] inventory;
	
	public User() {
		this.health = 10;
		this.attack = 7;
	}

	public int getHealth() {
		return health;
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
}
