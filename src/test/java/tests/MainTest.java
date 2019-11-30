package tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class MainTest extends TestBase {

    private String mainPage = "http://book.theautomatedtester.co.uk/";

    @Test
    // Open test web site
    void openPage() {
        appMan.getHomePage().goToTestPage(mainPage);
    }

    // Check that link correct and page contains some text
    @Test(dependsOnMethods = {"openPage"})
    void checkUrl() {
        appMan.getHomePage().checkUrl(mainPage);
        appMan.getHomePage().checkTextOnCurrentPage("Chapter1");
    }

    // Go to next test page
    @Test(dependsOnMethods = {"checkUrl"})
    void clickOnLink() {
        appMan.getHomePage().clickOnLinkByVisibleText("Chapter1");
    }

    // Assert test test
    @Test(dependsOnMethods = {"clickOnLink"})
    void checkText() {
        appMan.getChapterOne().checkTextOnPage("Assert that this text is on the page");
    }

    // Check that url right
    @Test(dependsOnMethods = {"clickOnLink"})
    void checkSecondUrl() {
        appMan.getChapterOne().checkUrlContains("chapter1");
    }

    //
    @Test(dependsOnMethods = {"checkSecondUrl"})
    void backHomePage() {
        appMan.getChapterOne().pressBtnHomePage(mainPage);
    }

    @Test(dependsOnMethods = {"openPage"})
    void urlsOnPage() throws IOException {
        appMan.getHomePage().checkUrlsOnPage();
    }
}
