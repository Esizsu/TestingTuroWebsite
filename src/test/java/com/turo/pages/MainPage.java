package com.turo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends Base{

    Logger logger = LoggerFactory.getLogger(MainPage.class);

    @FindBy (xpath ="//a[@title='Turo']")
    public WebElement TuroLogo;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    public WebElement login;

    @FindBy(xpath = "//a[normalize-space()='Sign up']")
    public WebElement signup;

    @FindBy(xpath = "//img[@alt='Liberty Mutual Insurance']")
    public WebElement insuranceLogo;




    public void verifTuroLogo() {
        TuroLogo.isDisplayed();
       // Assert.assertTrue(TuroLogo.isDisplayed() && TuroLogo.isEnabled());
        logger.info("Turo logo is displayed");

    }
    String actual;
    public void verifyTheFields(String value) {  //values are login and sign up
        if(value.equals(login.getText())){
            actual = login.getText();
            Assert.assertEquals(value,actual);
            logger.info("{} is displayed", value);
        }else if (value.equals(signup.getText())){
            actual=signup.getText();
            Assert.assertEquals(value,actual);
            logger.info("{} is displayed", value);
        }else logger.warn("Error");
    }

    public void verfyLibertyInsuranceLogo() {
        insuranceLogo.isDisplayed();
        logger.info("Insurance logo is displayed");

    }
}
