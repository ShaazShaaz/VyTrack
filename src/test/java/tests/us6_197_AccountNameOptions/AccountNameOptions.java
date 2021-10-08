package tests.us6_197_AccountNameOptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.UsersCommonArea;
import utilities.TestBase;
import utilities.VyTrackUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.Driver.getDriver;

public class AccountNameOptions extends TestBase {

    /*
    As a user, I should be view 3 options under my account name.
    AC #1:
    Users have 3 options under their usernames.
    Given user is on the homePage
    When user click username on the right top corner
    Then verify there are “My Username” “My Configuration” “My Calendar” options
     */
    UsersCommonArea accountOptions = new UsersCommonArea();

    @Test
    public void AccountOptions() {
        ArrayList<String> driver = new ArrayList<>(Arrays.asList("user27" , "user28" , "user29"));

        for (String each : driver) {

            VyTrackUtil.login(each);

            getDriver().findElement(By.id("user-menu")).click();

            List<String> accountOptionList = new ArrayList<>();
            accountOptionList.addAll(Arrays.asList( "My User", "My Configuration", "My Calendar"));

            Assertions.assertEquals(accountOptionList, accountOptions.optionsGetText());

            VyTrackUtil.logOut();
        }


    }

}
