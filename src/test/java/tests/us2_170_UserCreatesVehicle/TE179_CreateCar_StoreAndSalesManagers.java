package tests.us2_170_UserCreatesVehicle;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.CreateCarVehiclePage;
import pages.UsersCommonArea;
import pages.VyTrackLoginPage;
import utilities.TestBase;

import static utilities.VyTrackUtil.*;

import static utilities.Driver.*;

import java.util.ArrayList;
import java.util.Arrays;


public class TE179_CreateCar_StoreAndSalesManagers extends TestBase {
//    Given store/sales manager is on the homePage
//    When user select “Vehicles” under Fleet module
//    And user click “create car” button
//    When user fill out general information
//    And click “Save and Close” button
//    Then verify “Entity saved” confirm message

    //DATA:
    //StoreManager: storemanager69 , storemanager70
    //SalesManager: salesmanager128 , salesmanager129 , salesmanager130

    @Test
    public void createVehicle() {
        //OBJECTS
        VyTrackLoginPage loginPage = new VyTrackLoginPage();
        Actions action = new Actions(getDriver());
        CreateCarVehiclePage form = new CreateCarVehiclePage();
        UsersCommonArea commonArea = new UsersCommonArea();

        ArrayList<String> managers = new ArrayList<>(Arrays.asList("storemanager69", "storemanager70", "salesmanager128", "salesmanager129", "salesmanager130"));
        for (String each : managers) {

            //    Given store/sales manager is on the homePage
            loginPage.openVyTrackApp();
            loginPage.login(each);
            waitFor(2);

            //    When user select “Vehicles” under Fleet module
            action.moveToElement(commonArea.chooseModule("Fleet")).perform();
            commonArea.mngFleetOptions("Vehicles").click();

            //    And user click “create car” button
            getDriver().findElement(By.linkText("Create Car")).click();

            //    When user fill out general information
            form.fillOutForm();

            // And click “Save and Close” button
            form.saveAndCloseBtn.submit();

            // Then verify “Entity saved” confirm message
            Assertions.assertTrue(form.alertMsg.isDisplayed());

            loginPage.logOut();

        }
    }

}