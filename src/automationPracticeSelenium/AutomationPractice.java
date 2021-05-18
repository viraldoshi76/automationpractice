package automationPracticeSelenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomationPractice {

    WebDriver driver;

    @Before
    public void setUp() {
        String baseUrl = "http://automationpractice.com/index.php";//variable is initalised with url
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();//object create to execute method
        driver.manage().window().maximize();//maximize the window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//to give time to open the browser
        driver.get(baseUrl);//it will open the url
    }

    @Test
    public void verifyUserEnterCorrectEmailWrongPasswordGetsErrorMessage(){
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("viral@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("asdfj564LK");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        driver.findElement(By.xpath("//p[text()='There is 1 error']"));
    }
}
