package tests.us1_;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.UsersCommonArea;
import pages.VyTrackLoginPage;
import utilities.TestBase;
import utilities.VyTrackUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccessMainModules extends TestBase {
    /*
    As a user, I should be access all the main modules of the app.
 AC #1:
Given store/sales manager is on the homePage
Then verify user view 8 models names [verify the names]
AC #2:
Given driver is on the homePage
Then verify user view 4 models names [verify the names]
     */


    @Test
    public void accessModulesManager() {
        // Given store/sales manager is on the homePage
        ArrayList<String> managers = new ArrayList<>(Arrays.asList("storemanager69", "storemanager70", "salesmanager128", "salesmanager129", "salesmanager130"));
        VyTrackLoginPage page = new VyTrackLoginPage();
        UsersCommonArea userArea = new UsersCommonArea();
        for (String each : managers) {
            page.openVyTrackApp();
            page.login(each);
            //Then verify user view 8 models names [verify the names]
            // list={"Dashboard","Fleet","Customers","Sales","Activities","Marketing","Reports & Segments","System"};

            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList("Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));
            Assertions.assertEquals(list, userArea.modulesGetText());

            page.logOut();
        }
    }

    @Test
    public void accessModulesDriver(){
        ArrayList<String> driver = new ArrayList<>(Arrays.asList("user27" , "user28" , "user29"));
        VyTrackLoginPage page = new VyTrackLoginPage();
        UsersCommonArea userArea = new UsersCommonArea();
        for (String each : driver) {
            page.openVyTrackApp();
            page.login(each);
            //Then verify user view 4 models names [verify the names]
            // list={"Fleet","Customers","Activities","System"};

            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList( "Fleet", "Customers", "Activities", "System"));

            VyTrackUtil.waitFor(3);
            Assertions.assertEquals(list, userArea.modulesGetText());

            page.logOut();
        }
    }
}
