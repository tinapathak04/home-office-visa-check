package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {

    DurationOfStayPage duration;
    FamilyImmigrationStatusPage immigration;
    ReasonForTravelPage travel;
    ResultPage result;
    SelectNationalityPage nationality;
    StartPage startPage;
    WorkTypePage workTypePage;


    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod(alwaysRun = true)
    public void init (){
        duration = new DurationOfStayPage();
        immigration = new FamilyImmigrationStatusPage();
        travel = new ReasonForTravelPage();
        result = new ResultPage();
        nationality = new SelectNationalityPage();
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
    }

    @Test(groups = {"smoke","sanity","regression"})
    public void anAustralianCominToUKForTourism(){
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Australia'
        nationality.selectNationality("Australia");
        //Click on Continue button
        nationality.clickNextStepButton();
        //Select reason 'Tourism'
        travel.selectReasonForVisit("Tourism or visiting family and friends");
        //Click on Continue button
        travel.byContinue();
        //verify result 'You will not need a visa to come to the UK'
        Assert.assertEquals("You will not need a visa to come to the UK",result.getResultMessage(),"Message not displayed");

    }

    @Test(groups = {"regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Chile'
        nationality.selectNationality("Chile");
        //Click on Continue button
        nationality.clickNextStepButton();
        //Select reason 'Work, academic visit or business'
        duration.selectOnWorkAcademic("Work, academic visit or business");
        //Click on Continue button
        travel.byContinue();
        //Select intendent to stay for 'longer than 6 months'
        duration.selectLengthOfStay("more");
        //Click on Continue button
        duration.clickContinue();
        //Select have planning to work for 'Health and care professional'
        duration.clickOnHealthProfessional("Health and care professional");
        //Click on Continue button
        duration.clickAfterContinue();
        //verify result 'You need a visa to work in health and care'
        result.confirmResultMessage("You need a visa to work in health and car");

    }

    @Test(groups = {"sanity","regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){

        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Chile'
        nationality.selectNationality("Colombia");
        //Click on Continue button
        nationality.clickNextStepButton();
        //Select reason 'Join partner or family for a long stay'
        immigration.clickFamilyForLongStay();
        //Click on Continue button
        immigration.clickNextStepButton();
        //Select state My partner of family member have uk immigration status 'yes'

        //Click on Continue button

        //verify result 'You’ll need a visa to join your family or partner in the UK'

    }
}
