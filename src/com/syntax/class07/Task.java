package com.syntax.class07;


      /*Go to https://demoqa.com/browser-windows
        click on New Tab and print the text from new tab in the console
        click on New Window and print the text from new window in the console
        click on New Window Message and print the text from new window in the console
        Verify (compare) the titles for each page
        Print out the title of the all pages*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        newTab.click();
        newWindow.click();
        newWindowMessage.click();
        String parentWindow = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator= allWindowHandles.iterator();
        parentWindow = iterator.next();
        String child1 = iterator.next();
        String child2 = iterator.next();
        String child3 = iterator.next();

        driver.switchTo().window(child2);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.close();

        driver.switchTo().window(child3);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.manage().window().maximize();
        driver.close();

        driver.switchTo().window(child1);
        System.out.println(driver.findElement(By.xpath("//body")).getText());
        driver.close();
        driver.quit();

    }
}
