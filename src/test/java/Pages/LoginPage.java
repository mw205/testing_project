package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement emailFieldEle() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement passwordFieldEle() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement submitButtonEle() {
        return driver.findElement(By.cssSelector("button[type=\"submit\"][class=\"button-1 login-button\"]"));
    }
    public WebElement messageErrorEle() {
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }

    public void fillFrom(String email, String password) {
        emailFieldEle().sendKeys(email);
        passwordFieldEle().sendKeys(password);
    }
}
