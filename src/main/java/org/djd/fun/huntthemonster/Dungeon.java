package org.djd.fun.huntthemonster;

import static org.djd.fun.huntthemonster.Constants.NEW_LINE;
import java.util.Random;

public class Dungeon {

   private static final long SEED_PSUDO_RANDOM = 20120608;
   private static final Random PSUDO_RANDOM = new Random(SEED_PSUDO_RANDOM);

	private boolean[][] area;

	public Dungeon(int width, int height) {

		if (width < 2) {
			throw new IllegalArgumentException("Dungeon width not big enough.");
		}

		if (height < 2) {
			throw new IllegalArgumentException("Dungeon width not big enough.");
		}

		// area = new boolean[width][height];
		area = new boolean[height][width]; // to print x and y in correct
											// coordinate I swapped height and
											// width.

		configureDungeon();
	}

	/**
	 * x
	 * 
	 * @return
	 */
	public int width() {
		return area[0].length;
	}

	/**
	 * y
	 * 
	 * @return
	 */
	public int height() {
		return area.length;
	}

	/**
	 * 2 x 2 area <br>
	 * 1 1 <br>
	 * 0 1 
	 * <p>
	 * 3 x 3 area <br>
	 * 1 1 1 <br>
	 * 0 1 0 <br>
	 * 1 1 1 
	 * <p>
	 * 4 x 4 area <br>
	 * 1 1 1 1<br>
	 * 0 1 0 1<br>
	 * 1 1 1 1<br>
	 * 0 1 0 1
	 * <p>

	 * 
	 * set 0's 1's.
	 */
	protected void configureDungeon() {

		for (int y = 0; y < area.length; y++) {

			for (int x = 0; x < area[y].length; x++) {
				boolean xyRoom = false;
				if (0 == y % 2) {
					// y is even number 0, 2, 4, ...
					xyRoom = true;
				} else {
					// y is odd number 1, 3, 5, ...

					if (0 != x % 2) {
						// x is odd number 1, 3, 5, ...
						xyRoom = true;
					}
				}
				area[y][x] = xyRoom;
			}

		}
	}

	/**
	 * set 0's 1's.
	 */
	@Deprecated
	protected void configureDungeonRandomly() {

		for (int y = 0; y < area.length; y++) {

			for (int x = 0; x < area[y].length; x++) {

				area[y][x] = isRoom();
			}

		}
	}

	/**
	 * 75% is a room.
	 * 
	 * @return true if it is a room.
	 */
	@Deprecated
	private boolean isRoom() {

		return 0 != PSUDO_RANDOM.nextInt(4);
	}

	public boolean isRoom(int x, int y) {
		
		return area[y][x];
	}

	@Deprecated
	public void debugPrintDungeonMap() {
		StringBuilder sb = new StringBuilder();
		for (boolean[] rooms : area) {

			for (boolean room : rooms) {
				sb.append(toInt(room));
				sb.append(" ");

			}

			sb.append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	public void debugPrintDungeonMapWithCharas(Chara monster, Chara player) {
		StringBuilder sb = new StringBuilder();
		for (int y=0; y<area.length; y++) {

			for (int x=0; x<area[y].length; x++) {
				
				if( x == monster.x && y == monster.y){
					sb.append('M');
				} else if( x == player.x && y == player.y){
					sb.append('P');
				} else {
					sb.append(toInt(area[y][x]));
				}
				sb.append(" ");

			}

			sb.append(NEW_LINE);
		}
		System.out.println(sb);
	}

	/**
	 * 
	 * @param b
	 * @return 0 if b is false, 1 if b is true
	 */
	protected int toInt(boolean b) {
		return b ? 1 : 0;
	}

}
