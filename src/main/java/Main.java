import java.io.IOException;

/**
 * Самый главный класс.
 */
public class Main {

    private static CredentialProperties credentials;

    /**
     * Точка входа в программу.
     */

    public static void main(String[] args) {
        setup();

        var bot = new InstaGrow(credentials.getLogin(), credentials.getPassword());

        bot.start();

    }

    /**
     * Настройка программы перед работой.
     */

    private static void setup() {

        // Настройка лога.

        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT [%4$s]: %5$s%6$s%n");

        // Чтение параметров из файла.

        try {
            credentials = new CredentialProperties();
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }

        // Указываем путь к Chromedriver.
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        // Указываем путь к Geckodriver.
        //System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
    }
}