import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfigClass {

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        Configuration.timeout = 20000;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.reopenBrowserOnFail = true;
    }

    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
