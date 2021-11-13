package main;

import java.util.ArrayList;

public class User {
	
	private int health;
	private int attack;
	private ArrayList<String> inventory = new ArrayList<String>();
	private int level;
	private int progress;
	
	public User() {
		this.health = 10;
		this.attack = 7;
		this.level = 1;
		this.progress = 0;
	}
	
	public String fight(User user, Enemy enemy) {
		int damagedHealth;
		int userHealth = user.getHealth();
		while(userHealth > 0) {
			damagedHealth = enemy.getHealth() - user.getAttack();
			enemy.setHealth(damagedHealth);
			if(enemy.getHealth() > 0) {
				userHealth -= enemy.getAttack();
			} else {
				user.levelProgression(enemy.getDifficulty());
				return "Player won";
			}
		}
		return "Enemy won";
	}
	
	public void levelProgression(int difficulty) {
		this.progress += 10 * difficulty;
		if (this.progress >= 100) {
			level++;
			health += 10;
			attack += 10;
			this.progress -= 100;
		}
	}
	
	public void addItem(String item) {
		this.inventory.add(item);
	}
	
	public void removeItem(String item) {
		this.inventory.remove(item);
	}
	
	public String showInventory() {
		String stringInventory = String.join(", ", this.inventory);
		return stringInventory;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getProgress() {
		return progress;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
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
