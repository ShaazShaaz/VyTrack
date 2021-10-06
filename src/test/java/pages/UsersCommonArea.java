package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class UsersCommonArea {

    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li")
    List<WebElement> modules;

    @FindBy(xpath = "//i[@title='Get help']")
    private WebElement oroGetHelp;

    @FindBy(xpath = "//h1/a[@title='Fleet Management']")
    private WebElement fleetMngHomePage;

    public List<String>modulesGetText(List<String> list){
        // list={"Dashboard","Fleet","Customers","Sales","Activities","Marketing","Reports & Segments","System"};

        List<String> expectedList=new ArrayList<>() ;

        for (WebElement eachMod : modules) {
            expectedList.add(eachMod.getText());

        }

        return expectedList;
    }



    public UsersCommonArea(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static WebElement chooseModule(String module){

        WebElement moduleName = Driver.getDriver().findElement(By.xpath("//div[@id=\"main-menu\"]/ul/li/a/span[contains(text(),'"+module+"')]"));
        return moduleName;
    }
}
