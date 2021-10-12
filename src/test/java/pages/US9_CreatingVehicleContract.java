package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US9_CreatingVehicleContract {

    @FindBy(linkText = "Vehicle Contracts")
   public WebElement vehicleContracts ;

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createContracts ;

    @FindBy(xpath = "//input[@name='custom_entity_type[Responsible]']")
    public WebElement responsible ;

    @FindBy(xpath ="//input[@name='custom_entity_type[ActivationCost]']")
    public WebElement activationCost;

    @FindBy(xpath = "//input[@name='custom_entity_type[RecurringCostAmount]']")
    public WebElement recurringCost;

    @FindBy(xpath = "//input[@name='custom_entity_type[OdometerDetails]']")
    public WebElement odometer ;
                                                                      //placeholder="Choose a date"
    @FindBy(xpath = "//input[contains(@id,'InoviceDate') and contains(@placeholder,'Choose a date')]")
    public WebElement invoiceDate;

    @FindBy(xpath ="//a[@class='ui-state-default']" )
    public WebElement choseDay;

    @FindBy(xpath = "//input[contains(@id,'ContractStartDate') and contains(@placeholder,'Choose a date')]")
    public WebElement startDate;

    @FindBy(xpath = "//input[contains(@id,'ContractExpirationDate') and contains(@placeholder,'Choose a date')]")
    public WebElement expirationDate;

    @FindBy(xpath = "//input[@name='custom_entity_type[Vendor]']")
    public WebElement vendor ;

    @FindBy(xpath = "//input[@name='custom_entity_type[Driver]']")
    public WebElement driver ;

    @FindBy(xpath = "//textarea[@name='custom_entity_type[TermsandConditions]']")
    public WebElement termsAndConditions ;

    @FindBy(xpath = "//input[@name='custom_entity_type[ContractReference]']")
    public WebElement contractReference ;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveButton;

 @FindBy(xpath = "//div[@id='main-menu']/ul/li[1]")
 public WebElement fleet;


    public US9_CreatingVehicleContract (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
