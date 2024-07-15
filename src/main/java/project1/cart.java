package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cart extends project1{
    private WebDriver driver;

    public cart(WebDriver driver) {
        this.driver = driver;
    }

    public void searchAndAddToCart(String itemName) {
        driver.findElement(By.id("search-box-id")).sendKeys(itemName);
        driver.findElement(By.id("search-button-id")).click();
        driver.findElement(By.cssSelector("first-result-item-selector")).click();
        driver.findElement(By.id("add-to-cart-button-id")).click();
    }
}


