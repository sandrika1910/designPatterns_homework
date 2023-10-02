import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.UUID;

public class CustomListener extends PageFactory implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(PageFactory.getWebDriver());
        saveLogs(result.getMethod().getConstructorOrMethod().getName());
    }
    @Attachment(value="Screenshot", type="img/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value="Stacktrace", type="text/plain")
    public static String saveLogs(String message) {
        return message;
    }
//    public static void screenshot() {
//        try {
//            String randomFileName = "screenshot_" + UUID.randomUUID().toString() + ".png";
//            File screenshot = Screenshots.takeScreenShotAsFile();
//            File destFile = new File("allure-results/screenshots/" + randomFileName);
//            org.apache.commons.io.FileUtils.copyFile(screenshot, destFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
