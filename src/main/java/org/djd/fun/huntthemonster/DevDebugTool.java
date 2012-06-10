package org.djd.fun.huntthemonster;

/**
 * 
 * This class is a debugging tool. It displays dungeon and location of monster
 * and the player.
 * 
 * <p>
 * 
 * <li>0 indicates no room
 * <li>1 indicates a room
 * <li>m indicates a monster
 * <li>p indicates a player
 * 
 */
public class DevDebugTool {

   Dungeon dungeon;
   Chara charaMonster;
   Player player;

   public DevDebugTool(Dungeon dungeon, Chara charaMonster, Player player) {
      this.dungeon = dungeon;
      this.charaMonster = charaMonster;
      this.player = player;
   }

   public void debugInfo() {
      System.out.println("============================================");
      System.out.println("Dungeon");
      dungeon.debugPrintDungeonMapWithCharas(charaMonster, player);

      System.out.println(String.format("player location (%d,%d)", player.x, player.y));
      System.out.println(String.format("monster location (%d,%d)", charaMonster.x, charaMonster.y));
      System.out.println("============================================");

   }
}
