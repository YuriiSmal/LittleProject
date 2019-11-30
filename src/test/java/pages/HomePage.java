package pages;

import appmanager.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class HomePage extends Helper {
    public String textCheck = "xpath:>//*[contains(text(),\"%s\")]";
    private String header = "xpath:>//*[@class=\"mainheading\"]";
    private String textAdditional = "xpath:>//*[@class=\"mainbody\"]/text()[1]";
    private String pageChapter1 = "xpath:>[contains(text(),\"Chapter1\")]";
    private String pageChapter2 = "xpath:>[contains(text(),\"Chapter2\")]";
    private String pageChapter3 = "xpath:>[contains(text(),\"Chapter3\")]";
    private String pageChapter4 = "xpath:>[contains(text(),\"Chapter4\")]";
    private String pageChapter8 = "xpath:>[contains(text(),\"Chapter8\")]";
    private String input = "id:>\"q\"";

    public HomePage(WebDriver browser) {
        super(browser);
    }

    public void goToTestPage(String url) {
        goTo(url);
    }

    public void checkUrl(String urlToCompare) {
        Assert.assertEquals(getCurrentUrl(), urlToCompare, "Fail");
        System.out.println("Right Url!");
    }

    public void clickOnLinkByVisibleText(String text) {
        findElement(textCheck, text).click();
        System.out.println("Element Found!");
    }

    public void checkTextOnCurrentPage(String text) {
        Assert.assertEquals(text, findElement(textCheck, text).getText(), "Fail");
        System.out.println("All Right!");
    }

    public void checkUrlsOnPage() throws IOException {
        checkUrlsResponse();
    }
}
