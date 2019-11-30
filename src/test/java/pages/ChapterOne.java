package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChapterOne extends HomePage {

    private String homePageBtn = "xpath:>//*[contains(text(),\"Home Page\")]";
    private String h1 = "xpath:>//*[@class=\"mainheading\"]";
    private String bodyText = "xpath:>//p[1]/text()";
    private String assertText = "id:>\"divontheleft\"";
    private String radioButton = "id:>\"radiobutton\"";
    private String dropBox = "id:>\"selecttype\"";
    private String checkBox = "css:>input[type=\"checkbox\"]";
    private String verifyButton = "id:>\"verifybutton\"";
    private String bigField = "id:>\"html5div\"";
    private String littleField = "id:>\"secondajax\"";
    private String loadTextBtn = "id:>\"secondajaxbutton\"";
    private String loadAjax = "id:>\"loadajax\"";
    private String anotherWindowOne = "xpath:>//*[@class=\"multiplewindow\"]";
    private String anotherWindowOTwo = "xpath:>//*[@class=\"multiplewindow2\"]";


    public ChapterOne(WebDriver browser) {
        super(browser);
    }

    public void checkUrlContains(String text) {
        Assert.assertTrue(getCurrentUrl().contains(text.toLowerCase()), "Fail!");
        System.out.println("Right Url!");
    }

    public void checkTextOnPage(String text) {
        Assert.assertNotNull(findElement(textCheck, text), "Fail");
        System.out.println("Text Find!");
    }

    public void pressBtnHomePage(String url) {
        findElement(homePageBtn).click();
        Assert.assertEquals(url, getCurrentUrl(), "Fail!");
        System.out.println("Welcome Home!");
        makeScreen();
    }
}
