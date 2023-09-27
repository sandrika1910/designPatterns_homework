package WIth_PageFactory.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MoviesPage extends BasePage{
    public MoviesPage(WebDriver driver) {
        super(driver);
    }
    @FindAll({
            @FindBy(xpath = "//div[contains(@class, 'cinema_container')]/div[@class and count(@*) = 1]")
    })
    private List<WebElement> movies;

    @FindBy(xpath = "//div[contains(@class, 'cinema_container')]/div[1]/a[1]")
    private WebElement hover;

    @FindBy(xpath = "//*[@id=\"body\"]/div[9]/div[1]/div[2]/a[2]")
    public WebElement buyButton;

    public WebElement getHover() {
        return hover;
    }

    public List<WebElement> getMovies() {
        return movies;
    }
}
