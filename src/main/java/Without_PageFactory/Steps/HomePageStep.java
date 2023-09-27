package Without_PageFactory.Steps;

import Without_PageFactory.Pages.BasePage;
import Without_PageFactory.Pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageStep extends BasePage {
    public HomePageStep(WebDriver driver) {
        super(driver);
    }
    HomePage homePage = new HomePage(driver);

    @Step
    public HomePageStep closeCookies() {
        homePage.getCookies().click();
        return this;

    }

    @Step
    public HomePageStep goToMovies() {
        homePage.getMovieMenu().click();
        return this;
    }
}
