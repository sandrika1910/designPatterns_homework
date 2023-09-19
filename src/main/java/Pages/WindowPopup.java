package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WindowPopup {
     public SelenideElement messageDiv = $("#example-modal-sizes-title-lg");
     public SelenideElement tableBody = $("div[class='modal-body']");
     public ElementsCollection tableHeaders = tableBody.$("thead").$("tr").$$("th");
     public ElementsCollection tableData = tableBody.$("tbody").$$("tr");


}
