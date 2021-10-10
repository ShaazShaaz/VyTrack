package tests.us2_170_UserCreatesVehicle;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.US2_Form_CreateCarPage;
import utilities.TestBase;
import utilities.VyTrackUtil;
import static utilities.Driver.*;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

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

            US2_Form_CreateCarPage form = new US2_Form_CreateCarPage();
            form.licencePlateBox.sendKeys(faker.letterify("##-")+faker.letterify("####"));
            form.checkboxTag("Sedan").click();
            form.driverBox.sendKeys(faker.name().fullName());
            form.locationBox.sendKeys(faker.address().fullAddress());
            form.chassisNumbBox.sendKeys(faker.letterify("###")+faker.numerify("############"));
            form.modelYearBox.sendKeys("1995");            // HOW TO USE FAKER ******?
            form.lastOdometerBox.sendKeys(faker.numerify("###-###"));
            form.immatriculationBox.click();
            form.immatriculationDateSelection(19,"October","2019");
            form.firstContractBox.click();
            form.firstContractDateSelection(3,"February","2020");







        }
}

}
