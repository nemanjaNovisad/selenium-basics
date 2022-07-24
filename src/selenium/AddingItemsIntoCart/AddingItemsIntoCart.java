package selenium.AddingItemsIntoCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingItemsIntoCart {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/SeleniumBasic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");



    }
}
