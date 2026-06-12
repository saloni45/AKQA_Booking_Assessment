package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AgodaFlightPage;

public class FlightSearchTest extends BasePage {

    @Test
    public void searchFlights_Today() {

        AgodaFlightPage page = new AgodaFlightPage(driver);

        page.enterFromCity("Delhi");
        page.enterToCity("Mumbai");

        page.openCalendar();
        page.selectDate("today"); // assumption

        page.clickSearch();

        Assert.assertTrue(page.isResultsDisplayed(),
                "Flights should be displayed for today");
    }

    @Test
    public void searchFlights_Tomorrow() {

        AgodaFlightPage page = new AgodaFlightPage(driver);

        page.enterFromCity("Delhi");
        page.enterToCity("Mumbai");

        page.openCalendar();
        page.selectDate("tomorrow"); // assumption

        page.clickSearch();

        Assert.assertTrue(page.isResultsDisplayed(),
                "Flights should be displayed for tomorrow");
    }
}