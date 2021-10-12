package tests.us4_;

import com.github.javafaker.Faker;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utilities.Driver;
import utilities.TestBase;
import utilities.VyTrackUtil;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pages.UsersCommonArea.*;



public class CreateContactAsMng extends TestBase {


    @Test
    public void createContact(){
        /*
         * List of mng users storemanager69, storemanager70, salesmanager128,
         * salesmanager129,salesmanager130
         */

        List<String> managers = new ArrayList<>(Arrays.asList("storemanager69",
                "storemanager70","salesmanager128",
                "salesmanager129","salesmanager130"));
        /*
         * Creation of objects page that will be used during the test
         */
        VyTrackLoginPage loginPage = new VyTrackLoginPage();
        CustomersContactsPage customersContactsPage = new CustomersContactsPage();
        CreateContactPages createContactPages = new CreateContactPages();

        for (String eachManager : managers) {
            /*
             * Each mng user open the app, login into it and wait for being logged
             * in 3 sec
             */
            loginPage.openVyTrackApp();
            loginPage.login(eachManager);
            // Each mnuser hover over "Customers" module then "Contacts" option
            // and click on it
            VyTrackUtil.waitFor(3);
            createContactPages.chooseModule();
            createContactPages.chooseOption();
            // On "Contact" page user click on "Create Contact Button" and wait
            // for 3 sec till load the page
            VyTrackUtil.waitFor(3);
            customersContactsPage.createContactBtn.click();
            createContactPages.fillForm();
            createContactPages.saveContact();
            VyTrackUtil.waitFor(3);
            loginPage.logOut();

        }
    }
}
