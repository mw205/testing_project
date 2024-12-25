package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ResetPasswordPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPasswordStepDefinition {
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("user navigate to login page")
    public void goToLoginPage() throws InterruptedException {
        // open the browser and go to our app
        driver.navigate().to("https://demo.nopcommerce.com/");
        //maximize the window
        driver.manage().window().maximize();
        Thread.sleep(2000L);

        homePage.loginButtonEle().click();
        // choose the gender (Male)
        Thread.sleep(5000L);
    }

    @When("user click on forgetPassword")
    public void clickForgetPassword() throws InterruptedException {
        Thread.sleep(3000L);
        resetPasswordPage.resetPasswordButtonEle().click();
        Thread.sleep(3000L);
    }

    @Then("^user navigate to forgetPage and enter his email \"(.*)\"$")
    public void enterCorrectEmail(String email) {
        resetPasswordPage.emailFieldEle().sendKeys(email);
    }

    @Then("user navigate to forgetPage and enter incorrect email")
    public void enterIncorrectEmail() {
        resetPasswordPage.emailFieldEle().sendKeys("user@gmail.com");
    }

    @And("user click on Recovery Button")
    public void clickRecoveryButton() {
        resetPasswordPage.resetPasswordButtonEle().click();
    }

    @And("password will be reset")
    public void passwordResetSuccessfully() {
        Assert.assertTrue(resetPasswordPage.successBarEle().isDisplayed());
    }

    @And("password will not be reset")
    public void passwordResetUnSuccessfully() {
        Assert.assertTrue(resetPasswordPage.errorBarEle().isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
