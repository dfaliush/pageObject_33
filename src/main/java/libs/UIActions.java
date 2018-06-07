package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIActions {
    Logger log;
    WebDriver driver;

    public UIActions(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(getClass());
    }

    /**
     * Method which click to element by ID
     * @param element
     */
    public void clickToElementById(String element){
        try {
            driver.findElement(By.id(element)).click();
            log.info("Element was clicked");
        } catch (Exception ex) {
            log.error("Can't click to an element");
        }
    }

    /**
     * Method which click to element
     * @param element
     */
    public void clickToElement(By element){
        try {
            driver.findElement(element).click();
            log.info(element + ": clicked " );
        } catch (Exception ex) {
            log.error("Can't click to an element " + element);
        }
    }

    /**
     * Method "Input value" to web element
     * @param element
     * @param value
     */
    public void inputToTextField(By element, String value){
        try {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(value);
            log.info(element + ": clicked " );
        } catch (Exception e) {
            log.error("Can't input '" + value +" ' to an element " + element);
        }
    }

    public void tickCheckBox(By element, Boolean isStatusResult){

        Boolean currentStatusResult = driver.findElement(element).isSelected();
        if((currentStatusResult && !isStatusResult) ||  (!currentStatusResult && isStatusResult)){

            driver.findElement(element).click();
        }

    }

    public void selectDropDownElemByValue(WebElement webElement, String value){
        webElement.findElement(By.xpath(".//option[contains(text(),'" + value + "')]")).click();
    }

    public boolean isVisibleAbdEnabled(WebElement element){
        try {

            if (element.isDisplayed() && element.isEnabled()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Something went wrong");
            throw new AssertionError("isVisibleAbdEnabled: Ooops!");
        }
    }
}
