package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

//    By sideBarMenuGlavnaya = By.xpath(".//*[@id='dashboard']//span");
//    By sideBarDictionary = By.xpath(".//*[@id='dictionary']//span[text()='Словари']" +
//            "/../i[@class='fa fa-angle-left pull-right']");
//    By sideBarDictionaryApparat = By.xpath(".//a[@href='/dictionary/apparat']");
//    By sideBarDictionaryWorkers = By.xpath(".//*[@id='workers']/a");
//    By sideBarDictionarySpareType= By.xpath(".//*[@id='spareType']/a");
//    By sideBarDictionarySpares= By.xpath(".//*[@id='spares']/a");
//    By sideBarDictionaryProviders= By.xpath(".//*[@id='prov_cus']/a");
//    By sideBarDictionaryDealsType= By.xpath(".//*[@id='deal_type']/a");
//    By sideBarServiceApparat= By.xpath(".//*[@id='service_apparat']//" +
//            "span[text()='Обслуживание']");

//    By sideBarInstall= By.xpath(".//*[@id='installation']//span[text()='Установка']");
//    By sideBarDeals= By.xpath(".//*[@id='deal']//span[text()='Сделки']");
//    By sideBarReport= By.xpath(".//*[@id='report']//span[text()='Отчет']");
//    By homeButton= By.xpath(".//*[@href='/']");
//    By tableBase= By.xpath(".//div[@class='col-md-12']");
//    By addRow= By.xpath(".//a[@data-original-title='Add']");
//    By tableBody= By.xpath(".//table[@id='device_list']/tbody");

    @FindBy(xpath = ".//*[@id='dashboard']//span")
    WebElement sideBarMenuGlavnaya;


    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']//span[text()='Словари']" +
            "/../i[@class='fa fa-angle-left pull-right']")
    WebElement sideBarDictionary;

    @FindBy(xpath = ".//a[@href='/dictionary/apparat']")
    WebElement sideBarDictionaryApparat;

    @FindBy(xpath = ".//*[@id='workers']/a")
    WebElement sideBarDictionaryWorkers;

    @FindBy(xpath = ".//*[@id='spareType']/a")
    WebElement sideBarDictionarySparesTypes;

    @FindBy(xpath = ".//*[@id='spares']/a")
    WebElement sideBarDictionarySpares;

//    @FindBy(xpath = ".//*[@id='prov_cus']/a")
    @FindBy(xpath = ".//a[@href='/dictionary/providers']")
    WebElement sideBarDictionaryProviders;

    @FindBy(xpath = ".//h3[contains(text(), 'Список контрагентов')]")
    WebElement customersPageSubtitle;

    @FindBy(xpath = ".//*[@id='deal_type']/a")
    WebElement sideBarDictionaryDealsType;

    @FindBy(xpath = ".//*[@id='service_apparat']//" +
            "span[text()='Обслуживание']")
    WebElement sideBarServiceApparat;

    @FindBy(xpath = ".//*[@id='installation']//span[text()='Установка']")
    WebElement sideBarInstall;

    @FindBy(xpath = ".//*[@id='deal']//span[text()='Сделки']")
    WebElement sideBarDeals;

    @FindBy(xpath = ".//*[@id='report']//span[text()='Отчет']")
    WebElement sideBarReport;

    @FindBy(xpath = ".//*[@href='/']")
    WebElement homeButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAvatarpresent(){
        return uiActions.isVisibleAbdEnabled(avatar);
    }


    public void pressSideBarDictionary(){
        try {
            uiActions.clickToElement(sideBarDictionary);
            log.info("sideBarDictionary  - clicked");
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDictionary"); ;
        }
    }

    public void pressSideBarDictionaryApparat(){
        try {
            uiActions.clickToElement(sideBarDictionaryApparat);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDictionaryApparat"); ;
        }
    }

    public void pressSideBarDictionaryWorkers(){
        try {
            uiActions.clickToElement(sideBarDictionaryWorkers);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDictionaryWorkers"); ;
        }
    }

    public void pressSideBarDictionaryZap4astiTypes(){
        try {
            uiActions.clickToElement(sideBarDictionarySparesTypes);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDictionarySparesTypes"); ;
        }
    }

    public void pressSideBarDictionaryZap4asti(){
        try {
            uiActions.clickToElement(sideBarDictionarySpares);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDictionarySpares"); ;
        }
    }

    public void pressSideBarDictionaryProviders(){
        try {
            uiActions.clickToElement(sideBarDictionaryProviders);
            Assert.assertEquals("Not a Customers page", customersPageSubtitle.getText(), "Список контрагентов");
            log.info("pressSideBarDictionaryProviders  - successfully");
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDictionaryProviders"); ;
        }
    }

    public void pressSideBarDictionaryDealsType(){
        try {
            uiActions.clickToElement(sideBarDictionaryDealsType);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDictionaryDealsType"); ;
        }
    }

    public void pressSideBarServiceApparat(){
        try {
            uiActions.clickToElement(sideBarServiceApparat);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarServiceApparat"); ;
        }
    }

    public void pressSideBarInstall(){
        try {
            uiActions.clickToElement(sideBarInstall);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarInstall"); ;
        }
    }

    public void pressSideBarDeals(){
        try {
            uiActions.clickToElement(sideBarDeals);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarDeals"); ;
        }
    }

    public void pressSideBarReport(){
        try {
            uiActions.clickToElement(sideBarReport);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarReport"); ;
        }
    }

    public void pressHomeButton(){
        try {
            uiActions.clickToElement(homeButton);
        } catch (Exception e) {
            Assert.fail("can't click on element homeButton"); ;
        }
    }

    public void pressMainButton(){
        try {
            uiActions.clickToElement(sideBarMenuGlavnaya);
        } catch (Exception e) {
            Assert.fail("can't click on element sideBarMenuGlavnaya"); ;
        }
    }


}
