package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver launchBrowser(String browserName) {

        switch (browserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();

            case "edge":
                return new EdgeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException("Invalid browser: " + browserName);
        }
    }
}
