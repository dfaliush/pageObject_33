package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditSdelkiPage extends ParentPage {

    By tableWithDropDowns = By.xpath(".//*[@class='col-sm-10']//select");

    public EditSdelkiPage(WebDriver driver) {
        super(driver);
    }

    private WebElement selectDealDateType(int index){
        return driver.findElements(tableWithDropDowns).get(index);
    }

    public WebElement  selectDealDay(){
        return selectDealDateType(0);
    }

    public WebElement  selectDealMonth(){
        return selectDealDateType(1);
    }
    public WebElement  selectDealYear(){
        return selectDealDateType(2);
    }
    public WebElement  selectDealHour(){
        return selectDealDateType(3);
    }
    public WebElement  selectDealMinutes(){
        return selectDealDateType(4);
    }

}
