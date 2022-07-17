package selenium.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Locators1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/nemanja/Code/SeleniumBasic/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("nemanja");
        driver.findElement(By.name("inputPassword")).sendKeys("nemanja");
        driver.findElement(By.className("signInBtn")).click();
        //wait(because it's not going to pick up the text , it needs some time to load and Intellij is to fast)
        //see line 15
        Thread.sleep(3000);
//       System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Katarina");
        driver.findElement(By.cssSelector("input[placeholder ='Email']")).sendKeys("loki@gmail.com");
        driver.findElement(By.xpath("//input[@type ='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type ='text']:nth-child(3)")).sendKeys("nemanja@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("5236235235");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class = 'forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(2000);
//      System.out.println(driver.findElement(By.tagName("p")).getText());
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
        Thread.sleep(3000);
        driver.quit();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        Thread.sleep(1000);
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String [] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];
        return password;


    }

}
