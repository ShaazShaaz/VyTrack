package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import pages.OroPage;
import pages.UsersCommonArea;
import pages.VyTrackLoginPage;
import utilities.Driver;
import utilities.TestBase;
import utilities.VyTrackUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utilities.Driver.getDriver;
import static utilities.VyTrackUtil.takeSnapShot;
import static utilities.VyTrackUtil.waitFor;

public class us10_ extends TestBase {
    /*
Story: As a user, I should be accessed to Oro Documentation page.

AC #1: user access Oro Documentation page
 //Given user is on the homePage
 //When user click question icon on the right top of the homepage

Then verify user accessed to Oro Documentation page

     */


    @Test
    public void userAccessOroPage() throws Exception {
        //Given user is on the homePage
        ArrayList<String> user = new ArrayList<>(Arrays.asList("user27"));
        VyTrackLoginPage page = new VyTrackLoginPage();
        for (String each : user) {
            page.openVyTrackApp();
            page.login(each);
            VyTrackUtil.waitFor(2);


            //   OroPage oroPage=new OroPage();
//                   VyTrackUtil.waitFor(2);
            // oroPage.questionMark.click();

            WebElement questionMark = getDriver().findElement(By.xpath("//i[@class='fa-question-circle']"));
            questionMark.click();

            // Driver.getDriver().findElement(By.xpath("//i[@class='fa-question-circle']")).click();

            Set<String> allHandles = Driver.getDriver().getWindowHandles();
            assertEquals(allHandles.size(), 2);

            for (String eachHandle : allHandles) {
                Driver.getDriver().switchTo().window(eachHandle);
            }
            System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
            assertEquals("Welcome to Oro Documentation", Driver.getDriver().getTitle());
            //  Driver.getDriver().switchTo().window(eachHandle);


            //    page.logOut();
        }
    }


//            String currentHandle= getDriver().getWindowHandle();
//            //When user click question icon on the right top of the homepage
//           // takeSnapShot(Driver.getDriver(), "C://Users/palek/OneDrive/Desktop/VyTrackProject TestEvidence/test1.png");
//            WebElement oroPageBtn = getDriver().findElement(By.xpath("//i[@title='Get help']"));
//            oroPageBtn.click();
//            waitFor(2);
////
//            //String oroHandle=Driver.getDriver().getWindowHandle();
//            String oroTittleActual=Driver.getDriver().getWindowHandle();
//            waitFor(2);
//            assertEquals("Welcome to Oro Documentation",oroTittleActual);
//            Driver.getDriver().switchTo().window(currentHandle);
//            //Set<String> windowHandles = Driver.getDriver().getWindowHandles();



          /*  for (String eachWindow : windowHandles) {
                Driver.getDriver().switchTo().window(eachWindow);
                //System.out.println("eachWindow = " + eachWindow);
                if (Driver.getDriver().getCurrentUrl().contains("oro")) {
                    // System.out.println(Driver.getDriver().getCurrentUrl());
                    //System.out.println("Driver.getDriver().getTitle() = " + getDriver().getTitle());
                    break;
                }
                getDriver().switchTo().window(currentHandle);

            }*/


    //takeSnapShot(Driver.getDriver(), "C://Users/palek/OneDrive/Desktop/VyTrackProject TestEvidence/test2.png");

    // Driver.getDriver().switchTo().window(windowHandle);

    // getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
    //  getDriver().switchTo().defaultContent();
    //VyTrackUtil.waitFor(2);
    //Actions action= new Actions(getDriver());
    // action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).perform();

    //Then verify user accessed to Oro Documentation page

    //  takeSnapShot(Driver.getDriver(), "C://Users/palek/OneDrive/Desktop/VyTrackProject TestEvidence/test2.png");
    //VyTrackUtil.waitFor(2);


}


