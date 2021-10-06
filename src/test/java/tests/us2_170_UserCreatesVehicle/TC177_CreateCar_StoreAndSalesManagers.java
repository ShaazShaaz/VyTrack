package tests.us2_170_UserCreatesVehicle;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import utilities.VyTrackUtil;

import static utilities.Driver.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TC177_CreateCar_StoreAndSalesManagers extends TestBase {
//    Given store/sales manager is on the homePage
//    When user select “Vehicles” under Fleet module
//    And user click “create car” button
//    When user fill out general information
//    And click “Save and Close” button
//    Then verify “Entity saved” confirm message

    //DATA:
    //StoreManager: storemanager69 , storemanager70
    //SalesManager: salesmanager128 , salesmanager129 , salesmanager130

    //    Given store/sales manager is on the homePage

         @Test
         public void createVehicle(){

        ArrayList<String> managers=new ArrayList<>(Arrays.asList("storemanager69","storemanager70","salesmanager128","salesmanager129","salesmanager130"));
        for (String each : managers) {

            //    Given store/sales manager is on the homePage
            VyTrackUtil.login(each);

            //    When user select “Vehicles” under Fleet module
             Actions action = new Actions(getDriver());
            WebElement fleetModule = getDriver().findElement(By.xpath("//div[@id='main-menu']//li[2]//span[@class='title title-level-1']"));
            action.moveToElement(fleetModule);
            getDriver().findElement(By.linkText("Vehicles")).click();

            //    And user click “create car” button
            getDriver().findElement(By.linkText("Create Car")).click();

            //    When user fill out general information
            Faker faker = new Faker();
            WebElement licencePlateBox = getDriver().findElement(By.id("#custom_entity_type_LicensePlate-uid-615cbece5ad22"));
            licencePlateBox.sendKeys(faker.numerify("##-####"));




        }
}

}
