package WIth_PageFactory.StepObjects;

import WIth_PageFactory.PageObjects.BasePage;
import WIth_PageFactory.PageObjects.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageStep extends BasePage{
    public HomePageStep(WebDriver driver) {
        super(driver);
    }
    HomePage homePage = new HomePage(driver);

    @Step
    public HomePageStep closeCookies() {
        homePage.cookies.click();
        return this;

    }

    @Step
    public HomePageStep goToMovies() {
        homePage.movieMenu.click();
        return this;
    }
}
