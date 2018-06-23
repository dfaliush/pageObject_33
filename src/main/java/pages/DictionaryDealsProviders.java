package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DictionaryDealsProviders extends HomePage {

    String xpathOfAListOfTheElements = ".//table[@id='device_list']/tbody/tr";

    @FindBy(xpath = ".//i[@class='fa fa-plus']")
    WebElement addButton;

    public DictionaryDealsProviders(WebDriver driver) {

        super(driver);
    }

    public WebElement selectARowByIndex(int numberOfARow){
        try {
            String index =  String.valueOf(numberOfARow);
            return driver.findElement(
                    By.xpath(xpathOfAListOfTheElements + "[" + index +"]"));
        } catch (Exception e) {
            Assert.fail("Can't get a row with index "+ numberOfARow);
            return null;
        }
    }

    public String getTextFromARow(int numberOfARow, int numberOfAColumn){
        try {
            String indexOfARow =  String.valueOf(numberOfARow);
            String indexOfAColumn =  String.valueOf(numberOfAColumn);
            return driver.findElement(
                    By.xpath(xpathOfAListOfTheElements
                            + "[" + indexOfARow +"]/td[" + indexOfAColumn + "]")).getText();
        } catch (Exception e) {
            Assert.fail("Can't get a text. index-"+ numberOfARow + ", column-" + numberOfAColumn);
            return null;
        }
    }

    public void pressAddButton(){
        addButton.click();
    }

    public int numberOfRowsInATable(){
        return driver.findElements(By.xpath(xpathOfAListOfTheElements)).size();
    }
}
