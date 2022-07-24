package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/selenium-basic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo.php");

        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);


        WebElement igButton = driver.findElement(By.cssSelector("a[title='Follow @syntaxtech on Instagram']"));
        WebElement facebook = driver.findElement(By.cssSelector("a[title='Follow @syntaxtech on Facebook']"));
        WebElement igAndFb = driver.findElement(By.cssSelector("a[title='Follow @syntaxtech']"));

        igButton.click();
        facebook.click();
        igAndFb.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());

        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();

            if (!mainPageHandle.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println(driver.switchTo().window(childWindow).getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(mainPageHandle);

    }
}
