package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ReasonForTravelPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-0']")
    WebElement reasonForVisit;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement clickOnContinue;


    public void selectReasonForVisit(String reason){
        clickOnElement(reasonForVisit);
    }
    public void byContinue(){
        clickOnElement(clickOnContinue);
    }
}
