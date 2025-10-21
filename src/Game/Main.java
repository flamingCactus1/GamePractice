package Game;

import Resources.Characters.Player;
import Resources.Events.Event;
import Resources.Events.EventFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("Welcome to the myRPG v1.0");
            System.out.println("Menu");
            System.out.println("1. Play");
            System.out.println("2. Exit");
            System.out.print("->");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()){
                case "1", "play", "start" ->{
                    Player player = new Player();
                    while(player.isAlive()){
                        Event event = EventFactory.generateEvent();
                        event.execute(player);
                        if(player.isGoToMainMenu()){
                            break;
                        }
                    }
                }
                case "2", "exit", "quit" ->{
                    System.exit(0);
                }
            }
        }

    }
}
