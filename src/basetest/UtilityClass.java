package basetest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilityClass extends BaseTest {

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will send to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }

    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).click().build().perform();
    }
}
