package triangle;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class StepsDefinitions {

    private WebDriver driver = null;
    private WebDriverWait wait = null;
    private LocatorsList elements = new LocatorsList();

    @Before
    public void setUp() {
        this.driver = Helper.setupCalculatorOnBrowser();
        this.wait = new WebDriverWait(this.driver, 5);
    }

    @Given("open app on Chrome browser")
    public void openAppOnChrome() {
        this.driver.navigate().refresh();
    }

    @When("check what is displayed")
    public void checkAppLoaded() {
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath(this.elements.getHtmlTitle())));
        }
        catch(TimeoutException e) {
            System.out.println("Element not found!");
            this.driver.close();
        }
    }

    @Then("should see title, inputs and button")
    public void checkAppElements() {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath(this.elements.getMainTitle())));

            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath(this.elements.getSide1Label())));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath(this.elements.getSide2Label())));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath(this.elements.getSide3Label())));

            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id(this.elements.getSide1Input())));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id(this.elements.getSide2Input())));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id(this.elements.getSide3Input())));

            this.wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id(this.elements.getButton())));

            String actualMessage = this.driver.findElement
                    (By.id(this.elements.getClassificationMessage())).getText();
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

    @When("insert values (.*), (.*) and (.*)")
    public void insertSideValues(String side1, String side2, String side3) {
        try {
            this.driver.findElement
                    (By.id(this.elements.getSide1Input())).sendKeys(side1);
            this.driver.findElement
                    (By.id(this.elements.getSide2Input())).sendKeys(side2);
            this.driver.findElement
                    (By.id(this.elements.getSide3Input())).sendKeys(side3);
        }
        catch(NoSuchElementException e) {
            System.out.println("Element not found!");
            this.driver.close();
        }
    }

    @Then("the app should show message (.*)")
    public void classifyTriangle(String type) {
        try {
            this.driver.findElement
                    (By.id(this.elements.getButton())).click();
            this.wait.until(ExpectedConditions.textToBePresentInElementValue
                    (By.id(this.elements.getSide1Input()), ""));

            String actualMessage = this.driver.findElement
                    (By.id(this.elements.getClassificationMessage())).getText();
            assertEquals(type, actualMessage);
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

    @After
    public void tearDown() {
        this.driver.quit();
    }

}