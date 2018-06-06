package pages;

import libs.UIActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver driver;
    Logger log;
    UIActions uiActions;

    public ParentPage(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(getClass());
        this.uiActions = new UIActions(driver);
    }

}
