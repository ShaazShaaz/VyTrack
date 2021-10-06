package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    // Create private static field with name obj Data type
    // of variable should be WebDriver
    private static WebDriver obj;
    // Create private no arg constructor
    private Driver(){}
    public static WebDriver getDriver(){
        // Read the browser type u want to launch from properties file
        String browserName=ConfigReader.read("browser");
        // Read the browser type you want to launch from confif.properties file
        if (obj==null){
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid Browser Type " + browserName);

            }
            //  System.out.println("object not created. creating one now");
            //  WebDriverManager.chromedriver().setup();
            //  obj=new ChromeDriver();
        }else {
            //  System.out.println("object already exists");
            return obj;
        }
        return obj;
    }
    public static void closeBrowser(){
        if (obj!=null){
            obj.quit();
            obj=null;
        }

    }
}
