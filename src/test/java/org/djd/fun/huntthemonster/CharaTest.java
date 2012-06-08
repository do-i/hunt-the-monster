package org.djd.fun.huntthemonster;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class CharaTest {

	private static Dungeon dungeon;

	@BeforeClass
	public static void setup() {

		dungeon = new Dungeon(3, 3);

	}

	@Test
	public void init_validArgs_success() {
		Assert.assertNotNull(new Chara(dungeon));

	}

	@Test
	public void isCharaInTheSameRoomWith_validArgs_twoCharasInDiffRoom() {
		Chara chara = new Chara(dungeon);
		chara.x = 0;
		chara.y = 0;
		Player player = new Player(dungeon);
		player.x = 1;
		player.y = 0;
		Assert.assertFalse(chara.isCharaInTheSameRoomWith(player));
	}

	@Test
	public void moveTo_NWfrom00_cannotMove() {
		Chara chara = new Chara(dungeon);
		chara.x = 0;
		chara.y = 0;

		Assert.assertFalse(chara.moveTo(Direction.N));
		Assert.assertFalse(chara.moveTo(Direction.W));

	}

	@Test
	public void moveTo_towardsNorthWall_cannotMove() {
		Chara chara = new Chara(dungeon);		
		chara.y = 0;
		for (int x = 0; x < dungeon.width(); x++) {
			chara.x = x;			
			Assert.assertFalse(chara.moveTo(Direction.N));
		}
	}
	
	@Test
	public void moveTo_towardsEastWall_cannotMove() {
		Chara chara = new Chara(dungeon);		
		chara.x = dungeon.width() - 1;
		for (int y = 0; y < dungeon.height(); y++) {
			chara.y = y;			
			Assert.assertFalse(chara.moveTo(Direction.E));
		}
	}
	
	
	@Test
	public void moveTo_towardsSouthWall_cannotMove() {
		Chara chara = new Chara(dungeon);		
		chara.y = dungeon.height();
		for (int x = 0; x < dungeon.width(); x++) {
			chara.x = x;			
			Assert.assertFalse(chara.moveTo(Direction.S));
		}
	}
	
	@Test
	public void moveTo_towardsWestWall_cannotMove() {
		Chara chara = new Chara(dungeon);		
		chara.x = 0;
		for (int y = 0; y < dungeon.height(); y++) {
			chara.y = y;			
			Assert.assertFalse(chara.moveTo(Direction.W));
		}
	}
	
	@Test
	public void moveTo_updownNotSideToSide() {
		Chara chara = new Chara(dungeon);		
		chara.x = 1;
		chara.y = 1;
				
		Assert.assertFalse(chara.moveTo(Direction.W));
		Assert.assertFalse(chara.moveTo(Direction.E));		
		Assert.assertTrue(chara.moveTo(Direction.N));
		Assert.assertEquals(0,chara.y);
		
		Assert.assertTrue(chara.moveTo(Direction.S));
		Assert.assertEquals(1,chara.y);
		Assert.assertTrue(chara.moveTo(Direction.S));
		Assert.assertEquals(2,chara.y);
		
	}
}
