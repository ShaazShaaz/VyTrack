package tests.us9_212_CreateVehicleContract;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SelectingVehicles;
import pages.US9_CreatingVehicleContract;
import pages.VyTrackLoginPage;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.Driver.getDriver;

public class DriverCreateVehicleContract extends TestBase {

    List<String> usersDrivers = new ArrayList<>(Arrays.asList("user27","user28","user29"));

    @Test
    public void driverCreateVehicleContract (){
        for (String eachDriver:usersDrivers
             ) {


            VyTrackLoginPage loginPage = new VyTrackLoginPage();
            loginPage.openVyTrackApp();
            loginPage.login(eachDriver);
            US9_CreatingVehicleContract creatingVehicleContract = new US9_CreatingVehicleContract();
            Actions actions = new Actions(getDriver());
            SelectingVehicles buttons = new SelectingVehicles();
           creatingVehicleContract.fleet.click();
            creatingVehicleContract.vehicleContracts.click();
            WebElement alertMsg = getDriver().findElement(By.xpath("//div[@class='message'][text()='You do not have permission to perform this action.']"));
           loginPage.logOut();


            System.out.println("asdasdasd");




        }  }
}
