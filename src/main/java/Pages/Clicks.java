package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Clicks {
    public SelenideElement formsCard = $$("div[class='card-body']").get(1),
    practiceForm = $x("//span[text()='Practice Form']");
}
