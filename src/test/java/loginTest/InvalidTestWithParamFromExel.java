package loginTest;


import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


@RunWith(value = Parameterized.class)

public class InvalidTestWithParamFromExel extends ParentTest{

    private String login, pass;

    public InvalidTestWithParamFromExel(String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
    }


    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(
                ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Ignore
    @Test
    public void invalidLogin() {
        loginPage.loginUser(login, pass);
        checkAcceptanceCriteria("Title is not match", loginPage.getTitle(), "Account of spare:Авторизация");
    }

}
