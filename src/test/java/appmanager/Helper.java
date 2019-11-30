package appmanager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Helper {

    private WebDriver browser;

    public Helper(WebDriver browser) {
        this.browser = browser;
    }

    public boolean findElement(By selector) {
        browser.findElement(selector);
        return true;
    }

    public WebElement findElement(String locator) {
        String[] locatorData = locator.split(":>");
        String locatorType = locatorData[0];
        String locatorValue = locatorData[1];
        By by = null;
        switch (locatorType) {
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "link":
                by = By.linkText(locatorValue);
                break;
            default:
                System.out.println("Something went wrong: there is no such " + locatorType + " method!");
        }
        return browser.findElement(by);
    }

    public WebElement findElement(String locator, String value) {
        return findElement(String.format(locator, value));
    }

    public String getCurrentUrl() {
        return browser.getCurrentUrl();
    }

    public boolean elementExists(By selector) {
        return browser.findElements(selector).size() != 0;
    }

    public void wait(int i) {
        browser.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }

    public void goTo(String url) {
        browser.get(url);
    }

    public void checkUrlsResponse() throws IOException {
        List<WebElement> elements = browser.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            String url = element.getAttribute("href");
            int resp = getResponse(url);
            Assert.assertTrue(resp == 200, "Url: " + url + " Not Correct! " + resp);
            System.out.println("Url: " + url + " Correct!");
        }
    }

    public int getResponse(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
        openConnection.connect();
        int rCode = openConnection.getResponseCode();
        return rCode;
    }

    public long loadTime(String url) {
        long start = System.currentTimeMillis();
        browser.get(url);
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        return totalTime;
    }

    public void makeScreen() {
        try {
            File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("Screens\\screenshot.png"));
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        System.out.println("Screen created. Open Screen folder in project for watch!");
    }
}