package Resources.Events;

import static Resources.UsefulFunctions.generateRandomInt;

public class EventFactory {

    public static Event generateEvent() {
        int randomNumber = generateRandomInt(1, 4);
        return randomNumber == 1 ? new ExploreEvent() : new BattleEvent();
    }
}
