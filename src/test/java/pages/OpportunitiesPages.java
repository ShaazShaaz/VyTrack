package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.VyTrackUtil;

public class OpportunitiesPages {

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/a/span")
    public WebElement salesModule;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/div/div/ul/li[3]/a/span")
    public WebElement opportunitiesOption;

    @FindBy(xpath = "//a[@title='Create Opportunity']")
    public WebElement createOpportunityBtn;

    @FindBy(xpath = "//*[contains(@id,'s2id_oro_sales_opportunity_form_owner-uid')]/a/span[2]")
    public WebElement ownerBox;

    @FindBy(xpath="//div/input[@class='select2-input select2-focused']")
    public WebElement ownerSelectBox;

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable'][2]")
   public WebElement ownerSelected;

    @FindBy(xpath = "//input[@name='oro_sales_opportunity_form[name]']")
    public WebElement opportunityName;

    @FindBy(xpath = "//span[.='Choose an account ....']")
    public WebElement accountBox;

    @FindBy(xpath = "//*[.='Choose a value...']")
    public WebElement contactBox;

    @FindBy(xpath = "//span[.='Demo Omed']")
    public WebElement contactOption;

    @FindBy(xpath = "//*[.='Choose a value...']")
    public WebElement statusBox;

    @FindBy(xpath = "//div[.='Identification & Alignment']")
    public WebElement statusOption;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement expectedCloseDateBox;

    @FindBy(xpath = "//td/a[.='4']")
    public WebElement dateOption;

    @FindBy(xpath = "//div/input[contains(@id,'oro_sales_opportunity_form_probability')]")
    public WebElement probabilityBox;

    @FindBy(xpath = "//div/input[contains(@id,'oro_sales_opportunity_form_budgetAmount_value')]")
    public WebElement budgetBox;

    @FindBy(xpath = "//div/input[contains(@id,'oro_sales_opportunity_form_closeRevenue_value')]")
    public WebElement closeRevenueBox;

    @FindBy(xpath = "//body[contains(@data-id,'oro_sales_opportunity_form_customerNeed')]")
    public WebElement iframeCustomerNeed;

    @FindBy(xpath = "//body[contains(@data-id,'oro_sales_opportunity_form_notes')]")
    public WebElement iframeAdditionalComments;

    @FindBy(xpath = "//body[contains(@data-id,'oro_sales_opportunity_form_proposedSolution')]")
    public WebElement iframeProposedSolution;

    @FindBy(xpath = "//div/span[.='Choose a close reason...']")
    public WebElement closeReasonBox;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseBtn;

    public OpportunitiesPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void fillCreateOpportunityForm(){
       // ownerBox.click();
        Faker faker=new Faker();
        Actions action=new Actions(Driver.getDriver());
        ownerBox.click();
        ownerSelectBox.sendKeys("ts@yahoo.com");
       action.sendKeys(Keys.ENTER).perform();

        VyTrackUtil.waitFor(2);
//        opportunityName.click();
 //       opportunityName.sendKeys("Name");
        VyTrackUtil.waitFor(2);
//
//       contactBox.click();
//       select.selectByIndex(1);
//
//       statusBox.click();
//       select.selectByIndex(2);

       probabilityBox.sendKeys(faker.numerify("##"));
       budgetBox.sendKeys(faker.numerify("#####"));
       expectedCloseDateBox.click();
       dateOption.click();
       closeRevenueBox.sendKeys(faker.numerify("#####"));
      // closeReasonBox.click();
      // Select select=new Select(closeReasonBox);
      // select.selectByIndex(2);
       Driver.getDriver().switchTo().frame(0);
       WebElement active=Driver.getDriver().switchTo().activeElement();
       active.sendKeys("This is just for practice, hey Customer");
       Driver.getDriver().switchTo().defaultContent();
       VyTrackUtil.waitFor(2);
       Driver.getDriver().switchTo().frame(1);
        WebElement active2=Driver.getDriver().switchTo().activeElement();
        active2.sendKeys("This is just for practice, for a solution");
        Driver.getDriver().switchTo().defaultContent();
        VyTrackUtil.waitFor(2);
        Driver.getDriver().switchTo().frame(2);
        WebElement active3=Driver.getDriver().switchTo().activeElement();
        active3.sendKeys("This is just for practice, for additional comments");
        Driver.getDriver().switchTo().defaultContent();
        saveAndCloseBtn.click();

    }

}
