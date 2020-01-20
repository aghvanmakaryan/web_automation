import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {
    private WebDriver driver;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriverMac");

        driver = new ChromeDriver();

        driver.manage().window().maximize();


    }
     @BeforeMethod
     public void openPage(){
         driver.get("https://the-internet.herokuapp.com/");
         driver.findElement(By.cssSelector("a[ href=\"/login\"]")).click();
     }
    @Test
    public void isOpenPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in")).isDisplayed(),"Log in page is not found");


    }
    @Test
    public void isLoginValid(){
        driver.findElement(By.cssSelector("input.username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("i[class=\"fa fa-2x fa-sign-in\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed());

    }
    @Test
    public void isLoginInvalid(){
        driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys("");
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("i[class=\"fa fa-2x fa-sign-in\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("i[class=\"fa fa-2x fa-sign-in\"]")).isDisplayed());

    }

    }



