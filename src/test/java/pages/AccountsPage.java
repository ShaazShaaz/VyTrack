package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AccountsPage {
    /*
    As a user, I should be able to select accounts from accounts page
    AC #1: user can select all the accounts by checking the first checkbox
           Given user is on the homePage
           When user select “Accounts” under Customers module
           And user checks the first checkbox
           Then verify all the checkbox is checked
    AC #2: user can select any account
           Given user is on the homePage
           When user select “Accounts” under Customers module
           And user checks any account’s checkbox
           Then verify the checkbox is checked
     */
    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[3]/div/div/ul/li[3]/a/span")
    public WebElement accountBtn;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")
    public WebElement accountBtnDriver;

    @FindBy(xpath = "//button/input[@type='checkbox']")
    public WebElement firstCheckbox;

    @FindBy(xpath = "//td/input[@type='checkbox']")
    public List <WebElement> allCheckbox;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[3]/a/span")
    public WebElement customerModule;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/a/span")
    public WebElement customerModuleDriver;

    @FindBy(xpath = "//tr[@class='grid-row row-click-action'][2]//input")
    public WebElement thirdCheckBox;


    public AccountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // User(Manager) is on homepage, and hovers over Customer module, selects Accounts option
    public void selectAccountsBtn_Managers(){

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(customerModule).perform();
        accountBtn.click();
    }

    // User(Driver) is on homepage, and hovers over Customer module, selects Accounts option
    public void selectAccountsBtn_Drivers(){

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(customerModuleDriver).perform();
        accountBtnDriver.click();
    }

    // user(All) clicks the topmost checkbox
    public void selectAllCheckbox(){
        firstCheckbox.click();
    }

    // user(Driver) clicks on one of the checkboxes
    public void selectOneCheckbox_Drivers(){
        thirdCheckBox.click();

    }

    // user(Manager) clicks on one of the checkboxes
    public void selectOneCheckbox_Managers() {
        thirdCheckBox.click();
    }
}
