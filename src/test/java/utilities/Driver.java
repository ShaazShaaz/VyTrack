package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver obj;
    private Driver(){

    }
    public static WebDriver getDriver(){
        // read the browser type u want to launch from properties file
        String browserName=ConfigReader.read("browser");

        if (obj==null){
            switch (browserName.toLowerCase().trim()) {
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
