package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DurationOfStayPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-1']")
    WebElement clickOnWorkAcademic;

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-0']")
    WebElement sixMonthsOrLess;

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-1']")
    WebElement longerThan6Months;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement withContinue;

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-0']")
    WebElement healthCareProfessional;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement afterContinue;

    public void selectOnWorkAcademic(String work){
        clickOnElement(clickOnWorkAcademic);
    }
    public void selectLengthOfStay(String moreOrLess){
        //clickOnElement(longerThan6Months);

        switch (moreOrLess){
            case "more":
            clickOnElement(longerThan6Months);
            break;
            case "less":
            clickOnElement(sixMonthsOrLess);
            break;
        }

    }

    public void clickContinue(){
        clickOnElement(withContinue);
    }
    public void clickOnHealthProfessional(String healthProfessional){
        clickOnElement(healthCareProfessional);
    }
    public void clickAfterContinue(){
        clickOnElement(afterContinue);
    }


}
