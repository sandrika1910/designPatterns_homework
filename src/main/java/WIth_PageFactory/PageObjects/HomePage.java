package WIth_PageFactory.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"body\"]/section[8]/div[2]/div")
    public WebElement cookies;

    @FindBy(css = "div.Menus > ul > li:nth-of-type(1) > a")
    public WebElement movieMenu;

}
