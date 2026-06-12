package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static utils.BrowserFactory.launchBrowser;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        driver = launchBrowser(browser);

        driver.manage().window().maximize();

        driver.get("https://www.agoda.com");
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}