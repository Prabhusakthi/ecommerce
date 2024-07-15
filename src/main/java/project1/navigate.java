package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

	public class navigate extends project1{
	    private WebDriver driver;

	    public navigate(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void navigateAndValidateMenu() {
	        List<WebElement> menuItems = driver.findElements(By.cssSelector("menu-item-selector"));
	        for (WebElement item : menuItems) {
	            item.click();
	            String expectedTitle = "Expected Title"; // Define expected titles based on the menu item
	            String actualTitle = driver.getTitle();
	            if (!actualTitle.equals(expectedTitle)) {
	                System.out.println("Title mismatch for menu item: " + item.getText());
	            }
	            driver.navigate().back();
	        }
	    }
	}



