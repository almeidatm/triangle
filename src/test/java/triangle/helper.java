package triangle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class helper {

    public static WebDriver setupCalculatorOnBrowser() {
        WebDriver driver;
        String projectDir = System.getProperty("user.dir");
        String driverPath = projectDir + "/drivers/chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://calculadoratriangulo.herokuapp.com");
        return driver;
    }
}