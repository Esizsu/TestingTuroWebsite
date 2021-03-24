package com.turo.stepdef;

import com.turo.pages.SelectTheFirstCar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectTheFirstCarSteps {
    Logger logger = LoggerFactory.getLogger(AdvancedSearchSteps.class);
    SelectTheFirstCar selectTheFirstCar = new SelectTheFirstCar();

    @Given("user is on landing page to select")
    public void userIsOnLandingPageToSelect() {
    }


    @And("User selects the first car in the list")
    public void userSelectsTheFirstCarInTheList() {
    }


    @And("Users verify the selected car title is present")
    public void usersVerifyTheSelectedCarTitleIsPresent() {
    }

    @Then("User selects Pickup location")
    public void userSelectsPickupLocation() {
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
    }

}
