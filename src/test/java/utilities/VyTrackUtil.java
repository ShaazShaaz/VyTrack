package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VyTrackUtil {

    public void openVyTrackApp(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    public static void login(String username){
        WebElement loginBox=Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        loginBox.sendKeys(username);
        WebElement passwordBox=Driver.getDriver().findElement(By.cssSelector("#prependedInput2"));
        passwordBox.sendKeys(ConfigReader.read("password"));
        WebElement loginBtn=Driver.getDriver().findElement(By.cssSelector("#_submit"));
        loginBtn.click();
    }

    


}
