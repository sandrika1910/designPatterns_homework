package Without_PageFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCookies() {
        return driver.findElement(By.xpath("//*[@id=\"body\"]/section[8]/div[2]/div"));
    }

    public WebElement getMovieMenu() {
        return driver.findElement(By.cssSelector("div.Menus > ul > li:nth-of-type(1) > a"));
    }

}
