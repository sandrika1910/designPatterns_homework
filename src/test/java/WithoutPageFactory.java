
import Without_PageFactory.Steps.FirstMoviePageStep;
import Without_PageFactory.Steps.HomePageStep;
import Without_PageFactory.Steps.SelectMovieStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WithoutPageFactory {
    private WebDriver driver;
    private HomePageStep homePageStep;
    private SelectMovieStep selectMovieStep;
    private FirstMoviePageStep firstMoviePageStep;
    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePageStep = new HomePageStep(driver);
        selectMovieStep = new SelectMovieStep(driver,10);
        firstMoviePageStep = new FirstMoviePageStep(driver, 10);
    }

    @Test
    public void test() {
        driver.get("https://www.swoop.ge/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        homePageStep.closeCookies();
        homePageStep.goToMovies();
        selectMovieStep.selectFirstMovie();
        firstMoviePageStep.selectCaveEastPoint();
        firstMoviePageStep.checkReturnedOption();
        firstMoviePageStep.clickOnLast();
        firstMoviePageStep.check();
        firstMoviePageStep.chooseSeat();
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
