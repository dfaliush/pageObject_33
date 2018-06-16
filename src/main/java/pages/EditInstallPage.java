package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditInstallPage extends HomePage {

    By tableWithDropDowns = By.xpath(".//*[@class='col-sm-10']//select");
//    By tableWithApparats = By.xpath(".//select[@id='installation_apparat']");

    @FindBy(xpath = ".//select[@id='installation_apparat']")
    protected WebElement tableWithApparats;

    @FindBy(xpath = ".//select[@id='installation_worker']")
    protected WebElement tableWithWorker;

    @FindBy(xpath = ".//button[contains(text(), 'Сохранить')]")
    protected WebElement saveButton;

    @FindBy(xpath = ".//button[contains(text(), 'Создать')]")
    protected WebElement addButton;

    @FindBy(xpath = ".//button[contains(text(), 'Удалить')]")
    protected WebElement removeButton;


    public EditInstallPage(WebDriver driver) {
        super(driver);
    }

    private WebElement selectDealDateType(int index){
        return driver.findElements(tableWithDropDowns ).get(index);
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

    public WebElement selectInstallationApparat(){
        return tableWithApparats;
    }

    public WebElement selectInstallationWorkers(){
        return tableWithWorker;
    }

    public void pressSaveButton(){
        saveButton.click();
    }

    public void pressAddButton(){
        addButton.click();
    }

    public void pressRemoveButton(){
        log.info("The row was removed from a table");
        removeButton.click();
    }
}
