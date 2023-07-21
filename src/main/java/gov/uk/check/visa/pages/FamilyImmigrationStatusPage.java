package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FamilyImmigrationStatusPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-4']")
    WebElement partenerOrFamily;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement clickingContinue;


    public void clickFamilyForLongStay(){
        clickOnElement(partenerOrFamily);
    }

    public void clickNextStepButton(){
        clickOnElement(clickingContinue);
    }
}
