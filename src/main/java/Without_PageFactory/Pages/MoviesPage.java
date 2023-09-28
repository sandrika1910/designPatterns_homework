package Without_PageFactory.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MoviesPage extends BasePage{
    public MoviesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getMovies() {
        return driver.findElements(By.xpath("//div[contains(@class, 'cinema_container')]/div[@class and count(@*) = 1]"));
    }

    public WebElement getHover() {
        return driver.findElement(By.xpath("//div[contains(@class, 'cinema_container')]/div[1]/a[1]"));
    }

    public WebElement getBuyButton() {
        return driver.findElement(By.xpath("//*[@id=\"body\"]/div[9]/div[1]/div[2]/a[2]"));
    }
}
