package com.turo.pages;

import com.turo.utils.MyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedSearch extends Base {
    Logger logger = LoggerFactory.getLogger(AdvancedSearch.class);
    MyDriver myDriver = new MyDriver();


    @FindBy(xpath = "//div[@class='searchFilter desktopMoreFilters']//button[@type='button']")
    public WebElement moreFiltersButton;

    @FindBy(xpath = "//label[@for='allStarHost']//span[@class='styledCheckbox-label']")
    public WebElement allStarHost;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[7]//div[2]//div[1]//span[1]")
    public WebElement vehicleTypesButton;

    @FindBy(xpath = "//span[@class='imageMultiSelectOption-icon typeIcon typeIcon--car']")
    public WebElement car;

    @FindBy(xpath = "//select[@id='makes']")
    public WebElement vehicleMakes;

    @FindBy(xpath = "//option[@value='Lexus']")
    public WebElement lexus;

    @FindBy(xpath = "//span[@class='rangeSliderField-label']")
    public WebElement yearText;

    @FindBy(xpath = "//div[contains(text(), 'Number of seats')]")
    public WebElement yearSlider;

    public void moreFiltersOptions() {
            moreFiltersButton.click();
            allStarHost.click();
        }

    public void selectCarAndVehicleMakes(String vehicle_makes) {
            vehicleTypesButton.click();
            car.click();

            waitSomeTime(2L);
            Select select = new Select(vehicleMakes);
            scrollDown(lexus);
            waitSomeTime(3L);
            select.selectByVisibleText(vehicle_makes);
        }
    }
