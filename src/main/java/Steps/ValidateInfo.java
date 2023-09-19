package Steps;

import Data.FormData;
import Pages.FillFormPage;
import Pages.WindowPopup;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class ValidateInfo {
    FormData formData = new FormData();
    WindowPopup windowPopup = new WindowPopup();
    FillFormPage fillFormPage = new FillFormPage();
    @Step
    public ValidateInfo validateInfo() {
        int counter = 0;
        int labelIndex = -1;
        int valuesIndex = -1;
        for(SelenideElement element : windowPopup.tableHeaders) {
            if (element.getText().equals("Label")) {
                labelIndex = counter;
            } else if(element.getText().equals("Values")) {
                valuesIndex = counter;
            }
            counter++;
        }

        String studentName = null;
        String mobileNumber = null;
        String gender = null;
        for(int i = 0; i < windowPopup.tableData.size(); i++) {
            SelenideElement tr = windowPopup.tableData.get(i);
            if (tr.$$("td").get(labelIndex).getText().equals("Student Name")) {
                studentName = tr.$$("td").get(valuesIndex).getText();
            } else if (tr.$$("td").get(labelIndex).getText().equals("Mobile")) {
                mobileNumber = tr.$$("td").get(valuesIndex).getText();
            } else if (tr.$$("td").get(labelIndex).getText().equals("Gender")) {
                gender = tr.$$("td").get(valuesIndex).getText();
            }

        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(studentName, formData.firstName + " " + formData.lastName, "Student Name is not as expected in table!");
        softAssert.assertEquals(mobileNumber,formData.mobileNumber, "Mobile Number is not as expected in table!");
        softAssert.assertEquals(gender,formData.gender, "Gender is not as expected in table!");
        return this;
    }

}
