package triangle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {

    public static WebDriver setupCalculatorOnBrowser() {
        WebDriver driver;
        String projectDir = System.getProperty("user.dir");
        String driverPath = projectDir + "/drivers/chromedriver_linux";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.get("https://calculadoratriangulo.herokuapp.com");
        return driver;
    }
}