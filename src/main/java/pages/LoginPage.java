package pages;

import libs.UIActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends ParentPage{


//    String LoginFieldName = "_username";
//    String PasswordFieldid = "password";
//    String SubmitButtonType = "submit";

    By LoginFieldName = By.name("_username");
    By PasswordFieldid = By.id("password");
    By SubmitButtonXpath = By.xpath(".//button[@type='submit']");

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
        inputToLoginField(login);
        inputToPasswordField(password);
        clickSubmitButton();
    }

    public void openPage(String url){
        try {
            driver.get(url);
        } catch (Exception e) {
            log.error("Can't open an url: " + url);
        }
    }


}
