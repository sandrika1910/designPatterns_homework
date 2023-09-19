package Steps;

import Pages.Clicks;
import io.qameta.allure.Step;

public class ClickOn {
    Clicks clicks = new Clicks();
    @Step
    public ClickOn clickOnForms() {
        clicks.formsCard.click();
        return this;
    }

    @Step
    public ClickOn clickOnPracticeForm() {
        clicks.practiceForm.click();
        return this;
    }
}
