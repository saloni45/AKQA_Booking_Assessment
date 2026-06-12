package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.time.LocalDate;

public class AgodaFlightPage {

    WebDriver driver;
    WebDriverWait wait;

    public AgodaFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openFlightsTab() {
        driver.findElement(By.id("tab-flight-tab")).click();
    }

    public void selectOrigin() {

        driver.findElement(
                        By.id("flight-origin-search-input"))
                .sendKeys("Mumbai");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//ul[@role='listbox']//li[contains(@data-text,'Navi Mumbai International Airport')])[1]")))
                .click();
    }

    public void selectDestination() {

        driver.findElement(
                        By.id("flight-destination-search-input"))
                .sendKeys("New Delhi");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//ul[@role='listbox']//li[contains(@data-text,'Indira Gandhi International Airport')])[1]")))
                .click();
    }

    public void selectTomorrowDate() {

        String tomorrowDate =
                LocalDate.now().plusDays(1).toString();

        WebElement tomorrowElement =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@data-selenium-date='" +
                                tomorrowDate +
                                "']/ancestor::div[@role='button']")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);",
                        tomorrowElement);

        wait.until(ExpectedConditions.elementToBeClickable(
                tomorrowElement)).click();
    }

    public void addAdultPassenger() {

        WebElement plusButton =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-selenium='plus' and @data-element-name='flight-occupancy-adult-increase']")));

        plusButton.click();
    }

    public String getPassengerText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(text(),'2 Passengers, Economy')]")
                )).getText();
    }

    public void clickDone() {

        driver.findElement(
                        By.xpath("(//div[@class='SearchBoxTextDescription__title'])[2]"))
                .click();
    }

    public void searchFlights() {

        driver.findElement(
                        By.xpath("//button[@data-element-name='flight-search']"))
                .click();
    }

    public String getSearchResultTitle() {
        // Wait until the real title text appears (not the loading placeholder)
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//h2[@data-testid='title']"),
                "Flights from"
        ));

        // Now safely return the final title text
        return driver.findElement(By.xpath("//h2[@data-testid='title']")).getText();
    }
    public String getFlightErrorModalMessage() {
        // Wait for the modal to appear
        WebElement modalMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-component='flight-error-modal']//div[@data-element-name='search-box-modal-message']")
        ));

        // Return the message text
        return modalMessage.getText();
    }

}