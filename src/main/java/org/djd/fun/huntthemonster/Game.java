package org.djd.fun.huntthemonster;

import static org.djd.fun.huntthemonster.Constants.MAX_RETRY_COUNT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 
 * Initialize {@link Information}, {@link Dungeon}, {@link Chara},
 * {@link Player} objects.
 * 
 */
public class Game {

	private static final String DIRECTIONS = "[NESW]?";
	private static final String WELCOME_MESSAGE = "Welcome to Hunt the Wumpus!";
	private static final String END_MESSAGE = "See you soon!";
	private static final Random RANDOM = new Random();
	Information information;
	Dungeon dungeon;
	Chara charaMonster;
	Player player;

	DevDebugTool devDebugTool;

	/**
	 * default Game constructs with 2x2 dungeon.
	 */
	public Game() {
		this(2, 2);
	}

	/**
	 * Creates Game with Dungeon size specified by args.
	 * 
	 * @param width
	 *            of dungeon
	 * @param height
	 *            of dungeon
	 */
	public Game(int width, int height) {
		information = new Information();
		dungeon = new Dungeon(width, height);
		charaMonster = new Chara(dungeon);

		// make sure the player is not in the same room as monster.
		do {
			player = new Player(dungeon);
		} while (arePlayerAndMonsterInTheSameRoom());

		devDebugTool = new DevDebugTool(dungeon, charaMonster, player);
	}

	/**
	 * Starts the game. Accepts user input as command. If user enters 'end' then
	 * game will halt. Otherwise it continues until monster kills you or other
	 * way around.
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {

		System.out.println(WELCOME_MESSAGE);

		boolean exit = false;
		do {
			devDebugTool.debugInfo();
			information.displayAvailableCommands();

			String command = acceptCommand().toUpperCase();

			System.out.println("You entered. " + command);

			if (command.matches(DIRECTIONS)) {
				Direction direction = Direction.valueOf(command);
				if (!player.moveTo(direction)) {
					information.displayCannotMoveToDirection(direction);
					continue; // without moving monstor, player can move if the
								// player failed to move.
				}
			} else {

				switch (command) {

				case "F": // find (smell)
					if (player.smell(charaMonster)) {
						information.displayMonsterIsAround();

					} else {

						information.displayMonsterIsNotAround();
					}

					continue; // don't let monster move around.
				case "A": // attack

					if (attackAction()) {
						exit = true;
						information.displayPlayerKilledMonster();

					} else {
						information.displayMissAttack();
					}

					break;
				case "END":
					exit = true;
					break;
				default:
					information.displayWarnNotValidCommand(command);
					continue;

				}
			}

			// check if player and monster are in the same room after player's
			// move
			if (!exit && arePlayerAndMonsterInTheSameRoom()) {
				exit = true;
				information.displayMonsterKilledPlayer();
			}

			// move monster.
			if (!exit) {
				moveMonsterRandomly();
			}
			// check if player and monster are in the same room after monster's

			if (!exit && arePlayerAndMonsterInTheSameRoom()) {
				exit = true;
				information.displayMonsterKilledPlayer();
			}

		} while (!exit);
		System.out.println(END_MESSAGE);

	}

	/**
	 * 
	 * @return command entered by the user.
	 * @throws IOException
	 */
	private String acceptCommand() throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		return stdin.readLine();
	}

	private boolean attackAction() throws IOException {
		information.displayAvailableCommandsForAttack();

		String command = acceptCommand().toUpperCase();
		System.out.println("Attacking " + command);

		if (command.matches(DIRECTIONS)) {

			Direction direction = Direction.valueOf(command);
			return player.shoot(direction, charaMonster);
		}

		// if use enter wrong direction it is considered as miss.
		return false;
	}

	private boolean arePlayerAndMonsterInTheSameRoom() {
		return player.isCharaInTheSameRoomWith(charaMonster);
	}

	/**
	 * Simple-minded monster Never Eats Sea-Weed. The monster tries to move in
	 * the order of N-E-S-W.
	 */
	@Deprecated
	private void moveMonster() {

		for (Direction direction : Direction.values()) {
			if (charaMonster.moveTo(direction)) {
				return;
			}
		}

		throw new IllegalStateException("Monster cannot move to any direction.");

	}

	/**
	 * Monster randomely choose which way he wants to move.
	 * If picked direction is not movable then pick again.
	 * Monster can pick same spot more than once.
	 */
	private void moveMonsterRandomly() {

		Direction[] directions = Direction.values();
		int count = 0;
		
		boolean monsterMovedOk = false;
		do {

			int index  = RANDOM.nextInt(directions.length);
			++count;
			if (MAX_RETRY_COUNT < count) {
				throw new IllegalStateException(
						"Monster cannot move to any directions.");
			}
			monsterMovedOk = charaMonster.moveTo(directions[index]);
		} while (!monsterMovedOk);

	}

}
