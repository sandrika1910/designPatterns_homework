package Steps;

import Pages.Clicks;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ScrollDownStep {
    Clicks clicks = new Clicks();

    @Step
    public ScrollDownStep scrollDown() {
        executeJavaScript("arguments[0].scrollIntoView(true)", clicks.formsCard);
        return  this;
    }
}
