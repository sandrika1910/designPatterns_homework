package WIth_PageFactory.StepObjects;

import WIth_PageFactory.PageObjects.BasePage;
import WIth_PageFactory.PageObjects.MoviesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectMovieStep extends BasePage {
    WebDriverWait wait;
    public SelectMovieStep(WebDriver driver, int seconds) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(seconds));
    }

    Actions actions = new Actions(driver);
    MoviesPage moviesPage = new MoviesPage(driver);

    @Step(value="Step 3 -> select first movie")
    public SelectMovieStep selectFirstMovie() {
        actions.moveToElement(moviesPage.getHover()).perform();
        wait.until(ExpectedConditions.visibilityOf(moviesPage.getHover()));
        moviesPage.buyButton.click();
        return this;
    }
}
