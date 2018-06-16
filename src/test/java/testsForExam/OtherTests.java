package testsForExam;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)


public class OtherTests extends ParentTest{
    String day;
    String month;
    String year;
    String hour;
    String minutes;
    String nameOfAnApparat;
    String worker;

    public OtherTests(String browser, String day, String month,
                      String year, String hour, String minutes,
                      String nameOfAnApparat, String worker) {
        super(browser);
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.nameOfAnApparat = nameOfAnApparat;
        this.worker = worker;

    }

    @Before
    public void before(){
        loginPage.loginUser("student", "909090");
        homePage.sideBarInstallClick();
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "17", "марта", "2018", "17", "45", "test1", "abc abc"},
                {"chrome", "18", "марта", "2015", "23", "59", "45", "tt tt tt"}
        });
    }

    //@Ignore
    @Test
    public void editTheFirstInstalledWork() {


        installPage.selectARowByIndex(1).click();


        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealDay(), day);
        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealMonth(), month);
        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealYear(), year);
        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealHour(), hour);
        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealMinutes(), minutes);

        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectInstallationApparat(), nameOfAnApparat);

        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectInstallationWorkers(), worker);
        editInstallPage.pressSaveButton();


        String expectedDate = String.format("%s.03.%s %s:%s", day, year, hour, minutes);

        checkAcceptanceCriteria
                ("The value of a date is not expected",
                        installPage.getTextFromARow
                                (1, 1), expectedDate);

        checkAcceptanceCriteria
                ("The value of a apparat is not expected",
                        installPage.getTextFromARow
                                (1, 2), nameOfAnApparat);

        checkAcceptanceCriteria
                ("The value of a worker is not expected",
                        installPage.getTextFromARow
                                (1, 3), worker);
    }

    //@Ignore
    @Test
    public void addARowToInstalledWorks(){
        int numberOfARowsBefore = installPage.numberOfRowsInATable();

        installPage.pressAddButton();

        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealDay(), day);
        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealMonth(), month);
        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealYear(), year);
        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealHour(), hour);

        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectDealMinutes(), minutes);


        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectInstallationApparat(), nameOfAnApparat);

        uiActions.selectItemInDropDownByVisibleText(
                editInstallPage.selectInstallationWorkers(), worker);
        editInstallPage.pressAddButton();


        int numberOfARowsAfter = installPage.numberOfRowsInATable();
        String expectedDate = String.format("%s.03.%s %s:%s", day, year, hour, minutes);

        checkAcceptanceCriteria
                ("The value of a rows is not increased",
                        numberOfARowsBefore +1, numberOfARowsAfter);

        checkAcceptanceCriteria
                ("The value of a date is not expected",
                        installPage.getTextFromARow
                                (numberOfARowsAfter, 1), expectedDate);

        checkAcceptanceCriteria
                ("The value of a apparat is not expected",
                        installPage.getTextFromARow
                                (numberOfARowsAfter, 2), nameOfAnApparat);

        checkAcceptanceCriteria
                ("The value of a worker is not expected",
                        installPage.getTextFromARow
                                (numberOfARowsAfter, 3), worker);
    }

    @Test
    public void removeTheLastRowInATable(){
        int numberOfARowsBeforeRemoving = installPage.numberOfRowsInATable();
        installPage.selectARowByIndex(numberOfARowsBeforeRemoving).click();
        editInstallPage.pressRemoveButton();

        int numberOfARowsAfterRemoving = installPage.numberOfRowsInATable();

        checkAcceptanceCriteria
                ("The value of a rows is not increased",
                        numberOfARowsBeforeRemoving -1, numberOfARowsAfterRemoving);
    }

}
