package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest  {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSignInPageDisplay(){
     //Find the create account link and click on create account link
        WebElement createAccountLink = driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']"));
        createAccountLink.click();
        String expectedText = "Create an Account";
    //Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//a[text()='Create an Account']"));
        String actualText = actualTextElement.getText();
    //Verify expected and actual Text
        Assert.assertEquals(expectedText ,actualText );
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() {
    //Find the create account link and click on create account link
        WebElement createAccountLink = driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']"));
        createAccountLink.click();
    //Find the firstname field and write firstName on field
        WebElement firstNameField = driver.findElement(By.id("firstname"));
        firstNameField.sendKeys("Lina");
    //Find the lastName field and write lastName on field
        WebElement lastNameElement = driver.findElement(By.id("lastname"));
        lastNameElement.sendKeys("Smith");
    //generate random email address for repeat tests
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
    //Find email address field element and random email addresses
        driver.findElement(By.id("email_address")).sendKeys("LinaSmith" +randomInt+ "@gmail.com") ;
        //Click on checkbox sign up for newsletter
    //Find the password field and write password on field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("AlexNI123");
    //Find the confirmPassword field and write password on field
        WebElement confirmPasswordField = driver.findElement(By.id("password-confirmation") );
        confirmPasswordField.sendKeys("AlexNI123");
    //click on create an account button
        WebElement createAnAccount = driver.findElement(By.xpath("//button[@title='Create an Account']"));
        createAnAccount.click();
    //Verify the text after clicking Create an account
        String expectedText ="Thank you for registering with Main Website Store.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-success success message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText  );
    // Click on downArrow next to Welcome
        WebElement downArrowField = driver.findElement(By.xpath("(//button[@type='button'])[1]") );
        downArrowField.click();
        WebElement signOutLink = driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']"));
        signOutLink.click();
    //Verify the text
        String expectedText1 = "You are signed out";
        WebElement actualTextElement1 = driver.findElement(By.xpath("//span[@class='base']"));
        String actualText1 = actualTextElement1.getText();
        Assert.assertEquals(expectedText1,actualText1 );
    }


    @After
    public void tearDown(){
       closeBrowser();
   }
}