package otherTests;

import libs.UIActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DealsEdit;
import pages.LoginPage;

public class OtherTests {

    WebDriver driver;
    LoginPage loginPage;
    DealsEdit dealsEdit;
    UIActions uiActions;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dealsEdit = new DealsEdit(driver);
         uiActions = new UIActions(driver);
    }

    @Test
    public void selectDropDownElement() throws InterruptedException {
        loginPage.openPage("http://v3.test.itpmgroup.com/login");
        loginPage.loginUser("student", "909090");

        // Заменить на вейт
        Thread.sleep(1000);

        loginPage.openPage("http://v3.test.itpmgroup.com/dictionary/installation/edit/2");

        // Заменить на вейт
        Thread.sleep(1000);
        uiActions.selectDropDownElemByValue(dealsEdit.selectDealDay(), "06");

    }

    @After
    public void teadDown(){
        driver.quit();
    }
}
