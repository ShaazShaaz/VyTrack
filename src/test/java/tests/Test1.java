package tests;

import org.junit.jupiter.api.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class Test1 extends TestBase {
    @Test
    public void search(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }
}
