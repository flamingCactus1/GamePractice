package Test;

import Resources.Characters.Player;
import Resources.Events.ExploreEvent;

public class ExploreEventTest {
    public static void main(String[] args) {
        Player player = new Player();
        ExploreEvent event = new ExploreEvent();
        event.execute(player);

    }
}
