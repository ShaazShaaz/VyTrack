package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class VyTrackUtil {


    public void login(String username){
        WebElement loginBox=Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        loginBox.sendKeys(username);
        WebElement passwordBox=Driver.getDriver().findElement(By.cssSelector("#prependedInput2"));
        passwordBox.sendKeys(ConfigReader.read("password"));
        WebElement loginBtn=Driver.getDriver().findElement(By.cssSelector("#_submit"));
        loginBtn.click();
    }

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

    public void logOut(){
        WebElement logOutDrop=Driver.getDriver().findElement(By.id("user-menu"));
        logOutDrop.click();
        Driver.getDriver().findElement(By.xpath("//a[.='Logout']")).click();
    }

    


}
