package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class US1_Homepage extends TestBase {

    @FindBy(xpath = "//div[@id=\"main-menu\"]/ul/li")
    List<WebElement> modules;

    public US1_Homepage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public List<String> modulesGetText(List<String> list){
       // list={"Dashboard","Fleet","Customers","Sales","Activities","Marketing","Reports & Segments","System"};

        List<String> expectedList=new ArrayList<>() ;

        for (WebElement eachMod : modules) {
            expectedList.add(eachMod.getText());

        }

        return expectedList;
    }



}
