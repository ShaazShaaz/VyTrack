package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UsersCommonArea {

    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li")
    List<WebElement> modules;

    @FindBy(xpath = "//i[@title='Get help']")
    private WebElement oroGetHelp;

    @FindBy(xpath = "//h1/a[@title='Fleet Management']")
    private WebElement fleetMngHomePage;

    @FindBy(xpath = "//div[@class='container']/ul[@class='nav pull-right user-menu']/li[@id='user-menu']/ul[@class='dropdown-menu']/li[not(@class='divider' or @class='last')]")
    List<WebElement> accountOptions;

    public List<String> modulesGetText() {
        // list={"Dashboard","Fleet","Customers","Sales","Activities","Marketing","Reports & Segments","System"};

        List<String> expectedList = new ArrayList<>();

        for (WebElement eachMod : modules) {
            expectedList.add(eachMod.getText());

        }

        return expectedList;
    }

    public List<String> optionsGetText() {

        List<String> expectedOptions = new ArrayList<>();

        for (WebElement eachOption : accountOptions) {

            expectedOptions.add(eachOption.getText());
        }
        System.out.println(expectedOptions);
        return expectedOptions;
    }


    public UsersCommonArea() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static WebElement chooseModule(String module) {

        WebElement moduleName = Driver.getDriver().findElement(By.xpath("//div[@id=\"main-menu\"]/ul/li/a/span[contains(text(),'" + module + "')]"));
        return moduleName;
    }
}
