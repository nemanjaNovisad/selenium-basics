package com.syntax.class08.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class CommonMethods {
    WebDriver driver = new ChromeDriver();
    public void open (String url) {
        driver.get(url);
    }
    public void quit () {
        driver.quit();
    }

}
class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/selenium-basic/drivers/chromedriver");
        CommonMethods methods = new CommonMethods();
        methods.open("https://www.google.com/");
        methods.quit();

    }
}