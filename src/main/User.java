package main;

public class User {
	
	private int health;
	private int attack;
	private String[] inventory;
	private int level;
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

	private int progress;
	
	public User() {
		this.health = 10;
		this.attack = 7;
		this.level = 1;
		this.progress = 0;
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
