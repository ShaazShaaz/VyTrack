package tests.us5_206_AccountsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AccountsPage;
import utilities.TestBase;
import utilities.VyTrackUtil;
import java.util.ArrayList;
import java.util.Arrays;

public class TC207_208_AccountsPageTest extends TestBase {
    /*
    As a user, I should be able to select accounts from accounts page
    AC #1: user can select all the accounts by checking the first checkbox
           Given user is on the homePage
           When user select “Accounts” under Customers module
           And user checks the first checkbox
           Then verify all the checkbox is checked
    AC #2: user can select any account
           Given user is on the homePage
           When user select “Accounts” under Customers module
           And user checks any account’s checkbox
           Then verify the checkbox is checked
     */

    AccountsPage accountsPage = new AccountsPage();

    // Verifying if all checkboxes are selected, if user(Manager) clicks on the first checkbox
    @Test
    public void verifyAllCheckboxChecked_Managers() {
        ArrayList<String> managers = new ArrayList<>(Arrays.asList("storemanager69", "storemanager70", "salesmanager128", "salesmanager129", "salesmanager130"));

        for (String each : managers) {
            VyTrackUtil.login(each);
            VyTrackUtil.waitFor(3);
            accountsPage.selectAccountsBtn_Managers();
            VyTrackUtil.waitFor(3);
            accountsPage.firstCheckbox.click();

            VyTrackUtil.waitFor(3);
            Assertions.assertTrue(accountsPage.allCheckbox.isSelected());
            VyTrackUtil.waitFor(3);
            VyTrackUtil.logOut();
        }
    }

    // Verifying if all checkboxes are selected, if user(Driver) clicks on the first checkbox
    @Test
    public void verifyAllCheckboxChecked_Drivers(){
        ArrayList<String> drivers = new ArrayList<>(Arrays.asList("user27", "user28" , "user29" ));

        for (String each : drivers) {
            VyTrackUtil.login(each);
            VyTrackUtil.waitFor(3);
            accountsPage.selectAccountsBtn_Drivers();
            VyTrackUtil.waitFor(3);
            accountsPage.firstCheckbox.click();

            VyTrackUtil.waitFor(3);
            Assertions.assertTrue(accountsPage.allCheckbox.isEnabled());
            VyTrackUtil.waitFor(3);
            VyTrackUtil.logOut();
        }
    }

    // verifying if the checkbox selected by user(Driver) gets displayed as selected
    @Test
    public void verifyOneCheckboxSelection_Driver(){
        ArrayList<String> drivers = new ArrayList<>(Arrays.asList("user27", "user28" , "user29" ));

        for (String each : drivers) {
            VyTrackUtil.login(each);
            VyTrackUtil.waitFor(3);
            accountsPage.selectAccountsBtn_Drivers();
            VyTrackUtil.waitFor(3);
            accountsPage.selectOneCheckbox_Drivers();

            VyTrackUtil.waitFor(3);
            Assertions.assertTrue(accountsPage.thirdCheckBox.isEnabled());
            VyTrackUtil.waitFor(3);
            VyTrackUtil.logOut();
        }

    }

    // verifying if the checkbox selected by user(Manager) gets displayed as selected
    @Test
    public void verifyOneCheckboxSelection_Manager(){
        ArrayList<String> managers = new ArrayList<>(Arrays.asList("storemanager69", "storemanager70", "salesmanager128", "salesmanager129", "salesmanager130"));


        for (String each : managers) {
            VyTrackUtil.login(each);
            VyTrackUtil.waitFor(3);
            accountsPage.selectAccountsBtn_Managers();
            VyTrackUtil.waitFor(3);
            accountsPage.selectOneCheckbox_Managers();

            VyTrackUtil.waitFor(3);
            Assertions.assertTrue(accountsPage.thirdCheckBox.isEnabled());
            VyTrackUtil.waitFor(3);
            VyTrackUtil.logOut();
        }

    }

}
