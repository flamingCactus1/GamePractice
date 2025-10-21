package Resources;

public class UsefulFunctions {

    public static int generateRandomInt(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
