package com.turo.stepdef;

import com.turo.pages.SearchACar;
import com.turo.utils.ConfigurationReader;
import com.turo.utils.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.turo.pages.Base.waitSomeTime;

public class SearchACarSteps  {

    Logger logger = LoggerFactory.getLogger(SearchACarSteps.class);
    SearchACar searchACar = new SearchACar();

    @Given("user is on landing page to search")
    public void userIsOnLandingPageToSearch() {
        MyDriver.get().get(ConfigurationReader.getProperty("baseUrl"));

       // MyDriver.get().manage().deleteAllCookies();
        // MyDriver.get().navigate().refresh();
        waitSomeTime(5L);
        String expected = "Turo | The world's largest car sharing marketplace";
        String actual = MyDriver.get().getTitle();
        Assert.assertEquals(expected,actual);

        logger.info("Turo.com website title is {}", actual);

    }

    @Then("User enter {string} in Where text box")
    public void userEnterInWhereTextBox(String location) {
        searchACar.enterLocation(location);

    }
    @Then("User select {string} and {string} under From")
    public void userSelectAndUnderFrom(String dateFrom, String dateUntil) {
        searchACar.startDateAndTime(dateFrom, dateUntil);
    }
    @Then("User select {string} and {string} under Until")
    public void userSelectAndUnderUntil(String date, String time) {
        searchACar.endDateAndTime(date, time);
    }

    @Then("User clicks Search button")
    public void userClicksSearchButton() {
        searchACar.clickSearchButton();
    }

    @And("User clicks on More filters menu and select All-Star Host")
    public void userClicksOnMoreFiltersMenuAndSelectAllStarHost() {
        searchACar.moreFiltersOptions();
    }

    @And("select CAR Vehicle types and select {string} then clicks on upper arrow")
    public void selectCARVehicleTypesAndSelectThenClicksOnUpperArrow(String vehicle_makes) {
        searchACar.selectCarAndVehicleMakes(vehicle_makes);
    }

    @And("User adjust the Vehicle years range")
    public void userAdjustTheVehicleYearsRange() {
    }

    @Then("User select the Transmission clicks on view results")
    public void userSelectTheTransmissionClicksOnViewResults() {
    }

    @And("User clicks on Sort By menu and select an option then clicks on apply")
    public void userClicksOnSortByMenuAndSelectAnOptionThenClicksOnApply() {
    }

    @And("User clicks on Price menu and adjust the price range then clicks on view results")
    public void userClicksOnPriceMenuAndAdjustThePriceRangeThenClicksOnViewResults() {
    }

    @And("User clicks on Book instantly menu and clicks on view results")
    public void userClicksOnBookInstantlyMenuAndClicksOnViewResults() {
    }

    @And("User clicks on Delivery menu and adjust the distance range then clicks on view results")
    public void userClicksOnDeliveryMenuAndAdjustTheDistanceRangeThenClicksOnViewResults() {
    }

    @And("User clicks on Distance included menu and select the distance then clicks on  apply button")
    public void userClicksOnDistanceIncludedMenuAndSelectTheDistanceThenClicksOnApplyButton() {
    }

    @Then("User selects the first car in the list")
    public void userSelectsTheFirstCarInTheList() {
    }

    @And("Verify that Pickup & return location is present")
    public void verifyThatPickupReturnLocationIsPresent() {
    }

    @Then("User selects Pickup & return location")
    public void userSelectsPickupReturnLocation() {
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
    }

}
