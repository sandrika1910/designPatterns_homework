package Steps;

import Pages.Clicks;
import io.qameta.allure.Step;

public class ClickOnStep {
    Clicks clicks = new Clicks();
    @Step
    public ClickOnStep clickOnForms() {
        clicks.formsCard.click();
        return this;
    }

    @Step
    public ClickOnStep clickOnPracticeForm() {
        clicks.practiceForm.click();
        return this;
    }
}
