package project1;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class project1 {

	private WebDriverWait wait;
	public static void main(String[] args) {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\project\\project1\\src\\main\\java\\project1\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);

                
        // Maximize the browser window
        driver.manage().window().maximize();
      
        try {
            // Navigate to Best Buy website
            driver.get("https://www.bestbuy.com/");

            // Example: Adding an item to the cart
            // Search for a product and add it to cart
            WebElement searchBox = driver.findElement(By.id("gh-search-input"));
            searchBox.sendKeys("laptop");
            searchBox.submit();

            // Click on the first search result
            WebElement firstProduct = driver.findElement(By.cssSelector(".sku-title a"));
            firstProduct.click();

            // Add to cart
            WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart-button"));
            addToCartButton.click();

            // Example: Checking out
            // Go to cart
            WebElement cartLink = driver.findElement(By.cssSelector(".cart-link"));
            cartLink.click();

            // Proceed to checkout
            WebElement checkoutButton = driver.findElement(By.cssSelector(".btn-primary"));
            checkoutButton.click();

            // Example: Verification of page content
            // Verify checkout page title
            String checkoutTitle = driver.getTitle();
            if (checkoutTitle.contains("Checkout")) {
                System.out.println("Checkout page title verification passed.");
            } else {
                System.out.println("Checkout page title verification failed.");
            }

            // Example: Sign Up functionality
            // Navigate to sign up page and fill out the form
            driver.get("https://www.bestbuy.com/identity/signin");
            WebElement signUpLink = driver.findElement(By.cssSelector(".create-account"));
            signUpLink.click();

            WebElement emailInput = driver.findElement(By.id("fld-e"));
            emailInput.sendKeys("prabhu2631994@gmail.com");

            WebElement passwordInput = driver.findElement(By.id("fld-p1"));
            passwordInput.sendKeys("Prabhu03!");

            WebElement createAccountButton = driver.findElement(By.cssSelector(".cia-form__submit-button"));
            createAccountButton.click();

            // Verify sign up success
            WebElement signUpSuccessMessage = driver.findElement(By.cssSelector(".cia-content h1"));
            if (signUpSuccessMessage.getText().equals("Thanks for joining Best Buy!")) {
                System.out.println("Sign Up successful.");
            } else {
                System.out.println("Sign Up failed.");
            }

            // Example: Login functionality
  
            // Navigate to login page and login with valid credentials
            driver.get("https://www.bestbuy.com/identity/signin");
            WebElement emailLoginInput = driver.findElement(By.id("fld-e"));
            emailLoginInput.sendKeys("prabhu2631994@gmail.com");

            WebElement passwordLoginInput = driver.findElement(By.id("fld-p1"));
            passwordLoginInput.sendKeys("Prabhu03!");

            WebElement signInButton = driver.findElement(By.cssSelector(".cia-form__submit-button"));
            signInButton.click();

            // Verify login success
            WebElement userMenu = driver.findElement(By.cssSelector(".user-profile"));
            if (userMenu.isDisplayed()) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Login failed.");
            }

            // Example: Checking for broken URLs on the home page
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            for (WebElement link : allLinks) {
                String url = link.getAttribute("href");
                if (url != null && !url.isEmpty()) {
                    int responseCode = getResponseCode(url);
                    if (responseCode != 200) {
                        System.out.println("Broken link found: " + url);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the WebDriver session
            driver.quit();
        }
    }

    // Helper method to get HTTP response code
    private static int getResponseCode(String url) {
        int responseCode = 0;
        try {
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) new java.net.URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }

	public WebDriverWait getWait() {
		return wait;
	}

}

