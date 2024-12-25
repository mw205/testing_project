package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("user go to login page")
    public void navigateToLoginPage() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(6000L);
        homePage.loginButtonEle().click();
    }

    @When("^When user enter \"(.*)\" and \"(.*)\"$")
    public void enterValidData(String email, String password) throws InterruptedException {
        Thread.sleep(5000L);
        loginPage.fillFrom(email, password);
        Thread.sleep(1000L);
        loginPage.submitButtonEle().click();
        Thread.sleep(5000L);
    }

    @And("User click on login button")
    public void clickLoginButton() throws InterruptedException {
        loginPage.submitButtonEle().click();
        Thread.sleep(5000L);
    }

    @Then("User could login successfully and navigate to home page")
    public void loginIsSuccess() {
        Assert.assertTrue(homePage.logoutButtonEle().isDisplayed());
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

    @When("user enter invalid userName and password")
    public void enterInvalidData() throws InterruptedException {
        Thread.sleep(5000L);
        loginPage.fillFrom("mohamedabdelghany@gmail.com", "Mohamed205");

        Thread.sleep(1000L);
        loginPage.submitButtonEle().click();
        Thread.sleep(5000L);
    }

    @Then("User couldn't login successfully")
    public void loginIsFailure() {
        Assert.assertTrue(loginPage.messageErrorEle().isDisplayed());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
