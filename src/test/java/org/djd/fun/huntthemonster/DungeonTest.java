package org.djd.fun.huntthemonster;

import junit.framework.Assert;

import org.junit.Test;


public class DungeonTest  {

	@Test(expected=IllegalArgumentException.class)
	public void init_negativeXY_error(){
		new Dungeon(-1, -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void init_zeroXY_error(){
		new Dungeon(0, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void init_oneXY_error(){
		new Dungeon(1, 1);
	}
	
	@Test
	public void isRoom_2x2Dungeon_success(){
		Dungeon dungeon = new Dungeon(2, 2);
		Assert.assertTrue(dungeon.isRoom(0,0));
		Assert.assertFalse(dungeon.isRoom(0,1));
		Assert.assertTrue(dungeon.isRoom(1,0));
		Assert.assertTrue(dungeon.isRoom(1,1));
	
	}
	
	@Test
	public void isRoom_3x3Dungeon_success(){
		Dungeon dungeon = new Dungeon(3, 3);
		Assert.assertTrue(dungeon.isRoom(0,0));
		Assert.assertTrue(dungeon.isRoom(1,0));
		Assert.assertTrue(dungeon.isRoom(2,0));
		
		Assert.assertFalse(dungeon.isRoom(0,1));		
		Assert.assertTrue(dungeon.isRoom(1,1));
		Assert.assertFalse(dungeon.isRoom(2,1));
		
		Assert.assertTrue(dungeon.isRoom(0,2));		
		Assert.assertTrue(dungeon.isRoom(1,2));
		Assert.assertTrue(dungeon.isRoom(2,2));
	
	}
	
	@Test
	public void width_2_success(){
		Dungeon dungeon = new Dungeon(2, 10);
		
		Assert.assertEquals(2, dungeon.width());
	
	}
	@Test
	public void hethgi_10_success(){
		Dungeon dungeon = new Dungeon(2, 10);
		
		Assert.assertEquals(10, dungeon.height());
	
	}
}
