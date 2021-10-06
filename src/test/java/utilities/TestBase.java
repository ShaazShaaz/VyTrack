package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeEach
    public void setUpVyTrackApp(){
        Driver.getDriver().get(ConfigReader.read("url"));
        Driver.getDriver().manage().window().maximize();
    }




    @BeforeEach
    public void setupWebImplicitWait() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   /* @AfterEach
    public void quitBrowser(){

        Driver.closeBrowser();
    }

    */


}
