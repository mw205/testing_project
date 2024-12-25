package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement logoutButtonEle() {
        return driver.findElement(By.id("ico-logout"));
    }

    public WebElement loginButtonEle() {
        return driver.findElement(By.className("ico-login"));
    }

    public WebElement registerButtonEle() {
        return driver.findElement(By.className("ico-register"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.xpath("//button[contains(@onclick, '/addproducttocart/catalog/1/1/1')]"));
    }
}
