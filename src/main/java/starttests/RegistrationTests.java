package starttests;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.RandomUtils;

import java.util.concurrent.TimeUnit;

public class RegistrationTests {
    WebDriver driver;
    RandomUtils randomUtils = new RandomUtils();

    @BeforeClass
    public void preconditions(){
        driver = new ChromeDriver();
        driver.navigate().to("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void registrationPositive() throws InterruptedException {
        String email = randomUtils.generateEmail(7);
        System.out.println(email);

        driver.findElement(By.xpath("//a[contains(@href, '/login')]")).click();

        WebElement inputEmail = driver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
        Thread.sleep(3000);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Beer12345!");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@name='registration']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text() = 'Sign Out']")).click();

    }

    @AfterClass
    public void postConditions(){
        driver.quit();
    }
}
