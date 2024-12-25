package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage {
    final WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement resetPasswordButtonEle() {
        return driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]"));
    }

    public WebElement emailFieldEle() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement sendEmailFieldEle() {
        return driver.findElement(By.name("send-email"));
    }


    public WebElement successBarEle() {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement errorBarEle() {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification error\"]"));
    }

}
