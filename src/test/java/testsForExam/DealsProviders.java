package testsForExam;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.DictionaryDealsProviders;
import parentTest.ParentTest;

//@RunWith(value = Parameterized.class)


public class DealsProviders extends ParentTest{


    public DealsProviders(String browser) {
        super(browser);
    }

    @Before
    public void before(){
        loginPage.loginUser("student", "909090");
        homePage.pressSideBarDictionary();
        homePage.pressSideBarDictionaryProviders();
    }

    //@Ignore
    @Test
    public void editTheFirstProvider() {
        dealsProviders.selectARowByIndex(1).click();
        editDealsProviders.setProCustName("Вася");
        editDealsProviders.setProCustAddress("Из Дерибасовской");
        editDealsProviders.setProCustPhone("02");
        editDealsProviders.setProCustIsFL(true);
        editDealsProviders.setProCustIsOurFirm(false);
        editDealsProviders.pressSaveButton();

        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(1, 1),
                "Вася");
        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(1, 2),
                "Из Дерибасовской");
        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(1, 3),
                "02");
        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(1, 4),
                "1");
    }

    //@Ignore
    @Test
    public void addARowToProviders() throws InterruptedException {
        int numberOfARowsBefore = dealsProviders.numberOfRowsInATable();

        dealsProviders.pressAddButton();
        editDealsProviders.setProCustName("Я, Олег Ляшко");
        Thread.sleep(1000);
        editDealsProviders.setProCustAddress("з Верховної Ради");
        Thread.sleep(1000);
        editDealsProviders.setProCustPhone("не маю телефона");
        Thread.sleep(1000);
        editDealsProviders.setProCustIsFL(false);
        Thread.sleep(1000);
        editDealsProviders.setProCustIsOurFirm(false);
        editDealsProviders.pressAddButton();

        int numberOfARowsAfter = dealsProviders.numberOfRowsInATable();

        checkAcceptanceCriteria
                ("The value of a rows is not increased",
                        numberOfARowsBefore +1, numberOfARowsAfter);

        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(numberOfARowsAfter, 1),
                "Я, Олег Ляшко");
        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(numberOfARowsAfter, 2),
                "з Верховної Ради");
        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(numberOfARowsAfter, 3),
                "не маю телефона");
        checkAcceptanceCriteria("",
                dealsProviders.getTextFromARow(numberOfARowsAfter, 4),
                "");
    }

    @Test
    public void removeTheLastRowInATable(){
        int numberOfARowsBeforeRemoving = dealsProviders.numberOfRowsInATable();
        dealsProviders.selectARowByIndex(numberOfARowsBeforeRemoving).click();
        editDealsProviders.pressRemoveButton();


        int numberOfARowsAfterRemoving = dealsProviders.numberOfRowsInATable();

        checkAcceptanceCriteria
                ("The value of a rows is not decreased",
                        numberOfARowsBeforeRemoving -1, numberOfARowsAfterRemoving);
    }


}
