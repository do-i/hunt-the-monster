package org.djd.fun.huntthemonster;

/**
 * Direction offset based on 2 dimentional array <code>area = new [y][x]</code>.
 * 
 * <pre>
 * [0,0][1,0][2,0]...[n,0] 
 * [0,1][1,1][2,1]...[n,1] 
 * [0,2][1,2][2,2]...[n,2] 
 *       .
 *       .
 * [0,n][1,n][2,n]...[n,n] 
 * </pre>
 * 
 * @author acorn
 *
 */
public enum Direction {

	N(0, -1), E(1, 0), S(0, 1), W(-1, 0);

	public int x;
	public int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
