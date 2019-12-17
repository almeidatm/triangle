package triangle;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;

public class stepsDefinitions {

    WebDriver driver;

    @Given("open app on Chrome browser")
    public void open_app_on_Chrome_browser() {
        this.driver = helper.setupCalculatorOnBrowser();
    }

    @When("check what is displayed")
    public void check_what_is_displayed() {
        this.driver.findElement(By.xpath("//title[text()='Calculadora de Triângulos']"));
    }

    @When("input {specialChar} symbol in any input")
    public void input_symbol_in_any_input(String specialChar) {
        this.driver.findElement(By.id("lado1")).sendKeys(specialChar);
        this.driver.findElement(By.id("lado1")).sendKeys("1");
        this.driver.findElement(By.id("lado1")).sendKeys("1");
    }

    @When("negative values as triangle sides size")
    public void negative_values_as_triangle_sides_size() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("should see title, inputs and button")
    public void should_see_title_inputs_and_button() {
        this.driver.findElement(By.xpath("//h2[text()='Informe os Lados do Triângulo']"));

        this.driver.findElement(By.xpath("//label[text()='Lado 1:']"));
        this.driver.findElement(By.xpath("//label[text()='Lado 2:']"));
        this.driver.findElement(By.xpath("//label[text()='Lado 3:']"));

        this.driver.findElement(By.id("lado1"));
        this.driver.findElement(By.id("lado2"));
        this.driver.findElement(By.id("lado3"));

        this.driver.findElement(By.id("calcular"));

        String currentMessage = this.driver.findElement(By.id("message")).getText();
        assertEquals("", currentMessage);

        this.driver.close();
    }

    @Then("no triangle type message should be displayed")
    public void no_triangle_type_message_should_be_displayed() {
        String currentMessage = this.driver.findElement(By.id("message")).getText();
        assertEquals("", currentMessage);

        this.driver.close();
    }

}
