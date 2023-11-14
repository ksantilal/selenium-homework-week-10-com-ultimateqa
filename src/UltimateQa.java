import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Project-5 - ProjectName : com-utimateqa
 * BaseUrl = https://courses.ultimateqa.com/js-homework-week9-
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */

public class UltimateQa {
    static String browser = "Chrome";

    static String baseURL = "https://courses.ultimateqa.com/users/sign_in";

    static WebDriver driver;

    public static void main(String[] args) {
        // 1. Set up Chrome Browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webDriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("FireFox")) {
            System.setProperty("webDriver.gecko.driver", "src/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webDriver.edge.driver", "src/drivers/msedgedriver.exe");
            WebDriver driver = new EdgeDriver();

        } else {
            System.out.println("Not valid browser");
        }
        // 2. Open Url.
        driver.get(baseURL); // Method to invoke URL
        driver.manage().window().maximize(); // Maximizing windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Timeout session

        String title = driver.getTitle(); // Storing title
        System.out.println("Title of the page :" + title); // Printing title in the console

        String source = driver.getPageSource();
        System.out.println("Page source :" + source);

        driver.findElement(By.id("user[email]")).click();
        WebElement emailIdField = driver.findElement(By.id("user[email]")); // Storing email fields
        emailIdField.sendKeys("smartvalue@gmail.com"); // Sending keys to email id field

        driver.findElement(By.id("user[password]")).click();
        WebElement passwordField = driver.findElement((By.id("user[password]"))); // Storing password field
        passwordField.sendKeys("Abc1234"); // Sendkeys to password field

       driver.quit();//closre the browser
    }
}






