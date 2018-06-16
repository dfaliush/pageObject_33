package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
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
//    By sideBarDictionaryCustomers= By.xpath(".//*[@id='prov_cus']/a");
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

    @FindBy(tagName = "h1")
    protected WebElement zagolovok;

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
    WebElement sideBarDictionarySpares;

    @FindBy(xpath = ".//*[@id='prov_cus']/a")
    WebElement sideBarDictionaryCustomers;

    @FindBy(xpath = ".//*[@id='deal_type']/a")
    WebElement sideBarDictionaryDealsType;

    @FindBy(xpath = ".//*[@id='service_apparat']//" +
            "span[text()='Обслуживание']")
    WebElement sideBarServiceApparat;

    @FindBy(xpath = ".//*[@id='installation']//span[text()='Установка']")
    WebElement sideBarInstall;

    @FindBy(xpath = ".//*[@id='deal']//span[text()='Сделки']")
    WebElement sideBarReport;

    @FindBy(xpath = ".//*[@href='/']")
    WebElement homeButton;

    @FindBy(xpath = ".//div[@class='col-md-12']")
    WebElement tableBase;


    @FindBy(xpath = ".//a[@data-original-title='Add']")
    WebElement addRow;

    @FindBy(xpath = ".//table[@id='device_list']/tbody")
    WebElement tableBody;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public WebElement findSideBarGlavnaya(){

        try {
            return sideBarMenuGlavnaya;
        } catch (Exception e) {
            log.error("can't find an element");
            return null;
        }
    }


    public void chechTitle(String title){
        Assert.assertEquals("Title not expected", getTitle(), title);
    }

    public void chechZagolovok(String zagolovokText){
        Assert.assertEquals("Zagolovok not expected",zagolovok.getText(), zagolovokText);
    }

    public boolean isAvatarpresent(){
        return uiActions.isVisibleAbdEnabled(avatar);
    }
}
