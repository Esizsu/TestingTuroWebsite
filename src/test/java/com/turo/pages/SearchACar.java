package com.turo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchACar extends Base{
    Logger logger = LoggerFactory.getLogger(SearchACar.class);

    @FindBy(xpath = "//input[@id='searchFormLocationTypeahead-input']")
    public WebElement typeLocation;

    @FindBy(xpath = "//div[@class='seo-pages-19ve007-SuggestionTextTitle ee6ccll1'][normalize-space()='Los Angeles, CA']")
    public WebElement selectLocation;

    @FindBy(xpath = "//div[@aria-label='Calendar']")
    public WebElement calendar;

    @FindBy(xpath = "//input[@placeholder='Start date']")
    public WebElement startDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

//    @FindBy(xpath = "//div[@aria-label='Move forward to switch to the next month']")
//    public WebElement nextMonthArrowClick;

//    @FindBy(xpath = "//div[@class='DateRangePicker_picker DateRangePicker_picker__horizontal DateRangePicker_picker__with_header seo-pages-jonmmy']")
//    public WebElement daysTable1;

    @FindBy(xpath = "//div[@aria-label='Move forward to switch to the next month']")
    public WebElement nextMonthClick;

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

    @FindBy(xpath="//option[@value='Lexus']")
    public WebElement lexus;

    @FindBy (xpath = "//span[@class='rangeSliderField-label']")
    public WebElement yearText;

    @FindBy (xpath = "//div[contains(text(), 'Number of seats')]")
    public  WebElement yearSlider;




    public void enterLocation(String location) {  //location is Los Angles
        typeLocation.click();
        typeLocation.sendKeys(location);
        selectLocation.click();
        logger.info("{} is entered",location );

    }
    public void startDateAndTime(String dateFrom, String dateUntil) {
        //Clicking the calender element to open the calender.
        startDate.click();
        waitSomeTime(3L);

        while (!calendar.getText().contains("May 2021")) {
            //this will click till finding the moth April.
            waitSomeTime(3L);
            nextMonthClick.click();
            waitSomeTime(1L);
        }

        // SOLUTION 1 : Select date UNTIL - FROM and click

        //Grab common attribute and put it into list and iterate
        //using List to retrieve the class contains day in it.

        List<WebElement> dates2 = calendar.findElements(By.tagName("td")); // gets all days from calendar

        for (WebElement day : dates2) {
//            System.out.println(day.getText());
            waitSomeTime(5L);
            if (day.getText().equals(dateFrom)) { //

                day.click();
                logger.info("Start date {} is selected.", dateFrom); // date 23 (from parameter) is selected
            }
            waitSomeTime(80L);
            if (day.getText().equals(dateUntil)) {
                day.click();
                logger.info("End date {} is selected.", dateUntil);
                break;
            }
        }
    }
    public void endDateAndTime(String date, String time) {
    }


    // SOLUTION 2 : Select date UNTIL - FROM and click
//        //counting the number of days inside the day class.
//        int count = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).size();
//
//        // iterating the days to find desired day which is equal to 23
//        for (int i = 0; i < count; i++) {
//            //We are getting the each day
//            String text = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).getText();
//
//            //comparing the day number with desired one. when it match the 23,
//            // it will execute and will break the loop.
//            //Select date FROM and click.
//            if (text.equals(dateFrom)) {
//                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
//                logger.info("Start date {} is selected.",dateFrom);
//            }
//            //Select date UNTIL and click.
//            if (text.equals(dateUntil)) {
//                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
//                logger.info("End date {} is selected.", dateUntil);
//                break;
//            }
//        }

    public void clickSearchButton() {
        searchButton.click();
        logger.info("User clicked search button.");

    }
    public void moreFiltersOptions() {
        moreFiltersButton.click();
        allStarHost.click();

    }
    public void selectCarAndVehicleMakes(String vehicle_makes) {
        vehicleTypesButton.click();
        car.click();

        waitSomeTime(2L);
        Select select =new Select(vehicleMakes);
        scrollDown(lexus);
        waitSomeTime(3L);
        select.selectByVisibleText(vehicle_makes);
    }




}
