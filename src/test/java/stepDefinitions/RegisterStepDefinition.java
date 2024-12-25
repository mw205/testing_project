package stepDefinitions;

import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterStepDefinition {
    WebDriver driver = new ChromeDriver();
    RegisterPage registerPage = new RegisterPage(driver);
    HomePage homePage = new HomePage(driver);

    @Before
    public void openBrowser() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //maximize the window
        driver.manage().window().maximize();
        Thread.sleep(2000L);

    }

    @Given("User go to register page")
    public void goToRegisterPage() throws InterruptedException {
        homePage.registerButtonEle().click();
        // choose the gender (Male)
        Thread.sleep(2000L);
    }

    @When("User select the type of gender")
    public void selectGender() throws InterruptedException {
        registerPage.genderMaleButtonEle().click();
        Thread.sleep(1000L);
    }

    @And("User enter the first and last name")
    public void enterFirstAndLastName() throws InterruptedException {
        registerPage.enterFirstNameAndLastName("Mohamed", "Waleed");

        Thread.sleep(2000L);
    }

    @And("User enter the date of birth")
    public void enterDateOfBirth() throws InterruptedException {

        registerPage.enterBirthDay("20", "5", "2003");

        Thread.sleep(3000L);
    }

    @And("User enter the email")
    public void enterEmail() {
        registerPage.emailFieldEle().sendKeys("mw99746@gmail.com");
    }

    @And("User enter password and confirm the password")
    public void enterPasswordAndConfirmPassword() {
        registerPage.enterPasswordAndConfirmation("Mw205@@", "Mw205@@");
    }

    @And("User click on register button")
    public void clickRegisterButton() throws InterruptedException {
        Thread.sleep(1000L);
        registerPage.registerSubmitButtonEle().click();
    }

    @Then("success message is displayed")
    public void registerSuccess() throws InterruptedException {
        Thread.sleep(5000L);
        String expectedResult = "Your registration completed";
        String actualResult = registerPage.resultBarEle().getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

