package org.djd.fun.huntthemonster;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

public class GameTest {

	private static final String INPUT_DATA = "END";


	@Test
	public void start_end_success() throws IOException {
	
		ByteArrayInputStream byteArrayInputStream = new  ByteArrayInputStream(INPUT_DATA.getBytes());
		System.setIn(byteArrayInputStream);
		Game game = new Game(3, 3);
	
		game.start();	

	}

	

}
