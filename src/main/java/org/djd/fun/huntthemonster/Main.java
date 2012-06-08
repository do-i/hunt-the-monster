package org.djd.fun.huntthemonster;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		int x = 3;
		int y = 3;

		if (2 == args.length) {
			try {
				x = Integer.parseInt(args[0]);
				y = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				// TODO handle it better. But for now, just use default value
				// silently.
			}
		}
		Game game = new Game(x, y);
		game.startGame();

	}

}
