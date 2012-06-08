package org.djd.fun.huntthemonster;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

	private static Dungeon dungeon;
	private Player player;

	@BeforeClass
	public static void init() {
		dungeon = new Dungeon(3, 3);
	}

	@Before
	public void setup() {
		player = new Player(dungeon);
		player.x = 0;
		player.y = 0;
	}

	@Test
	public void shoot_towardsEast_hits() {
		Chara monster = new Chara(dungeon);
		monster.x = 1;
		monster.y = 0;
		Assert.assertFalse(player.shoot(Direction.N, monster));
		Assert.assertTrue(player.shoot(Direction.E, monster));
		Assert.assertFalse(player.shoot(Direction.S, monster));
		Assert.assertFalse(player.shoot(Direction.W, monster));

	}

	@Test
	public void smell_closeEnough_verySmelly() {
		Chara monster = new Chara(dungeon);
		monster.x = 1;
		monster.y = 0;
		Assert.assertTrue(player.smell(monster));
		
	}
	
	@Test
	public void smell_notCloseEnough_cannotSmell() {
		Chara monster = new Chara(dungeon);
		monster.x = 1;
		monster.y = 1;
		Assert.assertFalse(player.smell(monster));
		
	}

}
