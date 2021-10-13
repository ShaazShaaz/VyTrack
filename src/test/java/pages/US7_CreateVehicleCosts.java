package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

/*
AC #1: users are able to create vehicle costs.
Given user is on the homePage
When user select “Vehicle Costs” under Fleet module
And user click “Create Vehicle Costs” button
When user fill out general information and click “Save and Close” button
Then verify “Entity saved” confirm message
 */

public class US7_CreateVehicleCosts {

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createVehicleCost;

    @FindBy(xpath = "*[@id='select2-drop']/ul[2]/li[1]/div")
    public WebElement costType;

    @FindBy(xpath = "//input[contains(@id,'TotalPrice')]")
    public WebElement totalPrice;

    @FindBy(xpath = "*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")
    public WebElement selectDate;

    @FindBy(id = "custom_entity_type_CostDescriptions-uid-5e93dcd3203f2")
    public WebElement costDescription;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseBtn;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addChassisBtn;

    @FindBy(xpath = "//input[@name='oro_event_form[title]']")
    public WebElement addLicenseBtn;

    @FindBy(xpath = "//div[@class='flash-messages-holder']")
    public WebElement confirmMessage;

    @FindBy(xpath = "//a[@href='#scroll-2-61'][1]")
    public WebElement activity;


    public void clickToCreateVehicleCost() throws InterruptedException {
        Thread.sleep(1000);
        createVehicleCost.click();
    }

    public void theCostInfo() throws InterruptedException {
        Thread.sleep(1000);
        Select selectCanBeRequested = new Select(costType);
        selectCanBeRequested.selectByVisibleText("Road Assistance");
        totalPrice.sendKeys("1200");
        selectDate.click();
        selectDate.click();
        costDescription.sendKeys("Road Assistance Cost Created");
    }

    public void clickAddChassis() throws InterruptedException {
        Thread.sleep(1000);
        addChassisBtn.click();
    }

    public void clickAddLicense() throws InterruptedException {
        Thread.sleep(1000);
        addLicenseBtn.click();
    }

    public void clickSaveAndClose() throws InterruptedException {
        Thread.sleep(1000);
        saveAndCloseBtn.click();
    }
    
}