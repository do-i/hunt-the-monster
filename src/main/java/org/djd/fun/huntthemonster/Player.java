package org.djd.fun.huntthemonster;

public class Player extends Chara {

	public Player(Dungeon dungeon) {
		super(dungeon);

	}

	public boolean shoot(Direction direction, Chara monster) {
		int newX = getNewLocationX(direction);
		int newY = getNewLocationY(direction);

		boolean isSameX = newX == monster.x;
		boolean isSameY = newY == monster.y;
		return isSameX && isSameY;

	}

	/**
	 * 
	 * @param monster
	 * @return true if monster is any of adjacent room (NESW)
	 */
	public boolean smell(Chara monster) {

		for (Direction direction : Direction.values()) {
			int newX = getNewLocationX(direction);
			int newY = getNewLocationY(direction);

			boolean isSameX = newX == monster.x;
			boolean isSameY = newY == monster.y;

			boolean isSmelly = isSameX && isSameY;
			if (isSmelly) {
				return true;
			}
		}
		return false;

	}

}
