package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utilities.Driver.getDriver;

public class SelectingVehicles {



    @FindBy(xpath = "//table/thead//div//input")
    public WebElement checkBox;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li[2]")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicle;

/*
    @FindBy(xpath = "//tbody/tr[15]/td/input")
    public WebElement ranDom;


 */


    public SelectingVehicles(){
        PageFactory.initElements(getDriver(), this);
    }



    public static boolean checkAll(){

        SelectingVehicles check = new SelectingVehicles();

        List<WebElement> allChecksBoxes =
                getDriver().findElements(By.xpath("//tbody/tr/td"));

        boolean result = true;
        //as long as one of them are not checked, return false immediately

        for (WebElement eachCheckBox : allChecksBoxes) {
            if(!eachCheckBox.isSelected()){
                result =   false;
            }
        }
        return true;
    }
/*
    public static boolean randomCheck(){

        SelectingVehicles check = new SelectingVehicles();

        List<WebElement> allChecksBoxes =
                getDriver().findElements(By.xpath("//tbody/tr/td"));

        boolean result = true;
        //as long as one of them are not checked, return false immediately

        for (WebElement eachCheckBox : allChecksBoxes) {
            if(! eachCheckBox.isSelected()){
                result =   false;
            }
        }
        return true;

    }

 */

    public static void randomCheck(){
        Faker faker =new Faker();
        faker.number().numberBetween(2,525);
        WebElement checks = getDriver().findElement(By.xpath("//tbody/tr[5]/td/input"));
        checks.click();

    }



}
