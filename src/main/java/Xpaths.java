import java.util.Map;

import static java.util.Map.entry;

public class Xpaths {
    public static final Map<String, String> xpaths = Map.ofEntries(
            entry("not_now", "//*[@id=\"react-root\"]/section/main/div/div/div/div/button"),
            entry("not_now2", "/html/body/div[4]/div/div/div/div[3]/button[2]"),
            entry("search", "/html/body/div[1]/section/nav/div[2]/div/div/div[2]/input"),
            entry("account", "/html/body/div[4]/div[2]/div/article/header/div[2]/div[1]/div[1]/span/a"),
            entry("head", "//*[@id=\"react-root\"]/section/main/div/header/section/div[2]/h1"),
            entry("like_button", "/html/body/div[4]/div[2]/div/article/div[3]/section[1]/span[1]/button/div"),
            entry("first_pic", "//*[@id=\"react-root\"]/section/main/article/div[1]/div/div/div[1]/div[1]/a/div/div[2]"),
            entry("home", "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[1]/div/a/svg"),
            entry("heart","/html/body/div[4]/div[2]/div/article/div[3]/section[1]/span[1]/button/div/span/svg"));
}
