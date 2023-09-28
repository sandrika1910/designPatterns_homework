import WIth_PageFactory.StepObjects.FirstMoviePageSteps;
import WIth_PageFactory.StepObjects.HomePageStep;
import WIth_PageFactory.StepObjects.SelectMovieStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageFactory {
    private WebDriver driver;
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

    @Test
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
