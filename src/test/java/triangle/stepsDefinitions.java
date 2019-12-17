package triangle;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class stepsDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("open app on Chrome browser")
    public void open_app_on_Chrome_browser() {
        this.driver = helper.setupCalculatorOnBrowser();
        this.wait = new WebDriverWait(this.driver, 5);
    }

    @When("check what is displayed")
    public void check_what_is_displayed() {
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//title[text()='Calculadora de Triângulos']")));
        }
        catch(TimeoutException e) {
            System.out.println("Element not found!");
            this.driver.close();
        }
    }

    @When("input (.*) symbol in any input")
    public void input_symbol_in_any_input(String specialChar) {
        try {
            this.driver.findElement(By.id("lado1")).sendKeys(specialChar);
            this.driver.findElement(By.id("lado2")).sendKeys("1");
            this.driver.findElement(By.id("lado3")).sendKeys("1");
        }
        catch(NoSuchElementException e) {
            System.out.println("Element not found!");
            this.driver.close();
        }
    }

    @When("negative values are set as triangle sides size")
    public void negative_values_are_set_as_triangle_sides_size() {
        try {
            this.driver.findElement(By.id("lado1")).sendKeys("-1");
            this.driver.findElement(By.id("lado2")).sendKeys("-1");
            this.driver.findElement(By.id("lado3")).sendKeys("-1");
        }
        catch(NoSuchElementException e) {
            System.out.println("Element not found!");
            this.driver.close();
        }
    }

    @When("no values are set as triangle sides size")
    public void no_values_are_set_as_triangle_sides_size() {
        try {
            this.driver.findElement(By.id("lado1")).sendKeys("");
            this.driver.findElement(By.id("lado2")).sendKeys("");
            this.driver.findElement(By.id("lado3")).sendKeys("");
        }
        catch(NoSuchElementException e) {
            System.out.println("Element not found!");
            this.driver.close();
        }
    }

    @Then("should see title, inputs and button")
    public void should_see_title_inputs_and_button() {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//h2[text()='Informe os Lados do Triângulo']")));

            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//label[text()='Lado 1:']")));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//label[text()='Lado 2:']")));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//label[text()='Lado 3:']")));

            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("lado1")));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("lado2")));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("lado3")));

            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("calcular")));

            String actualMessage = this.driver.findElement(By.id("message")).getText();
            assertEquals("", actualMessage);
        }
        catch(TimeoutException e) {
            System.out.println("Element not found!");
        }
        catch(NoSuchElementException e) {
            System.out.println("Element not found!");
        }
        finally {
            this.driver.close();
        }
    }

    @Then("no triangle type message should be displayed")
    public void no_triangle_type_message_should_be_displayed() {
        try {
            this.driver.findElement(By.id("calcular")).click();
            this.wait.until(ExpectedConditions.textToBePresentInElementValue
                    (By.id("lado1"), ""));

            String actualMessage = this.driver.findElement(By.id("message")).getText();
            assertEquals("", actualMessage);
        }
        catch(TimeoutException e) {
            System.out.println("Element not found!");
        }
        catch(NoSuchElementException e) {
            System.out.println("Element not found!");
        }
        finally {
            this.driver.close();
        }
    }

    @Then("fill all sides size message should be displayed")
    public void fill_all_sides_size_message_should_be_displayed() {
        try {
            this.driver.findElement(By.id("calcular")).click();
            this.wait.until(ExpectedConditions.textToBePresentInElementValue
                    (By.id("lado1"), ""));

            String actualMessage = this.driver.findElement(By.id("message")).getText();
            assertEquals("Preencha todos os lados", actualMessage);
        }
        catch(TimeoutException e) {
            System.out.println("Element not found!");
        }
        catch(NoSuchElementException e) {
            System.out.println("Element not found!");
        }
        finally {
            this.driver.close();
        }
    }

}
