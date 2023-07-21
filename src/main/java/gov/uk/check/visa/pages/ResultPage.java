package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You will not need a visa to come to the UK')]")
    WebElement verifyResult;

    public String getResultMessage(){
        return getTextFromElement(verifyResult);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
    WebElement verifyText;

    public void confirmResultMessage(String expectedMessage){
        Assert.assertTrue(getTextFromElement(verifyText).equalsIgnoreCase(expectedMessage));
    }

}
