import java.util.concurrent.ThreadLocalRandom;

public class Wait {
    private static int baseDelay = 1; // Рабочий 1, отладка 1
    private static int minWait = 1; // Рабочий 1, отладка 1
    private static int maxWait = 3; // Рабочий 8, отладка 3
    public static void waitASecond() {
        try {

            Thread.sleep((baseDelay + ThreadLocalRandom.current().nextInt(minWait, maxWait)) * 1000);
            // log("Waiting");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void waitForKeys() {
        try {

            Thread.sleep((ThreadLocalRandom.current().nextInt(5, 8)) * 100);
            // log("Waiting");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
