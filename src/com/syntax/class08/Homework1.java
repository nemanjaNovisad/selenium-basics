package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework1 {

        /*
go to https://the-internet.herokuapp.com/dynamic_controls
click on checkbox and click on remove
verify the text
click on enable verify the textbox is enabled
enter text and click disable
verify the textbox is disabled
*/

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/selenium-basic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //click checkbox and click remove
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
        //wait for text "it's gone"
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#message")));
        //check if text is displayed
        System.out.println("Text is displayed: " + driver.findElement(By.cssSelector("#message")).isDisplayed());
        //click on "enable"
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
        //wait for "it's enabled"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#message")));
        //enter some text
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("text");
        //click disable
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
        //wait for "it's disabled"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#message")));
        //verify if it's disabled
        System.out.println("It's disabled: " + driver.findElement(By.cssSelector("#message")).isDisplayed());

    }

}
