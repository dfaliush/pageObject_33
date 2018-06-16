package otherTests;

import libs.UIActions;
import libs.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EditSdelkiPage;
import pages.LoginPage;
import parentTest.ParentTest;

public class OtherTests extends ParentTest{
    public OtherTests(String browser) {
        super(browser);
    }

//    WebDriver driver;
//    LoginPage loginPage;
//    EditSdelkiPage editSdelkiPage;
//    UIActions uiActions;

//    @Before
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1");
//        driver = new ChromeDriver();
//        loginPage = new LoginPage(driver);
//        editSdelkiPage = new EditSdelkiPage(driver);
//         uiActions = new UIActions(driver);
//    }

    @Test
    public void selectDropDownElement() throws InterruptedException {

        loginPage.openPage("http://v3.test.itpmgroup.com/login");
        loginPage.loginUser("student", "909090");

        // Заменить на вейт
        Thread.sleep(1000);
        loginPage.openPage("http://v3.test.itpmgroup.com/dictionary/installation/edit/2");

        // Заменить на вейт
        Thread.sleep(1000);
//        UIActions uiActions = new UIActions(driver);
//        uiActions.selectDropDownElemByValue(editSdelkiPage.selectDealDay(), "06");
        Boolean chosen = uiActions.selectItemInDropDownByVisibleText(editSdelkiPage.selectDealDay(), "06");
        Utils utils = new Utils();
        utils.screenShot("log/bla.jpg", driver);
        checkAcceptanceCriteria
                ("Value is not expected",
                        chosen, true);
    }

//    @After
//    public void teadDown(){
//        driver.quit();
//    }
}
