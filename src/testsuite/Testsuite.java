package testsuite;

import basetest.UtilityClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Testsuite extends UtilityClass {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void amazonWebsite() throws InterruptedException {
        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        clickOnElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.CONTROL + "a");
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));

        Thread.sleep(2000);
        //3. Click on the checkbox brand Dell on the left side.
        clickOnElement(By.xpath("//*[@id='sp-cc-rejectall-link']"));
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));

        //4. Verify that the  30(May be different) products are displayed on the page.
        mouseHoverOnElement(By.xpath("//span[normalize-space()='1-24 of over 2,000 results for']"));
        assertVerifyText(By.xpath("//span[normalize-space()='1-24 of over 2,000 results for']"), "1-24 of over 2,000 results for");

        //searched products is stored into list of searchResults
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']"));
        //List of products are stored in an ArrayList
        ArrayList<String> searchResult = new ArrayList<>();
        //Using advanced for loop to get headings of each product
        //e object of webElement
        for (WebElement e : searchResults) {
            searchResult.add(e.getText());
        }
        System.out.println("All searched products are listed Below: " + searchResult);
        Assert.assertEquals("Search list returns different result", 30, searchResult.size());

    //    6. Click on the product name 'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3" FHD TOUCH'
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        clickOnElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Intel Core i5']"));
        clickOnElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='8 GB']"));
        clickOnElement(By.xpath("//li[@id='p_n_feature_thirteen_browse-bin/8322539031']//span[@class='a-size-base a-color-base'][normalize-space()='250 to 499 GB']"));
        clickOnElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='SSD']"));

        //7. Varify the Product name 'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3" FHD TOUCH'
        clickOnElement(By.xpath("//img[@alt='Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3\" FHD TOUCH']"));
        assertVerifyText(By.xpath("//span[@id='productTitle']"), "Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3\" FHD TOUCH");
    }

    // 5. Close the Browser.
    @After
    public void tearDown() {
         closeBrowser();
    }
}
