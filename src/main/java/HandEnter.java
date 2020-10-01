import org.openqa.selenium.WebElement;


public class HandEnter {

    public static void HandFieldEnter(WebElement field, String word){
                        for (int i = 0; i < word.length(); i++) {
                    char letter = word.charAt(i);

                    field.sendKeys(String.valueOf(letter));
                    Wait.waitForKeys();
                }
    }
}
