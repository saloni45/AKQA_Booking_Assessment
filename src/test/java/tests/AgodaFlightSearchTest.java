package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AgodaFlightPage;

public class AgodaFlightSearchTest extends BaseTest {

    @Test
    public void verifyFlightSearch() {

        AgodaFlightPage flightPage =
                new AgodaFlightPage(driver);

        flightPage.openFlightsTab();

        flightPage.selectOrigin();

        flightPage.selectDestination();

        flightPage.selectTomorrowDate();

        flightPage.addAdultPassenger();

        Assert.assertEquals(
                flightPage.getPassengerText(),
                "2 Passengers, Economy");

        flightPage.clickDone();

        flightPage.searchFlights();

        Assert.assertEquals(
                flightPage.getSearchResultTitle(),
                "Flights from Mumbai to New Delhi");

        System.out.println("Flight Search Test Passed");
    }

    @Test
    public void verifyBlankField(){
        AgodaFlightPage flightPage =
                new AgodaFlightPage(driver);
        flightPage.openFlightsTab();
        flightPage.searchFlights();
        String actualMessage = flightPage.getFlightErrorModalMessage();
        String expectedMessage = "Please enter the origin, destination and your travel date to proceed.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}