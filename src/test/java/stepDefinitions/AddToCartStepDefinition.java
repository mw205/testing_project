package stepDefinitions;

import Pages.AddToShoppingCartPage;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartStepDefinition {
    WebDriver driver = new ChromeDriver();
    AddToShoppingCartPage cartPage = new AddToShoppingCartPage(driver);
    HomePage homePage = new HomePage(driver);

    @Before
    public void openBrowser() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //maximize the window
        driver.manage().window().maximize();
        Thread.sleep(2000L);
    }

    @When("user click on the add to cart button")
    public void clickAddToCartButton() {
        homePage.getAddToCartButton().click();
    }

    @And("choose the specified features of the product")
    public void chooseFeaturesOfProduct() throws InterruptedException {
        Thread.sleep(10000L);
        cartPage.selectProcessorByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        cartPage.selectRamByVisibleText("8GB [+$60.00]");
        cartPage.selectHddOptionByIndex(0);
        cartPage.selectOsOptionByIndex(1);
    }

    @And("confirm adding to shopping cart")
    public void confirmAddToCart() {
        cartPage.addToCartConfirmButton().click();
    }

    @Then("The product added successfully to shopping cart")
    public void productAddToCartSuccess() throws InterruptedException {
        Thread.sleep(6000L);
        Assert.assertTrue(cartPage.notificationSuccessBarEle().isDisplayed());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
