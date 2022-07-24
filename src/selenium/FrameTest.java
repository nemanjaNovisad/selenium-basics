package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {

        /*In the context of a web browser, a frame is a part of a web page or browser window which displays content
        independent of its container, with the ability to load content independently.
        The HTML or media elements shown in a frame may come from a different web site
        as the other elements of content on display, although this practice,
        known as framing,[1] is today often regarded as a violation of same-origin
        policy and has been considered a form of copyright infringement.
        In HTML, a frameset is a group of named frames to which web pages and media can be directed;
        an iframe provides for a frame to be placed inside the body of a document. */

        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/SeleniumBasic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        //to check how many frames there is on the webpage:
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        driver.findElement(By.id("draggable"));
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        a.dragAndDrop(source, target).build().perform();

        //to tell webriver to come back to default content:
        driver.switchTo().defaultContent();



    }
}
