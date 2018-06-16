package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ParentPage;
import parentTest.ParentTest;

import java.io.File;

public class ValidTest extends ParentTest{
    public ValidTest(String browser) {
        super(browser);
    }

//    WebDriver driver;
//    LoginPage loginPage;



//    @Before
//    public void setUp(){
////        WebDriverManager.chromedriver().setup();
////        File fileFF = new File("drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1");
//
////        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
//        driver = new ChromeDriver();
//        loginPage = new LoginPage(driver);
//    }

    @Test
    public void validLoginTest(){
        loginPage.loginUser("student", "909090");
        checkAcceptanceCriteria
                ("Avatar is not present", homePage.isAvatarpresent(), true);
        checkAcceptanceCriteria
                ("Title is not present", homePage.getTitle(), "Учет запчастей");
    }

//    @After
//    public void teadDown(){
//        driver.quit();
//    }
}
