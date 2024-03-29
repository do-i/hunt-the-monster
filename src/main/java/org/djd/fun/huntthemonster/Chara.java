package org.djd.fun.huntthemonster;

import java.util.Random;

/**
 * 
 * Chara is a charactor object to represent monster and player's parent class.
 * <p>
 * This class has a reference to an instance of {@link Dungeon} to get info
 * about dungeon size and room configuration.
 * 
 */
public class Chara {
   private static final long SEED_PSUDO_RANDOM = 20120608;
   private static final Random PSUDO_RANDOM = new Random(SEED_PSUDO_RANDOM);

   protected int x;
   protected int y;

   protected Dungeon dungeon;

   /**
    * 
    * @param 0 <= x < dungeon.width
    * @param 0 <= y < dungeon.height
    */
   public Chara(Dungeon dungeon) {
      this.dungeon = dungeon;

      // if no room then re-generate x, y
      do {
         x = PSUDO_RANDOM.nextInt(dungeon.width());
         y = PSUDO_RANDOM.nextInt(dungeon.height());

      } while (!dungeon.isRoom(x, y));

   }

   /**
    * Check if this chara is on the same spot with the argument.
    * 
    * @return true if they are on the same spot (x,y), false otherwise.
    */
   public boolean isCharaInTheSameRoomWith(Chara chara) {
      return (this.x == chara.x) && (this.y == chara.y);
   }

   /**
    * move the chara to the specified direction.
    * 
    * @return <code>true</code> if the chara was successfully moved.
    *         <code>false</code> otherwise.
    */
   public boolean moveTo(Direction direction) {

      int newx = getNewLocationX(direction);
      int newy = getNewLocationY(direction);

      boolean newxOk = isInRange(newx, 0, dungeon.width());
      boolean newyOk = isInRange(newy, 0, dungeon.height());

      // check if the new location is a room.
      boolean allOk = newxOk && newyOk && dungeon.isRoom(newx, newy);
      if (allOk) {
         x = newx;
         y = newy;
      }

      return allOk;
   }

   protected int getNewLocationX(Direction direction) {
      return x + direction.x;
   }

   protected int getNewLocationY(Direction direction) {
      return y + direction.y;
   }

   /**
    * 
    * @param value
    * @param min
    * @param max
    * @return true if min <= value < max, false otherwise.
    */
   private boolean isInRange(int value, int min, int max) {
      return (min <= value) && (value < max);
   }

}
