package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
//Click on ‘Sale’ Menu tab
        WebElement saleTab = driver.findElement(By.id("ui-id-8"));
        saleTab.click();
//Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        WebElement jacketLink = driver.findElement(By.xpath("(//a[normalize-space()='Jackets'])[3]"));
        jacketLink.click();
//Find number of items per page element and print total number
        List<WebElement> numberOfDisplayedItems = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        System.out.println("Total: " + numberOfDisplayedItems.size());
//Find each item displayed element and print each item
        List<WebElement> linkedItem = driver.findElements(By.tagName("ol"));
        System.out.println("total number of items:" + linkedItem.size());
        for (WebElement link : linkedItem) {
            System.out.println("linked text: " + link.getText());
//Verify expected and actual number of items displayed per page
            int expectedNumberOfItems = 12;
            int actualNumberOfItems = numberOfDisplayedItems.size();
            Assert.assertEquals("Error", expectedNumberOfItems, actualNumberOfItems);
        }

        }
    @After
    public void tearDown(){
        closeBrowser();
    }

    }
