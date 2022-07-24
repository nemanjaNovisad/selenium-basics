package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/selenium-basic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://syntaxprojects.com/dynamic-elements-loading.php");

        WebElement getNewUser = driver.findElement(By.id("save"));
        getNewUser.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='First-Name'] ")));

        WebElement firstName = driver.findElement(By.cssSelector("div[id='First-Name'] "));
        firstName.click();

        driver.quit();






    }
}
