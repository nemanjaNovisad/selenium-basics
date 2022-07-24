package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/selenium-basic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");

        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);

        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles(); //store all the handles inside the set
        System.out.println(allWindowHandles);

        Iterator<String> it = allWindowHandles.iterator(); //have an iterator in order to iterate through the handles
        mainPageHandle = it.next(); //take first step and assign the main page handle
        String childHandle = it.next();//take the second step and have a child handle

        //driver.switchTo().window(mainPageHandle);
        driver.switchTo().window(childHandle);
        driver.close();

        driver.switchTo().window(mainPageHandle);
        helpLink.click();





    }
}
