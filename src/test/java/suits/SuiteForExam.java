package suits;

import loginTest.InvalidTestWithParam;
import loginTest.InvalidTestWithParamFromExel;
import loginTest.ValidTest;
import loginTest.ValidTestWithParamFromExel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testsForExam.CheckAllPagesWithoutEdit;
import testsForExam.DealsProviders;
import testsForExam.InstallPageTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CheckAllPagesWithoutEdit.class,
        DealsProviders.class,
        InstallPageTests.class
})

public class SuiteForExam {
}
