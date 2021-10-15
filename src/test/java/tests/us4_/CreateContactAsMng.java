package tests.us4_;

import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;
import pages.CustomersContactsPage;
import pages.VyTrackLoginPage;
import utilities.Driver;
import utilities.TestBase;
import utilities.VyTrackUtil;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CreateContactAsMng extends TestBase {


    @Test
    public void createContact(){
        // List of mng users storemanager69, storemanager70, salesmanager128,
        // salesmanager129,salesmanager130
        List<String> managers = new ArrayList<>(Arrays.asList("storemanager69",
                                    "storemanager70","salesmanager128",
                                    "salesmanager129","salesmanager130"));
        for (String eachManager : managers) {
            // Each mng user open, login and wait foe being logged
            // in 3 sec
            VyTrackLoginPage page = new VyTrackLoginPage();
            page.openVyTrackApp();
            page.login(eachManager);
            // Each mnuser hover over "Customers" module then "Contacts" option
            // and click on it
            VyTrackUtil.waitFor(4);
            Actions action = new Actions(Driver.getDriver());
     //      action.moveToElement(chooseModule("Customers"))
     //               .moveToElement(mngCustomersOptions("Contacts"))
     //               .click()
     //               .perform();
            // On "Contact" page user click on "Create Contact Button" and wait
            // for 3 sec till load the page
            VyTrackUtil.waitFor(4);
            CustomersContactsPage customersContactsPage = new CustomersContactsPage();
            customersContactsPage.createContactBtn.click();
            page.logOut();

        }
    }
}
