package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/SeleniumBasic/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com");

        // if we send selenium to test an element of a webpage it is going to see the back not the frontpage
        // so we need to give it the locator
        // in this case we're giving it id:
//           driver.findElement(By.id("email"));
        // in order for us to type some text into the text box we use method sendKeys:
        driver.findElement(By.id("email")).sendKeys("Syntax@abcd.com");
        driver.findElement(By.id("pass")).sendKeys("nemanja");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
        //    driver.findElement(By.linkText("Forgot password?"));
        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.quit();





    }
}