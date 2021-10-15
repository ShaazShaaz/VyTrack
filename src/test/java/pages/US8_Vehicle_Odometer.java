package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.VyTrackUtil;

public class US8_Vehicle_Odometer {

    public US8_Vehicle_Odometer(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public WebElement chooseModule(String module) {

        WebElement moduleName = Driver.getDriver().findElement(By.xpath("//div[@id=\"main-menu\"]/ul/li/a/span[contains(text(),'" + module + "')]"));
        return moduleName;
    }

    @FindBy (xpath="//li/a/span[.='Vehicle Odometer']")
    public static WebElement VehicleOdometer;

    @FindBy (xpath="//div/a[@title='Create Vehicle Odometer']")
    public static WebElement CreateOdometer;

    @FindBy (xpath="//div/input[contains(@id,'OdometerValue')]")
    //div/input[contains(@id,'OdometerValue')]
    //ul[@class='dropdown-menu dropdown-menu-level-1 menu menu-level-1']//span[.='Vehicle Odometer']
    public static WebElement OdometerValue;

    @FindBy (xpath = "//div/input[contains(@id,'custom_entity_type_Driver')]")
    public static WebElement DriverName;

    @FindBy (xpath="//div[@class='controls']/span")
    public static WebElement DateBox;

    @FindBy (xpath="//*[@id=\"ui-datepicker-div\"]//tr[3]/td[5]/a")
    public static WebElement Date;

    @FindBy (xpath="//div/button[@class='btn btn-success action-button']")
    public static WebElement Save;

    @FindBy(className = "datepicker-input")
    public WebElement datePicker;

    @FindBy(className = "message")
    public WebElement successMessage;

    @FindBy(xpath = "(//div[@class='message'])[2]")
    public WebElement failMessage;

    public void fillOutForm(){
        Faker faker=new Faker();
        VyTrackUtil.waitFor(2);
        OdometerValue.sendKeys(faker.number().digits(8));
        randomDate();
        DriverName.sendKeys(faker.name().fullName());
        VyTrackUtil.waitFor(3);
        Save.click();
    }

    public void randomDate(){
        // list of month (Jan --Dec) 12 element
        // random number 5
        //list.get(5) --- MAy
        Faker faker =new Faker();
        int day = faker.number().numberBetween(1, 28);
        int year = faker.number().numberBetween(2021, 2025);
        datePicker.sendKeys("Nov "+day+", "+year+""+ Keys.TAB);
    }










}

