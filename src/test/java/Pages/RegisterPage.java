package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement genderMaleButtonEle() {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement firstNameFieldEle() {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement lastNameFieldEle() {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement dayOfBirthEle() {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement monthOfBirthEle() {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement yearOfBirthEle() {
        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement emailFieldEle() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement passwordFieldEle() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement confirmPasswordFieldEle() {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerSubmitButtonEle() {
        return driver.findElement(By.id("register-button"));
    }

    public WebElement resultBarEle() {
        return driver.findElement(By.className("result"));
    }

    public void enterFirstNameAndLastName(String firstName, String lastName) {
        firstNameFieldEle().sendKeys(firstName);

        lastNameFieldEle().sendKeys(lastName);
    }

    public void enterBirthDay(String day, String monthNumber, String year) {
        Select selectBirthDay = new Select(dayOfBirthEle());
        selectBirthDay.selectByValue(day);


        Select selectBirthMonth = new Select(monthOfBirthEle());
        selectBirthMonth.selectByValue(monthNumber);

        Select selectBirthYear = new Select(yearOfBirthEle());
        selectBirthYear.selectByValue(year);
    }

    public void enterPasswordAndConfirmation(String password, String confirmPassword) {

        passwordFieldEle().sendKeys(password);
        confirmPasswordFieldEle().sendKeys(confirmPassword);
    }
}
