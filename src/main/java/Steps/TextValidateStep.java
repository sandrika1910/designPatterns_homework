package Steps;

import Data.ValidateData;
import Pages.WindowPopup;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;

@Listeners({SoftAsserts.class})
public class TextValidateStep {
    ValidateData validateData = new ValidateData();
    WindowPopup windowPopup = new WindowPopup();
    @Step
    public TextValidateStep validateMessage() {
        $("body").shouldHave(Condition.attribute("class","modal-open")); // wait for to load new elements to DOM
        SelenideElement element = windowPopup.messageDiv;
        element.shouldBe(Condition.exist);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(validateData.submitFormMessage, element.getText());
        softAssert.assertAll();
        return this;
    }
}
