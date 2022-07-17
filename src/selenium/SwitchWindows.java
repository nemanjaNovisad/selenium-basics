package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchWindows {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/SeleniumBasic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();

        //how to switch from parent window to child:
        //program doesn't recognize when new windows opens, you have to tell selenium specifically

        Set<String> windows  = driver.getWindowHandles(); //[parent, child]
        Iterator <String> id = windows.iterator();
        String parentId = id.next(); // iterator starts before [0] index     ,[][]
        String childId = id.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);







    }
}
