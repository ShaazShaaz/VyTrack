package tests.salesOpportunitiesTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import pages.OpportunitiesPages;
import pages.VyTrackLoginPage;
import utilities.Driver;
import utilities.TestBase;
import utilities.VyTrackUtil;

public class SalesOpportunity extends TestBase {

    VyTrackLoginPage loginPage=new VyTrackLoginPage();
    OpportunitiesPages opportunitiesPages=new OpportunitiesPages();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void createOpportunityFunctionality(){
        loginPage.openVyTrackApp();
        loginPage.login("storemanager69");
        VyTrackUtil.waitFor(3);
        actions.moveToElement(opportunitiesPages.salesModule).perform();
        VyTrackUtil.waitFor(2);
        opportunitiesPages.opportunitiesOption.click();
        opportunitiesPages.createOpportunityBtn.click();
        VyTrackUtil.waitFor(3);
        opportunitiesPages.fillCreateOpportunityForm();

    }
}
