package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    @BeforeEach
    public void setupWebDriver(){
        // Set up the driver and maximize the browser
        Driver.getDriver().manage().window().maximize();
        // Set up maximum period of time to load the browser
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void quitBrowser(){
        // Clear the WebDriver object making it null
        Driver.closeBrowser();
    }




}
