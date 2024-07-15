package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dummypayment extends project1{
	    private WebDriver driver;

	    public dummypayment(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void checkout() {
	        driver.findElement(By.id("cart-icon-id")).click();
	        driver.findElement(By.id("checkout-button-id")).click();
	        driver.findElement(By.id("payment-info-id")).sendKeys("dummy card details");
	        driver.findElement(By.id("place-order-button-id")).click();

	        // Verify order confirmation
	        String confirmationMessage = driver.findElement(By.id("order-confirmation-message-id")).getText();
	        if (confirmationMessage.contains("Thank you for your order")) {
	            System.out.println("Order placed successfully!");
	        } else {
	            System.out.println("Order placement failed!");
	        }
	    }	
}
