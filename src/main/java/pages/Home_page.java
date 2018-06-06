package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page extends ParentPage {

    By sideBarMenuGlavnaya = By.xpath(".//*[@id='dashboard']//span");
    By sideBarDictionary = By.xpath(".//*[@id='dictionary']//span[text()='Словари']" +
            "/../i[@class='fa fa-angle-left pull-right']");
    By sideBarDictionaryApparat = By.xpath(".//a[@href='/dictionary/apparat']");
    By sideBarDictionaryWorkers = By.xpath(".//*[@id='workers']/a");
    By sideBarDictionarySpareType= By.xpath(".//*[@id='spareType']/a");
    By sideBarDictionarySpares= By.xpath(".//*[@id='spares']/a");
    By sideBarDictionaryCustomers= By.xpath(".//*[@id='prov_cus']/a");
    By sideBarDictionaryDealsType= By.xpath(".//*[@id='deal_type']/a");
    By sideBarDictionaryServiceApparat= By.xpath(".//*[@id='service_apparat']//" +
            "span[text()='Обслуживание']");

    By sideBarDictionaryInstall= By.xpath(".//*[@id='installation']//span[text()='Установка']");
    By sideBarDictionaryDeals= By.xpath(".//*[@id='deal']//span[text()='Сделки']");
    By sideBarDictionaryReport= By.xpath(".//*[@id='report']//span[text()='Отчет']");
    By homeButton= By.xpath(".//*[@href='/']");
    By tableBase= By.xpath(".//div[@class='col-md-12']");
    By addRow= By.xpath(".//a[@data-original-title='Add']");
    By tableBody= By.xpath(".//table[@id='device_list']/tbody");


    public Home_page(WebDriver driver) {
        super(driver);
    }


    public WebElement findSideBarGlavnaya(){

        try {
            return driver.findElement(sideBarMenuGlavnaya);
        } catch (Exception e) {
            log.error("can't find an element");
            return null;
        }
    }
}
