package triangle;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class initialStateSteps {

    WebDriver driver;

    @Given("open app on Chrome browser")
    public void open_app_on_Chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "/home/talmeida/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://calculadoratriangulo.herokuapp.com");
    }

    @When("check what is displayed")
    public void check_what_is_displayed() {
        driver.findElement(By.xpath("//title[text()='Calculadora de Triângulos']"));
    }

    @Then("should see title, inputs and button")
    public void should_see_title_inputs_and_button() {
        driver.findElement(By.xpath("//h2[text()='Informe os Lados do Triângulo']"));

        driver.findElement(By.xpath("//label[text()='Lado 1:']"));
        driver.findElement(By.xpath("//label[text()='Lado 2:']"));
        driver.findElement(By.xpath("//label[text()='Lado 3:']"));

        driver.findElement(By.id("lado1"));
        driver.findElement(By.id("lado2"));
        driver.findElement(By.id("lado3"));

        driver.findElement(By.id("calcular"));

    }

}
