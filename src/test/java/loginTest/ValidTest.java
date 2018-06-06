package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;

public class ValidTest {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        File fileFF = new File("drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1");

//        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest(){
        loginPage.openPage("http://v3.test.itpmgroup.com/login");
        loginPage.loginUser("student", "90");
    }

    @After
    public void teadDown(){
        driver.quit();
    }
}
