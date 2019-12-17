package triangle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class helper {

    public static WebDriver setupCalculatorOnBrowser(){
        WebDriver driver;
        String driverPath="/Users/almeidatm/Workstuff/cucumber/chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://calculadoratriangulo.herokuapp.com");
        return driver;
    }
}