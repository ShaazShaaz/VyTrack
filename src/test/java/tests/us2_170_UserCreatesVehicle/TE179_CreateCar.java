package tests.us2_170_UserCreatesVehicle;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US2_Form_CreateCarPage;
import pages.UsersCommonArea;
import utilities.TestBase;
import static utilities.VyTrackUtil.*;

import static utilities.Driver.*;

import java.util.ArrayList;
import java.util.Arrays;


public class TE179_CreateCar extends TestBase {
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

        ArrayList<String> managers = new ArrayList<>(Arrays.asList("storemanager69", "storemanager70", "salesmanager128", "salesmanager129", "salesmanager130"));
        for (String each : managers) {

            //    Given store/sales manager is on the homePage
            login(each);
            waitFor(2);

            //    When user select “Vehicles” under Fleet module
            Actions action = new Actions(getDriver());
            WebElement fleetModule = getDriver().findElement(By.xpath("//div[@id='main-menu']//li[2]//span[@class='title title-level-1']"));
            action.moveToElement(fleetModule).perform();
            getDriver().findElement(By.linkText("Vehicles")).click();

            //    And user click “create car” button
            getDriver().findElement(By.linkText("Create Car")).click();

            //    When user fill out general information
            Faker faker = new Faker();
            US2_Form_CreateCarPage form = new US2_Form_CreateCarPage();

            waitFor(3);
            String licencePlate = faker.letterify("##") + faker.letterify("-####");
            form.licencePlateBox.sendKeys(licencePlate);

            form.checkboxTag("Sedan").click();
            form.driverBox.sendKeys(faker.name().fullName());
            form.locationBox.sendKeys(faker.address().fullAddress());
            form.chassisNumbBox.sendKeys(faker.letterify("###") + faker.numerify("############"));
            form.modelYearBox.sendKeys("1995");            // HOW TO USE FAKER FOR YEAR******?
            form.lastOdometerBox.sendKeys(faker.numerify("###-###"));
            //**
            form.immatriculationBox.click();
            waitFor(2);
            form.immatriculationDateSelection(19, "Oct", "2019");
            //**
            form.firstContractBox.click();
            waitFor(2);
            form.firstContractDateSelection(3, "Feb", "2020");

            form.catalogValue.sendKeys("$" + faker.numerify("##-###"));
            form.seatsNumberBox.sendKeys("5");
            form.doorsNumbBox.sendKeys("4");
            form.colorBox.sendKeys(faker.color().name());
            //**
            Select transmission = new Select(form.transmissionDropdown);
            transmission.selectByVisibleText("Automatic");
            //**
            Select fuelType = new Select(form.fuelTypeDropdown);
            fuelType.selectByVisibleText("Hybrid");

            form.co2EmissionBox.sendKeys(faker.random().nextDouble() +"");
            form.horsepowerBox.sendKeys(faker.number().numberBetween(100, 300) + "horsepower");
            form.horsepowerTaxationBox.sendKeys(faker.number().numberBetween(1, 20) + "%");
            form.powerBox.sendKeys(faker.numerify("###"));
            //**
            WebElement upload = getDriver().switchTo().activeElement();
            upload.sendKeys("/Users/YuliiaNazarova/Desktop/logo.jpeg");
            //**
            form.addVehicleModelBtn.click();
            form.vehicleModelCheckbox("corolla");
            form.selectVehicleModelBtn.submit();
            //**
            form.addVehicleMakeBtn.click();
            form.vehicleMakeCheckbox("Toyota");
            form.selectVehicleMakelBtn.submit();


            //    And click “Save and Close” button
            getDriver().findElement(By.xpath("//button[@type='submit'][@class='btn btn-success action-button']")).submit();


            //    Then verify “Entity saved” confirm message
            WebElement alertMsg = getDriver().findElement(By.xpath("//div[@class='message'][text()='Entity saved']"));
            Assertions.assertTrue(alertMsg.isDisplayed());

            //Extra - check that licence plate matches with the one entered in a form
            WebElement licencePlateVerify = getDriver().findElement
                            (By.xpath("//label[@class='control-label'][text()='License Plate']/following-sibling::div/div"));
            Assertions.assertEquals(licencePlate, licencePlateVerify.getText());


        }
    }

}
