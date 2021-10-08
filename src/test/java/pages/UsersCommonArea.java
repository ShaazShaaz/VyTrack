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


    public static WebElement mngDashboardsOptions(String option){
        // Dashboard, Manage Dashboards
        WebElement dashboardOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[1]//span[.='"+option+"']"));
        return dashboardOptionName;
    }
    public static WebElement mngFleetOptions(String option){
        // Vehicles, Vehicle Odometer, Vehicle Costs, Vehicle Contracts, Vehicles Fuel Logs, Vehicle Services Logs, Vehicles Model
        WebElement fleetOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[2]//span[.='"+option+"']"));
        return fleetOptionName;
    }

    public static WebElement mngCustomersOptions(String option){
        // Accounts, Contacts
        WebElement customersOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[3]//span[.='"+option+"']"));
        return customersOptionName;
    }

    public static WebElement mngSalesOptions(String option){
        // Opportunities
        WebElement salesOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[4]//span[.='"+option+"']"));
        return salesOptionName;
    }

    public static WebElement mngActivitiesOptions(String option){
        // Calls, Calendar Events
        WebElement activitiesOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[5]//span[.='"+option+"']"));
        return activitiesOptionName;
    }

    public static WebElement mngMarketingOptions(String option){
        //
        WebElement marketingOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[6]//span[.='"+option+"']"));
        return marketingOptionName;
    }

    public static WebElement mngReportsOptions(String option){
        // Life Time, By Opportunities, Leads By Day, Opportunities By Status,
        // Won Opportunities By Period, Total Forecast, Manage Custom Reports, Campaign Performance
        WebElement reportsOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[7]//span[.='"+option+"']"));
        return reportsOptionName;
    }

    public static WebElement mngSystemOptions(String option){
        //Users, Business Units, Contact Groups, Jobs, Menus, System Calendars
        WebElement systemOptionName = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[8]//span[.='"+option+"']"));
        return systemOptionName;
    }

}
