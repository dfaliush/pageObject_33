package loginTest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)

public class InvalidTestWithParam  extends ParentTest{

    String login, pass;

    public InvalidTestWithParam(String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
    }


    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "student", "906090"},
                {"chrome", "tudent", "909090"}
        });
    }

    @Ignore
    @Test
    public void invalidLogin(){
        loginPage.loginUser(login, pass);

        checkAcceptanceCriteria("Title not match", loginPage.getTitle(), "Account of spare:Авторизация");
    }


}
