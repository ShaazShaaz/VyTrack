package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContactPages {
    @FindBy(xpath = "//*[@id='oro_contact_form-uid-61603a82338ee']//a[normalize-space(.)='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@id='oro_contact_form_namePrefix-uid-61603a822ed3a']")
    private WebElement prefixBox;

    @FindBy(xpath = "//*[@id='oro_contact_form_firstName-uid-61603a822ee34']")
    private WebElement firstNameBox;

    @FindBy(xpath = "//*[@id='oro_contact_form_middleName-uid-61603a822eeed']")
    private WebElement middleNameBox;

    @FindBy(xpath = "//*[@id='oro_contact_form_nameSuffix-uid-61603a822f0cb']")
    private WebElement lastNameBox;

    @FindBy(xpath = "//*[@id='oro_contact_form_emails_0_email-uid-61603a823235d']")
    private WebElement EmailsBox;

    @FindBy(xpath = "//*[@id='oro_contact_form_phones_0_phone-uid-61603a82329a4']")
    private WebElement phoneBox;



}
