package main;

public class Event {
	
	public Event() {
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
				return "player won";
			}
		}
		return "enemy won";
	}
}
