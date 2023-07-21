package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SelectNationalityPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement nationality;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement clickOnContinue;


    public void selectNationality(String contry){
        selectByVisibleTextFromDropDown(nationality,contry);
    }

    public void clickNextStepButton(){
       clickOnElement(clickOnContinue);
    }
}
