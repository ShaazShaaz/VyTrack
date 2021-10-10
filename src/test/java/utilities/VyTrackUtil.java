package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class VyTrackUtil {

    public static void takeSnapShot(WebDriver driver, String fileWithPath)throws Exception {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public static void waitFor(int seconds){
        /*
        a method to pause the thread for certain seconds
        parameter- seconds
         */
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
               e.printStackTrace();
        }
    }
}
