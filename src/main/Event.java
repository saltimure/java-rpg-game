package main;

public class Event {
	
	public Event() {
	}
	
	public String fight(User user, Enemy enemy) {
		int damagedHealth;
		while(user.getHealth() > 0) {
			damagedHealth = enemy.getHealth() - user.getAttack();
			enemy.setHealth(damagedHealth);
			if(enemy.getHealth() > 0) {
				damagedHealth = user.getHealth() - enemy.getAttack();
				user.setHealth(damagedHealth);
			} else {
				return "player won";
			}
		}
		return "enemy won";
	}
}
