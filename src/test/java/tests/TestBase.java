package tests;

import appmanager.Manager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.swing.*;

public class TestBase {

    public static final Manager appMan = new Manager("chrome");

    @BeforeSuite
    public void setBrowser() {
        appMan.init();
    }

    @AfterSuite
    public void closeBrowser() {
        appMan.stop();
        JOptionPane.showMessageDialog(null, "Test already done!");
    }
}
