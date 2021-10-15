package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OroPage {

    @FindBy(xpath = "//i[@class='fa-question-circle']")
    public WebElement questionMark;

    @FindBy(xpath = "//i[@title='Get help']")
    public WebElement oroGetHelp;


}
