package pages;

import libs.ConfigData;
import libs.UIActions;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.security.krb5.Config;

import java.io.IOException;


public class LoginPage extends ParentPage{

    // 1) type
//    String LoginFieldName = "_username";
//    String PasswordFieldid = "password";
//    String SubmitButtonType = "submit";

    //2) type
//    By LoginFieldName = By.name("_username");
//    By PasswordFieldid = By.id("password");
//    By SubmitButtonXpath = By.xpath(".//button[@type='submit']");

    // 3) type. Only with PageFactory.initElements(driver, this)
    @FindBy(name = "_username")
    WebElement LoginFieldName;

    @FindBy(id = "password")
    WebElement PasswordFieldid;

    @FindBy(xpath = ".//button[@type='submit']")
    WebElement SubmitButtonXpath;


    public LoginPage(WebDriver driver){
        // Вся начинка идет из конструктора ParentPage
        super(driver);
    }

    public void inputToLoginField(String login){
        try {
            uiActions.inputToTextField(LoginFieldName, login);
        } catch (Exception e) {
            log.error("Can't input login " + login);
        }
    }

    public void inputToPasswordField(String password){
        try {
            uiActions.inputToTextField(PasswordFieldid, password);
        } catch (Exception e) {
            log.error("Can't input login " + password);
        }
    }


    public void clickSubmitButton(){
        try {
            uiActions.clickToElement(SubmitButtonXpath);
        } catch (Exception e) {
            log.error("Can't press SubmitButton");
        }
    }


    public void loginUser(String login, String password){
        openLoginPage();
        inputToLoginField(login);
        inputToPasswordField(password);
        clickSubmitButton();
        log.info("Login success");
    }

    public void openPage(String url){
        try {
            driver.get(url);
        } catch (Exception e) {
            log.error("Can't open an url: " + url);
        }
    }


    public void openLoginPage() {
        try {
            driver.get(ConfigData.getCfgValue("base_url") +"/login");
            log.info("Page login was opened");
        } catch (Exception e) {
            log.error("Cannot open URL");
            Assert.fail("Cannot open URL");
        }
    }


}
