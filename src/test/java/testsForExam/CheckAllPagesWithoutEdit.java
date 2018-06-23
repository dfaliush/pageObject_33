package testsForExam;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;


public class CheckAllPagesWithoutEdit extends ParentTest{

    public CheckAllPagesWithoutEdit(String browser) {
        super(browser);
    }

    @Before
    public void seTUp() {
        if (setUpIsDone) {
            return;
        }
        // do the setup
        loginPage.loginUser("student", "909090");
        setUpIsDone = true;
    }

    //@Ignore
    @Test
    public void checkDictionaryAllPages() {
        Boolean isZagolovokCorrect = false;
        homePage.pressSideBarDictionary();

        homePage.pressSideBarDictionaryApparat();
        isZagolovokCorrect = apparatPage.isZagolovokContains("Аппарат", true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);


        homePage.pressSideBarDictionaryWorkers();
        isZagolovokCorrect = workersPage.isZagolovokContains("Сотрудники",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);

        homePage.pressSideBarDictionaryZap4astiTypes();
        isZagolovokCorrect = spareTypes.isZagolovokContains("Типы запчастей",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);

        homePage.pressSideBarDictionaryZap4asti();
        isZagolovokCorrect = spare.isZagolovokContains("Запчасти", true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);

        homePage.pressSideBarDictionaryProviders();
        isZagolovokCorrect = dealsProviders.isZagolovokContains("Стороны сделок",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);

        homePage.pressSideBarDictionaryDealsType();
        isZagolovokCorrect = dealsProviders.isZagolovokContains("Типы сделок",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);

    }

    //@Ignore
    @Test
    public void checkSideBarServiceApparat() {
        homePage.pressSideBarServiceApparat();
        Boolean isZagolovokCorrect = servicePage.isZagolovokContains("Обслуживание",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);
    }

    //@Ignore
    @Test
    public void checkSideBarInstall() {
        homePage.pressSideBarInstall();
        Boolean isZagolovokCorrect = installPage.isZagolovokContains("Установка",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);
    }

    //@Ignore
    @Test
    public void checkSideBarDeals() {
        homePage.pressSideBarDeals();
        Boolean isZagolovokCorrect = dealsPage.isZagolovokContains("Сделки",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);
    }

    //@Ignore
    @Test
    public void checkSideBarReport() {
        homePage.pressSideBarReport();
        Boolean isZagolovokCorrect = reportPage.isZagolovokContains("Отчет о продажах",true);
        checkAcceptanceCriteria("The Page title isn't contains expected title",
                isZagolovokCorrect, true);
    }
}
