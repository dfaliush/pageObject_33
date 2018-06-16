package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Utils {
    private Logger log;

    public Utils(){
        log = Logger.getLogger(getClass());
    }

    /**
     * Taking screenshot into .//target// + pathToScreenShot
     * @param pathToScreenShot
     * @param driver
     */
    public void screenShot(String pathToScreenShot, WebDriver driver)
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(scrFile, new File(pathToScreenShot));
            log.info("ScreenShot: " + pathToScreenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String changeTheValueOfMinutesByOne(String stringValueAsString){
        try {
            int minutes = Integer.parseInt(stringValueAsString);
            if (minutes < 59){
                minutes ++;
                return String.valueOf(minutes);
            }else if (minutes == 59){
                minutes --;
                return String.valueOf(minutes);
            }else {
                return "Oops! Not correct value. Your value is " + stringValueAsString;
            }
        } catch (NumberFormatException e) {
            log.error("Oops! changeTheValueOfMinutesByOne");
            return "Oops! Not correct value. Your value is " + stringValueAsString;
        }

    }

}
