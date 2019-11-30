package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.ChapterOne;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Manager {

    private WebDriver browser;
    private Helper helper;
    private String browserType;
    private HomePage homePage;
    private ChapterOne chapterOne;

    public Manager(String browserType) {
        this.browserType = browserType;
    }

    public void init() {
        switch (browserType.toUpperCase()) {
            case "CHROME":
                browser = new ChromeDriver();
                break;
            case "FIREFOX":
                browser = new FirefoxDriver();
                break;
            case "IE":
                browser = new InternetExplorerDriver();
                break;
            default:
                System.err.println("No browser specified");
        }
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        helper = new Helper(browser);
        homePage = new HomePage(browser);
        chapterOne = new ChapterOne(browser);
    }

    public void stop() {
        browser.quit();
    }

    public Helper getHelper() {
        return helper;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public ChapterOne getChapterOne() {
        return chapterOne;
    }
}