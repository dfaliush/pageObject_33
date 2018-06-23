package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DictionaryEditDealsProviders extends HomePage {

    @FindBy(xpath = ".//button[contains(text(), 'Сохранить')]")
    protected WebElement saveButton;

    @FindBy(xpath = ".//button[contains(text(), 'Создать')]")
    protected WebElement addButton;

    @FindBy(xpath = ".//button[contains(text(), 'Удалить')]")
    protected WebElement removeButton;

    @FindBy(xpath = ".//input[@id='prov_cus_proCustName']")
    protected WebElement proCustName;

    @FindBy(xpath = ".//input[@id='prov_cus_proCustAddress']")
    protected WebElement proCustAddress;

    @FindBy(xpath = ".//input[@id='prov_cus_proCustPhone']")
    protected WebElement proCustPhone;

    @FindBy(xpath = ".//input[@id='prov_cus_proCustIsFl']")
    protected WebElement checkboxIsFL;

    @FindBy(xpath = ".//input[@id='prov_cus_isOurFirm']")
    protected WebElement checkboxIsOurFirm;

    public DictionaryEditDealsProviders(WebDriver driver) {
        super(driver);
    }

    public void pressSaveButton(){uiActions.clickToElement(saveButton);}

    public void pressAddButton(){uiActions.clickToElement(addButton);}

    public void pressRemoveButton(){
        uiActions.clickToElement(removeButton);
        log.info("The row should be removed from a table");
    }

    public void setProCustName(String name){
        uiActions.inputToTextField(proCustName, name);
        log.info("The name is: "+ name);
    }
    public void setProCustAddress(String address){
        uiActions.inputToTextField(proCustAddress, address);
        log.info("The address is: "+ address);
    }
    public void setProCustPhone(String phone){
        uiActions.inputToTextField(proCustPhone, phone);
        log.info("The phone is: "+ phone);
    }
    public void setProCustIsFL(Boolean result){
        uiActions.tickCheckBox(checkboxIsFL, result);
        log.info("Is a private person? : "+ result);
    }
    public void setProCustIsOurFirm(Boolean result){
        uiActions.tickCheckBox(checkboxIsOurFirm, result);
    }
}
