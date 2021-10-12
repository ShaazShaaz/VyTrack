package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.VyTrackUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class CreateContactPages {

    /**
     * WebElements of the page 'Create Contact'
     */
    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@class='btn-success btn dropdown-toggle']")
    private WebElement saveAndCloseDropDown;

    @FindBy(xpath = "//*/li[3]/button[@type='submit']")
    private WebElement saveOption;

    @FindBy(xpath = "//input[@name='oro_contact_form[namePrefix]']")
    private WebElement contactPrefixBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[firstName]']")
    private WebElement contactFirstNameBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[middleName]']")
    private WebElement contactMiddleNameBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[lastName]']")
    private WebElement contactLastNameBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[nameSuffix]']")
    private WebElement contactSuffixBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[emails][0][email]']")
    private WebElement contactEmailBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[phones][0][phone]']")
    private WebElement contactPhonesBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[fax]']")
    private WebElement contactFaxBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[skype]']")
    private WebElement contactSkypeBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[twitter]']")
    private WebElement contactTwitterBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[facebook]']")
    private WebElement contactFacebookBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[googlePlus]']")
    private WebElement contactGooglePlusBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[linkedIn]']")
    private WebElement contactLinkedInBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[jobTitle]']")
    private WebElement contactJobTitleBox;

  //  @FindBy(xpath = "//input[@name='oro_contact_form[birthday]']")
  //  private WebElement birthdayBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][label]']")
    private WebElement addressLabelBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][namePrefix]']")
    private WebElement addressPrefixBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][firstName]']")
    private WebElement addressFirstNameBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][middleName]']")
    private WebElement addressMiddleNameBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][lastName]']")
    private WebElement addressLastNameBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][nameSuffix]']")
    private WebElement addressSuffixBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][organization]']")
    private WebElement addressOrganizationBox;

    @FindBy(xpath = "//*[.='Choose a country...']")
    private WebElement addressCountryDropDown;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement addressCountryBlankBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][street]']")
    private WebElement addressStreetBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][street2]']")
    private WebElement addressStreet2Box;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][city]']")
    private WebElement addressCityBox;

    @FindBy(xpath = "//a[@class='select2-choice select2-default']/*[.='Choose a state...']")
    private WebElement addressStateDropdown;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement addressStateBlankBox;

    @FindBy(xpath = "//input[@name='oro_contact_form[addresses][0][postalCode]']")
    private WebElement addressZipcodeBox;

    /**
     * Class constructor
     */
    public CreateContactPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void fillForm(){
        Faker faker = new Faker();
        contactPrefixBox.sendKeys(faker.name().prefix());
        contactFirstNameBox.sendKeys(faker.name().firstName());
        contactMiddleNameBox.sendKeys(faker.name().firstName());
        contactLastNameBox.sendKeys(faker.name().lastName());
        contactSuffixBox.sendKeys(faker.name().suffix());
        contactEmailBox.sendKeys(faker.internet().emailAddress());
        contactPhonesBox.sendKeys(faker.phoneNumber().cellPhone());
        contactFaxBox.sendKeys(faker.phoneNumber().phoneNumber());
        contactSkypeBox.sendKeys(faker.internet().emailAddress());
        contactTwitterBox.sendKeys(faker.internet().emailAddress());
        contactFacebookBox.sendKeys(faker.internet().emailAddress());
        contactGooglePlusBox.sendKeys(faker.internet().emailAddress());
        contactLinkedInBox.sendKeys(faker.internet().emailAddress());
        contactJobTitleBox.sendKeys(faker.job().title());
        addressPrefixBox.sendKeys(faker.name().prefix());
        addressFirstNameBox.sendKeys(faker.name().firstName());
        addressMiddleNameBox.sendKeys(faker.name().firstName());
        addressLastNameBox.sendKeys(faker.name().lastName());
        addressSuffixBox.sendKeys(faker.name().suffix());
        addressOrganizationBox.sendKeys(faker.company().name());
        addressCountryDropDown.click();
        VyTrackUtil.waitFor(2);
        addressCountryBlankBox.sendKeys("United States");
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.ENTER)
                    .perform();
        addressStreetBox.sendKeys(faker.address().streetAddress());
        addressStreet2Box.sendKeys("Apt "+faker.numerify("###"));
        addressCityBox.sendKeys(faker.address().cityName());
        addressStateDropdown.click();
        VyTrackUtil.waitFor(2);
        addressStateBlankBox.sendKeys("Florida");
        action.sendKeys(Keys.ENTER)
                .perform();
        addressZipcodeBox.sendKeys(faker.address().zipCode());
    }
    public void saveContact(){
        saveAndCloseDropDown.click();
        VyTrackUtil.waitFor(2);
        saveOption.click();
    }
    public void chooseModule(){
        UsersCommonArea commonAreaPage = new UsersCommonArea();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(commonAreaPage.chooseModule("Customers"))
                .perform();
    }
    public void chooseOption(){
        UsersCommonArea commonAreaPage = new UsersCommonArea();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(commonAreaPage.mngCustomersOptions("Contacts"))
                .click()
                .perform();
    }

}
