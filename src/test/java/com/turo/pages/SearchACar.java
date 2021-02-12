package com.turo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
            waitSomeTime(3L);
            if (day.getText().equals(dateFrom)) { //

                day.click();
                logger.info("Start date {} is selected.", dateFrom); // date 23 (from parameter) is selected
            }
            waitSomeTime(6L);
            if (day.getText().equals(dateUntil)) {
                day.click();
                logger.info("End date {} is selected.", dateUntil);
                break;
            }
        }
    }

    public void endDateAndTime(String date, String time) {
    }

    public void clickSearchButton() {
        searchButton.click();
        logger.info("User clicked search button.");


    }
}
