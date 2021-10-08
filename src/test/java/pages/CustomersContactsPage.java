package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersContactsPage {
    @FindBy(xpath = "//*[@id='container']//a[normalize-space(.)='Create Contact']")
    private WebElement createContactBtn;
}
