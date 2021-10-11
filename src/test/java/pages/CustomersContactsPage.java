package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CustomersContactsPage {

    @FindBy(xpath = "//*[@id='container']//a[normalize-space(.)='Create Contact']")
    public WebElement createContactBtn;

    public CustomersContactsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
