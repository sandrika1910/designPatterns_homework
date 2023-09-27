package Without_PageFactory.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FirstMoviePage extends BasePage{
    public FirstMoviePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getPlaces() {
        return driver.findElements(By.xpath("//div[contains(@class, 'choose-seanse')]/div[1]/ul/li"));
    }

    public WebElement getCaveaEastPoint() {
        return driver.findElement(By.id("ui-id-6"));
    }

    public WebElement getLastDate() {
        return driver.findElement(By.xpath("//*[@id=\"384933\"]/div/ul/li[last()]/a"));
    }

    public WebElement getLastOption() {
        return driver.findElement(By.xpath("//*[@id=\"384933\"]/div/div[@aria-hidden='false'][last()]"));
    }

    public WebElement getDivElement() {
        return driver.findElement(By.id("tickets-pepsicorn"));
    }

    public WebElement getActualCinemaNameElement() {
        return driver.findElement(By.xpath("//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[2]"));
    }

    public WebElement getActualMovieNameElement() {
        return driver.findElement(By.xpath("//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[1]"));
    }

    public WebElement getActualDateTimeElement() {
        return driver.findElement(By.xpath("//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[3]"));
    }

    public WebElement getParentForSeats() {
        return driver.findElement(By.xpath("//*[@id=\"cinema-tickets\"]/div/div/div[2]"));
    }

}
