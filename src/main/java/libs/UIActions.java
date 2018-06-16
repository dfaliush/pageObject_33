package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions {
    Logger log;
    WebDriver driver;
    JavascriptExecutor jse;
    WebDriverWait webDriverWait;

    public UIActions(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(getClass());
        jse = (JavascriptExecutor)driver;
        webDriverWait = new WebDriverWait(driver, 20);
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
    public void clickToElement(WebElement element){
        try {
            // Явное ожидание
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            // Refactoring. driver.findElement(element).click();
            element.click();
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
    public void inputToTextField(WebElement element, String value){
        try {
            element.clear();
            element.sendKeys(value);
            log.info(element + ": clicked " );
        } catch (Exception e) {
            log.error("Can't input '" + value +" ' to an element " + element);
        }
    }

    public void tickCheckBox(WebElement element, Boolean isStatusResult){

        Boolean currentStatusResult = element.isSelected();
        if((currentStatusResult && !isStatusResult) ||  (!currentStatusResult && isStatusResult)){

            element.click();
        }

    }

    public void selectDropDownElemByValue(WebElement webElement, String value){
        webElement.findElement(By.xpath(".//option[contains(text(),'" + value + "')]")).click();
    }


    public boolean selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect){
        try {
            Select optionsFromDD = new Select(elementDD);
            optionsFromDD.selectByVisibleText(textForSelect);
            log.info(textForSelect + " was selected in DD");
            return true;
        } catch (Exception e) {
            log.error("Can not work with element");
            Assert.fail("Can not work with element");
            return false;
        }
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

    public String getTextFromElement(WebElement element){
        try {
            return element.getText();
        } catch (Exception e) {
            log.error("Something went wrong");
            throw new AssertionError("getTextFromElement: Ooops!");
        }
    }

    public void scrollDownInPixels(int pixels){

        try {
            jse.executeScript("scroll(0,"+ pixels +  ") ;");
        } catch (Exception e) {
            log.error("JavascriptExecutor is broken");
            throw new AssertionError("scrollDownInPixels: Ooops!");
        }
    }

    public void scrollUpInPixels(int pixels){
        try {
            jse.executeScript("scroll(0,-"+ pixels +  ") ;");
        } catch (Exception e) {
            log.error("JavascriptExecutor is broken");
            throw new AssertionError("scrollUpInPixels: Ooops!");
        }
    }


    public void scrollHorizontal(WebElement element){
        try {
            jse.executeScript("arguments[0].scrollIntoView();",element );

        } catch (Exception e) {
            log.error("JavascriptExecutor is broken");
            throw new AssertionError("scrollHorizontal: Ooops!");
        }
    }

    public String getCurrentUrl(){
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            log.error("Can't get current url");
            throw new AssertionError("getCurrentUrl: Ooops!");
        }
    }

}
