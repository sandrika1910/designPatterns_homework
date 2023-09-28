package WIth_PageFactory.StepObjects;
import WIth_PageFactory.PageObjects.BasePage;
import WIth_PageFactory.PageObjects.FirstMoviePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FirstMoviePageSteps extends BasePage {
    WebDriverWait wait;
    public FirstMoviePageSteps(WebDriver driver, int seconds) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(seconds));
    }


    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);
    FirstMoviePage firstMoviePage = new FirstMoviePage(driver);

    @Step
    public FirstMoviePageSteps selectCaveEastPoint() {
        List<WebElement> places = firstMoviePage.places;
        WebElement eastPoint = null;
        for(int i = 0; i < places.size(); i++) {
            WebElement element = places.get(i).findElement(By.xpath("./a"));
            String place = element.getText();
            if(place.equals("კავეა ისთ ფოინთი")) {
                eastPoint = element;
            }
        }

        if (eastPoint != null && eastPoint.getText().equals("კავეა ისთ ფოინთი")) {
            int windowHeight = driver.manage().window().getSize().getHeight();
            int elementPositionY = eastPoint.getLocation().getY();
            int scrollPosition = elementPositionY - (windowHeight / 2);

            //Scroll vertically (if necessary), and horizontally and choose ‘კავეა ისთ ფოინთი'
            js.executeScript("window.scrollTo(0, arguments[0]);", scrollPosition);
            eastPoint.click();

            System.out.println("clicked on 'კავეა ისთ ფოინთი'");

        } else {
            System.out.println("no found 'კავეა ისთ ფოინთი'");
            }
        return this;
    }

    @Step
    public FirstMoviePageSteps checkReturnedOption() {
        wait.until(ExpectedConditions.attributeToBe(firstMoviePage.getParentElement(),"aria-selected","true"));
        Assert.assertEquals(firstMoviePage.getParentElement().getAttribute("aria-selected"), "true","'კავეა ისთ ფოინთი' is not selected");
        System.out.println("'კავეა ისთ ფოინთი' is selected");
        return this;
    }

    @Step
    public FirstMoviePageSteps clickOnLast() {
        int windowHeight = driver.manage().window().getSize().getHeight();
        int elementPositionY = firstMoviePage.lastOption.getLocation().getY();
        int scrollPosition = elementPositionY - (windowHeight / 2);
        wait.until(ExpectedConditions.elementToBeClickable(firstMoviePage.lastDate));
        actions.moveToElement(firstMoviePage.lastDate).click().build().perform();
        js.executeScript("window.scrollTo(0, arguments[0]);", scrollPosition);
        js.executeScript("arguments[0].click();", firstMoviePage.lastOption);

//        actions.moveToElement(firstMoviePage.lastOption).click().build().perform();
        return this;
    }

    @Step
    public FirstMoviePageSteps check() {
        String dateAttr = firstMoviePage.lastDate.findElement(By.xpath("..")).getAttribute("aria-controls");
        String expectedCinemaName = firstMoviePage.lastOption.findElement(By.xpath("./a/p[2]")).getText();
        String expectedMovieName = driver.findElement(By.xpath("//div[@class='movie-detailed-info']/div[2]/div/div/p")).getText();
        String expectedHour = firstMoviePage.lastOption.findElement(By.xpath("./a/p")).getText();
        String expectedDay = firstMoviePage.lastDate.getText().substring(0,2);
        String expectedMonth = null;
        String expectedFinalDate = null;
        StringBuilder seanseDateAndTime = new StringBuilder();

        for (char c : dateAttr.toCharArray()) {
            if(Character.isDigit(c) || c == '.') {
                seanseDateAndTime.append(c);
            }
        }

        String[] months = {"იანვარი", "თებერვალი", "მარტი", "აპრილი", "მაისი", "ივნისი", "ივლისი", "აგვისტო", "სექტემბერი", "ოქტომბერი", "ნოემბერი", "დეკემბერი"};
        String[] splitDate = seanseDateAndTime.toString().split("\\.");
        String month = splitDate[1];

        int monthNumber = -1;
        if(month.charAt(0) == '0') {
            monthNumber = Integer.parseInt(String.valueOf(month.charAt(1)));
        } else {
            monthNumber = Integer.parseInt(month);
        }

        if(monthNumber != -1) {
            expectedMonth = months[monthNumber-1];
        } else {
            System.out.println("month manipulation error!");
        }

        if(expectedMonth != null) {
            expectedFinalDate = expectedDay + " " + expectedMonth + " " + expectedHour;
        }

        if(expectedFinalDate == null) {
            System.out.println("error");

        }

        //Check in opened popup that movie name, cinema and datetime is valid

        String actualCinemaName = firstMoviePage.actualCinemaNameElement.getText();
        String actualMovieName = firstMoviePage.actualMovieNameElement.getText();
        String actualDateTime = firstMoviePage.actualDateTimeElement.getText();
        wait.until(ExpectedConditions.attributeToBe(firstMoviePage.divElement,"class","cinema-modal open"));
        Assert.assertEquals(actualCinemaName, expectedCinemaName,"cinema name validation failed!");
        Assert.assertEquals(actualMovieName, expectedMovieName, "movie name validation failed!");
        Assert.assertEquals(actualDateTime, expectedFinalDate, "date validation failed!");
        System.out.println("cinema name, movie name and date validations are successful");
        return this;
    }

    @Step
    public FirstMoviePageSteps chooseSeat() {
        WebElement freeSeat = firstMoviePage.parentForSeats.findElement(By.xpath("./div[@class='seat free']"));
        freeSeat.click();
        return this;
    }
}
