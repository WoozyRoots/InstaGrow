import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Map.entry;

import java.io.IOException;

public class InstaGrow {

    private final String login;
    private final String password;
    private Logger logger;

    private ChromeDriver browser;
    private ChromeDriver browser2;

//    private WebDriver browser;
//    private WebDriver browser2;

//    private int baseDelay = 1; // Рабочий 1, отладка 1
//    private int minWait = 1; // Рабочий 1, отладка 1
//    private int maxWait = 3; // Рабочий 8, отладка 3
    private HashMap<Integer, String> tagBase;

    String randTag;

    /**
     * @param login    Логин.
     * @param password Пароль.
     */
    InstaGrow(String login, String password) {
        this.login = login;
        this.password = password;
        logger = Logger.getLogger(InstaGrow.class.getName());
    }

    /**
     * Начинаем лайк-кодинг!
     */
    void start() {
        log("InstaLike начал свою работу!");

        browser = new ChromeDriver();
//        browser =new FirefoxDriver();

        login();
        // end();
    }

    /**
     * Логинимся.
     */
    private void login() {
        // log(String.format("Работаем; Логин: %s, Пароль: %s", login, password));
        browser.get("https://www.instagram.com/accounts/login/");
        Wait.waitASecond();

        browser.findElement(new By.ByName("username")).sendKeys(login);
        Wait.waitASecond();

        var pass= browser.findElement(new By.ByName("password"));

        pass.sendKeys(password);
        pass.sendKeys(Keys.RETURN);
        Wait.waitASecond();

        browser.findElement(new By.ByXPath(Xpaths.xpaths.get("not_now"))).click();
        Wait.waitASecond();

        browser.findElement(new By.ByXPath(Xpaths.xpaths.get("not_now2"))).click();
        Wait.waitASecond();
        log(String.format("Залогинились, как %s", login));

        // читаем базу тегов
        try {
            TagsBase tag = new TagsBase();
            tagBase = tag.getTagBase();

            //System.out.println(tagBase);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Prepared to GROW _______________________________________________________

        //Выбираем активность
        int actionCase = 1; // выбор активности

        switch (actionCase) {
            case 1:
                randTag = tagBase.get(ThreadLocalRandom.current().nextInt(0, tagBase.size()));
                //System.out.println(randTag);
                var search=browser.findElement(new By.ByXPath(Xpaths.xpaths.get("search")));

                HandEnter.HandFieldEnter(search,randTag);

//                for (int i = 0; i < randTag.length(); i++) {
//                    char letter = randTag.charAt(i);
//
//                    search.sendKeys(String.valueOf(letter));
//                    waitForKeys();
//                }


                search.sendKeys(Keys.ENTER);
                search.sendKeys(Keys.ENTER);

                Wait.waitASecond();
                Wait.waitASecond();

                browser.findElement(new By.ByXPath(Xpaths.xpaths.get("first_pic"))).click();
                Wait.waitASecond();
                var likeButton1 = browser.findElement(new By.ByXPath(Xpaths.xpaths.get("heart")));
             //   System.out.println("attribute"+likeButton1.getAttribute("fill"));

                browser.findElement(new By.ByXPath(Xpaths.xpaths.get("like_button"))).click(); //КЛИКАЕТ ЛАЙК !!!
//                System.out.println(browser.findElement(new By.ByXPath(xpaths.get("like_button"))).getAttribute("fill"));
//                try {
//                    browser.findElement(new By.ByClassName("glyphsSpriteHeart__filled__24__red_5"));
//                    log("Тут лайк уже стоит!");
//                }
//                catch (NoSuchElementException ex) {
//                    likeButton.click();
//                    log("Лайкос поставлен, мой генерал!");
//                    waitASecond();
//                }
                //browser.findElement(new By.ByXPath(xpaths.get("account"))).getAttribute("href");

//                browser2 = new ChromeDriver();
//                browser2.get(browser.findElement(new By.ByXPath(xpaths.get("account"))).getAttribute("href"));               browser2.findElement(new By.ByXPath(xpaths.get("head"))).getAttribute("rhpdm");
 //               System.out.println(browser2.findElement(new By.ByXPath(xpaths.get("head"))).getAttribute("rhpdm"));
//                Actions actions=new Actions(browser);
//                actions.moveToElement(browser.findElement(new By.ByXPath(xpaths.get("search")))).sendKeys(Keys.ENTER);

//                browser.findElement(new By.ByXPath(xpaths.get("search"))).sendKeys("b");
//                waitForKeys();
//                browser.findElement(new By.ByXPath(xpaths.get("search"))).sendKeys("c");
                break;
        }


    }

    /**
     * Заканчиваем работу браузера.
     */
    private void end() {
        browser.close();
        log("Bye!");
    }

    /**
     * Ждём секунду. На самом деле от трёх до пяти, случайным образом.
     */

//    public void waitASecond() {
//        try {
//
//            Thread.sleep((baseDelay + ThreadLocalRandom.current().nextInt(minWait, maxWait)) * 1000);
//            // log("Waiting");
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//    }

//    public static void waitForKeys() {
//        try {
//
//            Thread.sleep((ThreadLocalRandom.current().nextInt(5, 8)) * 100);
//            // log("Waiting");
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//    }

    /**
     * Логируем сообщение.
     *
     * @param message Текст сообщения.
     */

    private void log(String message) {
        logger.log(Level.INFO, String.format("Instalike: %s", message));
    }

    /**
     * Логируем предупреждение.
     *
     * @param message Текст предупреждения.
     */

    private void warn(String message) {
        logger.log(Level.WARNING, String.format("Instalike: %s", message));
    }

}
