package loginTest;

import libs.ConfigData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;


@RunWith(value = Parameterized.class)

public class ValidTestWithParamFromExel extends ParentTest{

    String login, pass;

    public ValidTestWithParamFromExel(String browser) {
        super(browser);
    }


    @Test
    public void validLogin() throws IOException {
        Map dataFromExelForValidLoginTest = excelDriver
                .getData(ConfigData.getCfgValue("DATA_FILE"),"validLogOn");

        loginPage.openLoginPage();
        loginPage.inputToLoginField(dataFromExelForValidLoginTest.get("login").toString());
        loginPage.inputToPasswordField(dataFromExelForValidLoginTest.get("pass").toString());
        loginPage.clickSubmitButton();
//        loginPage.loginUser(login, pass);

        checkAcceptanceCriteria("Avatar is not present", homePage.isAvatarpresent(), true);
        checkAcceptanceCriteria("Title is not expected", homePage.getTitle(), "Учет запчастей");
    }


}
