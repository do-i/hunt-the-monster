package org.djd.fun.huntthemonster;

import static org.djd.fun.huntthemonster.Constants.NEW_LINE;

public class Information {

	public void displayAvailableCommands() {
		StringBuilder sb = new StringBuilder();
		sb.append("N - move to North");
		sb.append(NEW_LINE);
		sb.append("E - move to East");
		sb.append(NEW_LINE);
		sb.append("S - move to South");
		sb.append(NEW_LINE);
		sb.append("W - move to West");
		sb.append(NEW_LINE);

		sb.append("F - Smell(Find)");
		sb.append(NEW_LINE);

		sb.append("A - Attack");
		sb.append(NEW_LINE);

		sb.append("END - End Game");
		sb.append(NEW_LINE);
		sb.append("Command > ");

		System.out.println(sb);
	}

	public void displayWarnNotValidCommand(String command) {

		System.out.println(String.format("%s is an invalid command.", command));

	}

	public void displayCannotMoveToDirection(Direction direction) {
		System.out.println(String.format("You cannot move %s direction.",
				direction));
	}

	public void displayMonsterIsAround() {
		System.out.println("Monster is close to you.");

	}

	public void displayMonsterIsNotAround() {
		System.out.println("No monster is close to you.");

	}

	public void displayMonsterKilledPlayer() {
		System.out.println("Monster beat you in the same room. Gave over!");
		
	}

	public void displayAvailableCommandsForAttack() {
		StringBuilder sb = new StringBuilder();
		sb.append("N - attack to North");
		sb.append(NEW_LINE);
		sb.append("E - attack to East");
		sb.append(NEW_LINE);
		sb.append("S - attack to South");
		sb.append(NEW_LINE);
		sb.append("W - attack to West");
		sb.append(NEW_LINE);
		
		sb.append("Attack Direction >>");
		System.out.println(sb);		
		
	}

	public void displayPlayerKilledMonster() {
		System.out.println("You beat the monster. Gave Cleared!");
		
	}

	public void displayMissAttack() {
		System.out.println("You missed attack.");
		
	}
}
