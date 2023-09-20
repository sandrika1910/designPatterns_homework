package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class FillFormPage {
    public SelenideElement firstNameItem = $("#firstName"),
    lastNameItem = $("#lastName"),
    genderItem = $("label[for='gender-radio-1']"),
    mobileNumberItem = $("#userNumber"),
    submit = $("#submit");

}
