package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserCommonArea {
    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li/a/span[normalize-space(.)='Fleet']")
    private WebElement fleetModule;

    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li/a/span[contains(text(),'Customers')]")
    private WebElement customersModule;

    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li/a/span[contains(text(),'Activities')]")
    private WebElement activitiesModule;

    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li/a/span[contains(text(),'System')]")
    private WebElement systemModule;

    @FindBy(xpath = "//i[@title='Get help']")
    private WebElement oroGetHelp;

    @FindBy(xpath = "//h1/a[@title='Fleet Management']")
    private WebElement fleetMngHomePage;

    public UserCommonArea(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
