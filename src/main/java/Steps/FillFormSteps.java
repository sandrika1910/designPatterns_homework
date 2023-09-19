package Steps;

import Data.FormData;
import Pages.FillFormPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FillFormSteps {
    FillFormPage fillFormPage = new FillFormPage();
    FormData formData = new FormData();

    @Step
    public FillFormSteps fillFirstName() {
        fillFormPage.firstNameItem.sendKeys(formData.firstName);
        return this;
    }

    @Step
    public FillFormSteps fillLastName() {
        fillFormPage.lastNameItem.sendKeys(formData.lastName);
        return this;
    }

    @Step
    public FillFormSteps setGender() {
        fillFormPage.genderItem.click();
        return this;
    }

    @Step
    public FillFormSteps fillMobileNumber() {
        fillFormPage.mobileNumberItem.sendKeys(formData.mobileNumber);
        return this;
    }

    @Step
    public FillFormSteps clickOnSubmit() {
        executeJavaScript("arguments[0].click();", $(fillFormPage.submit));
        return this;
    }
}
