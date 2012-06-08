package org.djd.fun.huntthemonster;

import junit.framework.Assert;

import org.junit.Test;

public class StringMatchTest {

	private static final String DIRECTIONS = "[NESW]?";

	@Test
	public void matches_N_matched() {
		String command = "N";
		Assert.assertTrue(command.matches(DIRECTIONS));
	}
	
	@Test
	public void matches_E_matched() {
		String command = "E";
		Assert.assertTrue(command.matches(DIRECTIONS));
	}

	@Test
	public void matches_S_matched() {
		String command = "S";
		Assert.assertTrue(command.matches(DIRECTIONS));
	}
	
	@Test
	public void matches_W_matched() {
		String command = "W";
		Assert.assertTrue(command.matches(DIRECTIONS));
	}
	
	@Test
	public void matches_SW_notMatched() {
		String command = "SW";
		Assert.assertFalse(command.matches(DIRECTIONS));
	}
}
