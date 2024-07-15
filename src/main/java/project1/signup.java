package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signup {
	    private WebDriver driver;

	    public signup(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void signUp(String email, String password) {
	        // Locate and interact with sign-up elements
	        driver.findElement(By.id("sign-up-button-id")).click();
	        driver.findElement(By.id("email-field-id")).sendKeys("prabhakarn2631994@gmail.com");
	        driver.findElement(By.id("password-field-id")).sendKeys("Prabhu03!");
	        driver.findElement(By.id("submit-button-id")).click();
	    }

	    public void login(String email, String password) {
	        // Locate and interact with login elements
	        driver.findElement(By.id("login-button-id")).click();
	        driver.findElement(By.id("email-field-id")).sendKeys("prabhakaran2631994@gmail.com");
	        driver.findElement(By.id("password-field-id")).sendKeys("Prabhu03!");
	        driver.findElement(By.id("submit-button-id")).click();
	    }
	}



