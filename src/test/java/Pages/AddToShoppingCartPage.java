package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddToShoppingCartPage {
    final WebDriver driver;

    public AddToShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProcessorByVisibleText(String value) {
        processorDropdownEle().selectByVisibleText(value);
    }

    public void selectRamByVisibleText(String value) {
        ramDropdownEle().selectByVisibleText(value);
    }

    public void selectHddOptionByIndex(int index) {
        hddOptionEle(index).click();
    }

    public void selectOsOptionByIndex(int index) {
        osOptionEle(index).click();
    }

    public Select processorDropdownEle() {
        return new Select(driver.findElement(By.id("product_attribute_1")));
    }

    public Select ramDropdownEle() {
        return new Select(driver.findElement(By.id("product_attribute_2")));
    }

    public List<WebElement> hddOptionsEle() {
        return driver.findElements(By.xpath("//input[@name='product_attribute_3']"));
    }

    public WebElement hddOptionEle(int index) {
        return hddOptionsEle().get(index - 1);
    }

    public List<WebElement> osOptionsEle() {
        return driver.findElements(By.xpath("//input[@name='product_attribute_4']"));
    }

    // normal numbers
    public WebElement osOptionEle(int index) {
        return osOptionsEle().get(index - 1);
    }

    public WebElement addToCartConfirmButton() {
        return driver.findElement(By.id("add-to-cart-button-1"));
    }

    public WebElement notificationSuccessBarEle() {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }


}
