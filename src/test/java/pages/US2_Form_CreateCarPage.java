package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static utilities.Driver.*;

import java.util.ArrayList;
import java.util.Arrays;

public class US2_Form_CreateCarPage {

    public US2_Form_CreateCarPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "#custom_entity_type_LicensePlate-uid-615cbece5ad22")
    public WebElement licencePlateBox;

    public WebElement checkboxTag(String tagName) {
        ArrayList<String> tags = new ArrayList<>(Arrays.asList("Junior", "Senior", "Employee Car", "Purchased", "Compact", "Sedan", "Convertible"));
        int index = tags.indexOf(tagName);
        return getDriver().findElement(By.id("custom_entity_type_Tags_" + index + "-uid-615cbece5b3c1"));
    }

    @FindBy(id = "#custom_entity_type_Driver-uid-615cbece5b588")
    public WebElement driverBox;

    @FindBy(id = "#custom_entity_type_Location-uid-615cbece5b67d")
    public WebElement locationBox;

    @FindBy(id = "#custom_entity_type_ChassisNumber-uid-615cbece5b769")
    public WebElement chassisNumbBox;

    @FindBy(id = "#custom_entity_type_ModelYear-uid-615cbece5b85d")
    public WebElement modelYearBox;

    @FindBy(id = "#custom_entity_type_LastOdometer-uid-615cbece5b946")
    public WebElement lastOdometerBox;

    @FindBy(id = "#date_selector_custom_entity_type_ImmatriculationDate-uid-615cbece5ba2e")
    public WebElement immatriculationBox;

    public void immatriculationDateSelection(int day, String month, String year ){

        WebElement monthDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        WebElement yearDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='"+day+"']"));
    }

    @FindBy(xpath = "//button[@data-handler='today']")
    WebElement todayBtn_Immatricular;

    @FindBy(id = "#date_selector_custom_entity_type_FirstContractDate-uid-615cbece5bb19")
    public WebElement firstContractBox;

    public void firstContractDateSelection(int day, String month, String year ){

        WebElement monthDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        WebElement yearDropdown = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='"+day+"']"));
    }

    @FindBy(id = "custom_entity_type_CatalogValue-uid-615cbece5bd7e")
    public WebElement catalogValue;

    @FindBy(id = "custom_entity_type_SeatsNumber-uid-615cbece5be75")
    public WebElement seatsNumberBox;

    @FindBy(id = "#custom_entity_type_DoorsNumber-uid-615cbece5bf6d")
    public WebElement doorsNumbBox;

    @FindBy(id = "#custom_entity_type_Color-uid-615cbece5c06f")
    public WebElement colorBox;

    @FindBy(xpath = "//div[@id='s2id_custom_entity_type_Transmission-uid-615cbece5c19d']//span[@class='select2-chosen']")
    public WebElement transmissionDropdown;

    @FindBy(xpath = "//div[@id='s2id_custom_entity_type_FuelType-uid-615cbece5c2cf']//span[@class='select2-chosen']")
    public WebElement fuelTypeDropdown;

    @FindBy(id = "#custom_entity_type_CO2Emissions-uid-615cbece5c3bc")
    public WebElement co2EmissionBox;

    @FindBy(id = "#custom_entity_type_Horsepower-uid-615cbece5c4c2")
    public WebElement horsepowerBox;

    @FindBy(id = "custom_entity_type_HorsepowerTaxation-uid-615cbece5c5ac")
    public WebElement horsepowerTaxationBox;

    @FindBy(id = "#custom_entity_type_Power-uid-615cbece5c697")
    public WebElement powerBox;

    @FindBy(id = "custom_entity_type_Logo_file-uid-615fba159455a")
    public WebElement uploadFile;


    //Vehicle model checkbox--------------
    @FindBy(xpath = "//button[@class='btn btn-medium add-btn'][@name='temp-validation-name-2017']")
    public WebElement addVehicleModelBtn;

    public WebElement modelNameCheckbox(String name) {
        ////tbody[@class='grid-body']//td[@data-column-label='Model Name'][text()='Model-X']/..
        return getDriver().findElement(By.xpath("//tbody[@class='grid-body']//td[@data-column-label='Model Name'][text()='" + name + "']/.."));
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement selectVehicleModelBtn;


    //Vehicle make checkbox--------------
    @FindBy(xpath = "//button[@class='btn btn-medium add-btn'][@name='temp-validation-name-93']")
    public WebElement addVehicleMakeBtn;

    public WebElement modelMakeCheckbox(String name) {
        ////tbody[@class='grid-body']//td[@data-column-label='Model Name'][text()='Model-X']/..
        return getDriver().findElement(By.xpath("//tbody[@class='grid-body']//td[@data-column-label='Make'][text()='mazda']/.."));
    }

    @FindBy(xpath = "//button[@data-action-name='select']")
    public WebElement selectVehicleMakelBtn;

}
