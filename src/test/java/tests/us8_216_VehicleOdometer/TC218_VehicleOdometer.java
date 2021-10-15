package tests.us8_216_VehicleOdometer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.US8_Vehicle_Odometer;
import pages.VyTrackLoginPage;
import utilities.Driver;
import utilities.TestBase;
import utilities.VyTrackUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC218_VehicleOdometer extends TestBase {
//AC #2: managers should not to create Vehicle Odometer.

    @Test
    public void createOdometerStoremanager() {

        VyTrackLoginPage page=new VyTrackLoginPage();
        page.openVyTrackApp();

//Given store/sales manager is on the homePage
        page.login("storemanager69");
        VyTrackUtil.waitFor(3);

//When user select “Vehicle Odometer” under Fleet module
        US8_Vehicle_Odometer odometer=new US8_Vehicle_Odometer();
        odometer.chooseModule("Fleet").click();

        odometer.VehicleOdometer.click();
        VyTrackUtil.waitFor(3);

//Then verify “You do not have permission to perform this action.” message
        String actualText = new US8_Vehicle_Odometer().failMessage.getText();
        Assertions.assertEquals("You do not have permission to perform this action.",actualText);

    }

    @Test
    public void createOdometerSalemanager() {

        VyTrackLoginPage page=new VyTrackLoginPage();
        page.openVyTrackApp();

//Given store/sales manager is on the homePage
        page.login("salesmanager128");
        VyTrackUtil.waitFor(3);

//When user select “Vehicle Odometer” under Fleet module
        US8_Vehicle_Odometer odometer=new US8_Vehicle_Odometer();
        odometer.chooseModule("Fleet").click();

        odometer.VehicleOdometer.click();
        VyTrackUtil.waitFor(3);

//Then verify “You do not have permission to perform this action.” message
        String actualText = new US8_Vehicle_Odometer().failMessage.getText();
        Assertions.assertEquals("You do not have permission to perform this action.",actualText);

    }
}
