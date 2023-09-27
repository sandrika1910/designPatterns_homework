package WIth_PageFactory.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FirstMoviePage extends BasePage{

    public FirstMoviePage(WebDriver driver) {
        super(driver);
    }

    public WebElement eastPoint = null;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class, 'choose-seanse')]/div[1]/ul/li")
    })
    public List<WebElement> places;

    @FindBy(id = "ui-id-6")
    private WebElement caveaEastPoint;

    public WebElement getCaveaEastPoint() {
        return caveaEastPoint;
    }

    public WebElement getParentElement() {
        // Locate the parent element of caveaEastPoint using XPath
        return caveaEastPoint.findElement(By.xpath(".."));
    }

    @FindBy(xpath = "//*[@id=\"384933\"]/div/ul/li[last()]/a")
    public WebElement lastDate;

    @FindBy(xpath = "//*[@id=\"384933\"]/div/div[@aria-hidden='false'][last()]")
    public WebElement lastOption;

    @FindBy(id = "tickets-pepsicorn")
    public WebElement divElement;

    @FindBy(xpath = "//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[2]")
    public WebElement actualCinemaNameElement;

    @FindBy(xpath = "//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[1]")
    public WebElement actualMovieNameElement;

    @FindBy(xpath = "//*[@id=\"eventForm\"]/div/div[3]/div[1]/p[3]")
    public WebElement actualDateTimeElement;

    @FindBy(xpath = "//*[@id=\"cinema-tickets\"]/div/div/div[2]")
    public WebElement parentForSeats;


}
