import Data.UrlData;
import Steps.*;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ClickOnButtons extends ConfigClass{
    ClickOnStep clickOn = new ClickOnStep();
    UrlData urlData = new UrlData();
    FillFormSteps fillFormSteps = new FillFormSteps();
    ScrollDownStep scrollDownStep = new ScrollDownStep();
    TextValidateStep textValidateStep = new TextValidateStep();
    ValidateInfo validateInfo = new ValidateInfo();

    @BeforeSuite
    public void setUp() {
        super.setUp();
    }
    @Test(description = "Go to form page", priority = 1)
    @Description("fill form page")
    @Story("way to form page test")
    public void goToForm() {
        Selenide.open(urlData.url);
        scrollDownStep.scrollDown();
        clickOn.clickOnForms();
        clickOn.clickOnPracticeForm();
    }

    @Test(description = "Fill form Scenario", priority = 2)
    @Description("Success form fields scenario")
    @Story("Valid form fill fields test")
    public void fillFormTest() {
        fillFormSteps.fillFirstName().fillLastName().setGender().fillMobileNumber().clickOnSubmit();
    }

    @Test(description = "Message validation Scenario", priority = 3)
    @Description("Success message visibility Scenario")
    @Story("Valid message test")
    public void validateMessageTest() {
        textValidateStep.validateMessage();
    }

    @Test(description = "Info validation Scenario", priority = 4)
    @Description("Success info matching Scenario")
    @Story("Valid info test")
    public void validateInfoTest() {
        validateInfo.validateInfo();
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
    }
}
