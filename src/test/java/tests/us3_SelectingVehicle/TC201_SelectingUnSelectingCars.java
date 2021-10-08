package tests.us3_SelectingVehicle;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SelectingVehicles;
import utilities.TestBase;
import utilities.VyTrackUtil;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static utilities.Driver.getDriver;

public class TC201_SelectingUnSelectingCars extends TestBase {

    @Test
    public void checkAndUncheckVehicles(){

        ArrayList<String> managers=new ArrayList<>(Arrays.asList("storemanager69","storemanager70","salesmanager128","salesmanager129","salesmanager130"));
        for (String each : managers) {

            VyTrackUtil.login(each);

            ////span[normalize-space(.)='Fleet']

            SelectingVehicles buttons = new SelectingVehicles();

            //clicking Fleet and then Vehicle
            buttons.fleet.click();
            buttons.vehicle.click();

            VyTrackUtil.waitFor(1);
            //checking all checkBoxes
            buttons.checkBox.click();

            VyTrackUtil.waitFor(1);
            assertTrue( SelectingVehicles.checkAll() );



            VyTrackUtil.logOut();


        }


    }

    @Test
    public void randomCheckBox(){

        ArrayList<String> managers=new ArrayList<>(Arrays.asList("storemanager69","storemanager70","salesmanager128","salesmanager129","salesmanager130"));
        for (String each : managers) {

            VyTrackUtil.login(each);

            SelectingVehicles check = new SelectingVehicles();

            check.fleet.click();

            VyTrackUtil.waitFor(2);

            check.vehicle.click();

            VyTrackUtil.waitFor(1);

            SelectingVehicles.randomCheck();


            VyTrackUtil.waitFor(1);

            assertTrue( SelectingVehicles.checkAll() );


            VyTrackUtil.logOut();

            }

        }


}
