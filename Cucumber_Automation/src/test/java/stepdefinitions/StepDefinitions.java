package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

public class StepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    private static final int TIMEOUT_SECONDS = 15;

    //given wbsite
    @Given("I am on the {string} website")
    public void i_am_on_the_website(String url) {
        BaseClass.setUp();
        driver = BaseClass.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        driver.manage().window().maximize();
        driver.get(url);
    }
    
    
    
    //product link or MacBook pro link
    @When("I scroll to the {string} product")
    public void i_scroll_to_the_product(String productName) {
        By productLocator = By.xpath("//a[text()='" + productName + "']");
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
    }
    
    
    
    //Clicks product link
    @When("I click on the {string} product")
    public void i_click_on_the_product(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
    }
    
    
    
    //scroll to categories
    @When("I scroll to the {string} section")
    public void i_scroll_to_the_section(String sectionName) {
        By sectionLocator = By.xpath("//*[text()='" + sectionName + "']");
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
    }
    
    
    //Click the category link (Laptops)
    @And("I click on the {string} category")
    public void i_click_on_the_category(String categoryName) {
        // Clicks the category link (e.g., "Laptops")
        By categoryLocator = By.xpath("//a[text()='" + categoryName + "']");
        wait.until(ExpectedConditions.elementToBeClickable(categoryLocator)).click();
    }
    
    
    // Handles 'Add to cart' and 'Purchase button without filling details' 
    @And("I click the {string} button")
    public void i_click_the_simple_button(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + name + "']"))).click();
    }
    
    
    
    // Handles 'Place Order link or button', 'Purchase link or button', and 'OK link or button'
    @And("I click the {string} link or button")
    public void i_click_the_link_or_button(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + name + "']"))).click();
    }
    
    
    
    // Handles the unique "And I click "OK" link or button" pattern
    @And("I click {string} link or button")
    public void i_click_ok_link_or_button(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + name + "']"))).click();
    }
    
    
  
    //alert 
    @When("I accept the alert")
    public void i_accept_the_alert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    
    
   
    //navigate to cart page
    @When("I navigate to the cart page")
    public void i_navigate_to_the_cart_page() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();
        wait.until(ExpectedConditions.urlContains("cart"));
    }
    
    

    //scroll to purchase bbutton
    @When("I scroll to the {string} button")
    public void i_scroll_to_the_button(String buttonName) {
        By buttonLocator = By.xpath("//button[text()='" + buttonName + "']");
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
    }
    
    
    
    //click purchase button without filling details
    @And("I click the {string} button without filling details")
    public void i_click_the_purchase_without_details(String btn) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Purchase']"))).click();
    }
    
    
    
    //message alert
    @Then("I should see an alert message and accept it")
    public void i_should_see_alert_and_accept() {
       wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    
    
    
    //enter valid details
    @When("I enter valid purchase details")
    public void i_enter_valid_purchase_details() {
        WebElement modalContent = driver.findElement(By.className("modal-content"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Sam");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Chennai");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = 500;", modalContent);        
        driver.findElement(By.id("card")).sendKeys("1234567812345678");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");
    }
    
    
   
    //screenshot 
    @Then("I take a screenshot of a success message")
    public void i_take_screenshot_success() throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("Images/SuccessfullyPurchased" + System.currentTimeMillis() + ".png");
        if (dest.getParentFile() != null) {
            dest.getParentFile().mkdirs();
        }       
        Files.copy(src.toPath(), dest.toPath());
        System.out.println("Screenshot saved: " + dest.getAbsolutePath());
    }
    
    
    
    //success message
    @Then("I should see the success message")
    public void i_should_see_the_success_message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your purchase!']")));
    }
    
    
  
}

