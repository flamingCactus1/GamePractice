package Test;

import Resources.Characters.Player;
import Resources.Events.BattleEvent;

public class BattleEventTest {
    public static void main(String[] args) {
        Player player = new Player();
        BattleEvent battleEvent = new BattleEvent();

        battleEvent.execute(player);
    }
}
