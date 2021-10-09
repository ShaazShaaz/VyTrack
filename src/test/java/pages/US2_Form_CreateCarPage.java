package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.VyTrackUtil;

import static utilities.Driver.*;

import java.util.ArrayList;
import java.util.Arrays;

public class US2_Form_CreateCarPage {

    public US2_Form_CreateCarPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@type ='text'][@name='custom_entity_type[LicensePlate]']")
    public WebElement licencePlateBox;

    public WebElement checkboxTag(String tagName) {
        ArrayList<String> tags = new ArrayList<>(Arrays.asList("Junior", "Senior", "Employee Car", "Purchased", "Compact", "Sedan", "Convertible"));
        int index = tags.indexOf(tagName);
        return getDriver().findElement(By.xpath("//input[@type='checkbox'][@data-name='field__"+index+"']"));
    }

    @FindBy(xpath = "//input[@name='custom_entity_type[Driver]']")
    public WebElement driverBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[Location]']")
    public WebElement locationBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[ChassisNumber]']")
    public WebElement chassisNumbBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[ModelYear]']")
    public WebElement modelYearBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[LastOdometer]']")
    public WebElement lastOdometerBox;

    @FindBy(xpath = "//input[contains(@id, 'ImmatriculationDate') and contains(@placeholder, 'Choose a date')]")
    public WebElement immatriculationBox;

    public void immatriculationDateSelection(int day, String month, String year ){

        WebElement monthDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        WebElement yearDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='"+day+"']")).click();
    }

    @FindBy(xpath = "//button[@data-handler='today']")
    WebElement todayBtn_Immatriculation;

    @FindBy(xpath = "//input[contains(@id, 'FirstContractDate') and contains(@placeholder, 'Choose a date')]")
    public WebElement firstContractBox;

    public void firstContractDateSelection(int day, String month, String year ){

        WebElement monthDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        WebElement yearDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='"+day+"']")).click();
    }

    @FindBy(xpath= "//input[@name='custom_entity_type[CatalogValue]']")
    public WebElement catalogValue;

    @FindBy(xpath = "//input[@name='custom_entity_type[SeatsNumber]']")
    public WebElement seatsNumberBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[DoorsNumber]']")
    public WebElement doorsNumbBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[Color]']")
    public WebElement colorBox;

    @FindBy(xpath = "//div[contains(@id, 'Transmission')]/following-sibling::select")
    public WebElement transmissionDropdown;

    @FindBy(xpath = "//div[contains(@id, 'FuelType')]/following-sibling::select")
    public WebElement fuelTypeDropdown;

    @FindBy(xpath = "//input[@name='custom_entity_type[CO2Emissions]']")
    public WebElement co2EmissionBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[Horsepower]']")
    public WebElement horsepowerBox;

    @FindBy(xpath= "//input[@name='custom_entity_type[HorsepowerTaxation]']")
    public WebElement horsepowerTaxationBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[Power]']")
    public WebElement powerBox;

    @FindBy(xpath = "//input[@name='custom_entity_type[Logo][file]']")
    public WebElement uploadFile;


    //Vehicle model checkbox--------------
    @FindBy(xpath = "//button[@class='btn btn-medium add-btn'][@name='temp-validation-name-2017']")
    public WebElement addVehicleModelBtn;

    public WebElement vehicleModelCheckbox(String name) {
        return getDriver().findElement(By.xpath("//tbody[@class='grid-body']//td[@data-column-label='Model Name'][text()='" + name + "']/.."));
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement selectVehicleModelBtn;


    //Vehicle make checkbox--------------
    @FindBy(xpath = "//button[@class='btn btn-medium add-btn'][@name='temp-validation-name-93']")
    public WebElement addVehicleMakeBtn;

    public WebElement vehicleMakeCheckbox(String name) {
        return getDriver().findElement(By.xpath("//tbody[@class='grid-body']//td[@data-column-label='Make'][text()='mazda']/.."));
    }

    @FindBy(xpath = "//button[@data-action-name='select']")
    public WebElement selectVehicleMakelBtn;

}
