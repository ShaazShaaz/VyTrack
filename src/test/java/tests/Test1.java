package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.UsersCommonArea;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;
import utilities.VyTrackUtil;

public class Test1 extends TestBase {

    @Test
    public void test(){
        VyTrackUtil.login("user27");
        WebElement customerX = UsersCommonArea.chooseModule("Customers");
        VyTrackUtil.waitFor(3);
        Assertions.assertTrue(customerX.isDisplayed());
    }
    @Test
    public void robinTest(){
        VyTrackUtil.login("storemanager69");
        UsersCommonArea.chooseModule("Contacts");
    }
}
