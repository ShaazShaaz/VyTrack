package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;
import utilities.Driver;

public class VyTrackLoginPage {

    @FindBy (css = "#prependedInput" )
    public static WebElement loginBox;

    @FindBy (css = "#prependedInput2" )
    public static WebElement passwordBox;

    @FindBy (css = "#_submit" )
    public static WebElement loginBtn;

    @FindBy (id = "user-menu" )
    public static WebElement logoutDrop;

    @FindBy (xpath = "//a[.='Logout']")
    public static WebElement logoutBtn;


    public static void openVyTrackApp(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    public static void login(String username){
        loginBox.sendKeys(username);
        passwordBox.sendKeys(ConfigReader.read("password"));
        loginBtn.click();
    }

    public static void logOut(){
        // Open dropdown box
        logoutDrop.click();
        // Click "Logout" button
        logoutBtn.click();
    }
}
