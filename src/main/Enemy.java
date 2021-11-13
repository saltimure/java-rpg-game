package main;

public class Enemy {

	private int health;
	private int attack;
	private int difficulty;
	
	public Enemy(int difficulty) {
		this.difficulty = difficulty;
		this.health = (int)(Math.random() * 10 + 1) * difficulty;
		this.attack = (int)(Math.random() * 10 + 1) * difficulty;
	}

	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
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
