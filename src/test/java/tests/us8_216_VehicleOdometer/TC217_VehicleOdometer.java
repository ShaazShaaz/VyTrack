package tests.us8_216_VehicleOdometer;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.US8_Vehicle_Odometer;
import pages.UsersCommonArea;
import pages.VyTrackLoginPage;
import sun.jvm.hotspot.utilities.Assert;
import utilities.Driver;
import utilities.TestBase;
import utilities.VyTrackUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC217_VehicleOdometer extends TestBase {
//AC #1: drivers are able to create Vehicle Odometer.
//drivers are able to create Vehicle Odometer.

    @Test
    public void createOdometer() {

        VyTrackLoginPage page=new VyTrackLoginPage();

//Given driver is on the homePage
            page.openVyTrackApp();

            page.login("user27");
            VyTrackUtil.waitFor(2);

//When user select “Vehicle Odometer” under Fleet module
            US8_Vehicle_Odometer odometer=new US8_Vehicle_Odometer();
            odometer.chooseModule("Fleet").click();

            odometer.VehicleOdometer.click();
            VyTrackUtil.waitFor(3);

//And user click “Create Vehicle Odometer” button
            odometer.CreateOdometer.click();
            VyTrackUtil.waitFor(3);

//When user fill out general information and click “Save and Close” button
            odometer.fillOutForm();

// Then verify “Entity saved” confirm message
            String actualText = new US8_Vehicle_Odometer().successMessage.getText();
            Assertions.assertEquals("Entity saved",actualText);


        }
}
