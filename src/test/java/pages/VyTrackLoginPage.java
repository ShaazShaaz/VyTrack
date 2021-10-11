package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class VyTrackLoginPage {

    @FindBy (css = "#prependedInput" )
    public WebElement loginBox;

    @FindBy (css = "#prependedInput2" )
    public WebElement passwordBox;

    @FindBy (css = "#_submit" )
    public WebElement loginBtn;

    @FindBy (id = "user-menu" )
    public static WebElement logoutDrop;

    @FindBy (xpath = "//a[.='Logout']")
    public static WebElement logoutBtn;


    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void openVyTrackApp(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    public void login(String username){
        loginBox.sendKeys(username);
        passwordBox.sendKeys(ConfigReader.read("password"));
        loginBtn.click();
    }

    public void logOut(){
        // Open dropdown box
        logoutDrop.click();
        // Click "Logout" button
        logoutBtn.click();
    }
}
