package suits;

import loginTest.InvalidTestWithParam;
import loginTest.InvalidTestWithParamFromExel;
import loginTest.ValidTest;
import loginTest.ValidTestWithParamFromExel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidTest.class,
        InvalidTestWithParam.class,
        InvalidTestWithParamFromExel.class,
        ValidTestWithParamFromExel.class
})

public class SuiteLogin {

}
