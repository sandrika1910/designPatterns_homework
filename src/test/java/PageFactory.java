import WIth_PageFactory.StepObjects.FirstMoviePageSteps;
import WIth_PageFactory.StepObjects.HomePageStep;
import WIth_PageFactory.StepObjects.SelectMovieStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Epic("Allure example with Page Factory and Fluent API")
@Feature("JDK20 available")
@Listeners({CustomListener.class})
public class PageFactory {
    private static WebDriver driver;
    private HomePageStep homePageStep;
    private SelectMovieStep selectMovieStep;
    private FirstMoviePageSteps firstMoviePageSteps;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePageStep = new HomePageStep(driver);
        selectMovieStep = new SelectMovieStep(driver,10);
        firstMoviePageSteps = new FirstMoviePageSteps(driver, 10);
    }

    static protected WebDriver getWebDriver() {
        return driver;
    }


    @Test(description = "Go to movie and book free seat")
    @Story("Movie booking")
    @Description("Go to movies page, click first movie, book free seat in 'კავეა ისთ ფოინთ'")
    @Severity(SeverityLevel.NORMAL)
    public void test() {
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        homePageStep.closeCookies().goToMovies();
        selectMovieStep.selectFirstMovie();
        firstMoviePageSteps.selectCaveEastPoint().checkReturnedOption().clickOnLast().check().chooseSeat();

    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
