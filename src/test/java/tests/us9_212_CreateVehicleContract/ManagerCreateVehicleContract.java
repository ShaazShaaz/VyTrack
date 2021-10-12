package tests.us9_212_CreateVehicleContract;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.SelectingVehicles;
import pages.US9_CreatingVehicleContract;
import pages.VyTrackLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.Driver.*;

public class ManagerCreateVehicleContract extends TestBase {

    @Test
    public void managerCreateVehicleContract(){

        List<String> usersManagers = new ArrayList<>(Arrays.asList("storemanager69","storemanager70","salesmanager128","salesmanager129","salesmanager130"));

        for (String eachManager: usersManagers
             ) {
            VyTrackLoginPage loginPage = new VyTrackLoginPage();
            loginPage.openVyTrackApp();
            loginPage.login(eachManager);
            SelectingVehicles button = new SelectingVehicles() ;
            Actions actions = new Actions(getDriver());
            //actions.moveToElement(button.fleet).perform();
            button.fleet.click();
            US9_CreatingVehicleContract creatingVehicleContract = new US9_CreatingVehicleContract() ;
            // getDriver().findElement(By.linkText("Vehicle Contracts")).click();
              creatingVehicleContract.vehicleContracts.click();
              creatingVehicleContract.createContracts.click();
            //"//div[contains(@id, 'FuelType')]/following-sibling::select")
            Select select = new Select(getDriver().findElement(By.xpath("//div[contains(@id,'Type')]/following-sibling::select")));
            select.selectByValue("leasing");
            Faker faker = new Faker();
            creatingVehicleContract.responsible.sendKeys(faker.name().fullName());
            creatingVehicleContract.activationCost.sendKeys(faker.numerify("####"));
            creatingVehicleContract.recurringCost.sendKeys(faker.numerify("1###"));

            Select cost= new Select(getDriver().findElement(By.xpath("//div[contains(@id,'RecurringCostAm')]/following-sibling::select")));
            cost.selectByIndex(2);
            creatingVehicleContract.odometer.sendKeys(faker.numerify("1###"));

            creatingVehicleContract.invoiceDate.click();
            Select month= new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
            month.selectByValue(faker.numerify("#"));
            Select year= new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
            year.selectByVisibleText(faker.numerify("201#"));
            String day = faker.numerify("1#");
            getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='"+day+"']")).click();

            creatingVehicleContract.startDate.click();
            Select months= new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
            months.selectByValue(faker.numerify("#"));
            Select years= new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
            years.selectByVisibleText(faker.numerify("201#"));
            String days = faker.numerify("1#");
            getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='"+days+"']")).click();

            creatingVehicleContract.expirationDate.click();
            Select monthss= new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
            monthss.selectByValue(faker.numerify("#"));
            Select yearss= new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
            yearss.selectByVisibleText(faker.numerify("201#"));
            String dayss = faker.numerify("1#");
            getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='"+dayss+"']")).click();

            creatingVehicleContract.vendor.sendKeys(faker.name().fullName());
            creatingVehicleContract.driver.sendKeys(faker.name().fullName());
            creatingVehicleContract.contractReference.sendKeys(faker.name().fullName());
            creatingVehicleContract.termsAndConditions.sendKeys(faker.lorem().characters());
            creatingVehicleContract.saveButton.click();
            WebElement alertMsg = getDriver().findElement(By.xpath("//div[@class='message'][text()='Entity saved']"));
            assertTrue(alertMsg.isDisplayed());
            loginPage.logOut();





            System.out.println("adsasdasd");



        }
    }

}
