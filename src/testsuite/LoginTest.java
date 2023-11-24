package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
// Click on signIn link
        WebElement signInLink = driver.findElement(By.xpath(" //div[@class='panel header']//a[contains(text(),'Sign In')]"));
        signInLink.click();
// Find the email field and write valid email on field
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("Lina445@gmail.com");
// Find password field and write valid password on field
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("AlexNI123");
// After fill email and password field click on signIn link
        WebElement signInLink1 = driver.findElement(By.id("send2"));
        signInLink1.click();
//Verify the message
     String expectedText="Welcome, Lina Smith!";
       WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Lina Smith!']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText  );
   }
   @Test
   public void TheErrorMessageWithInvalidCredentials(){
       WebElement signInLink = driver.findElement(By.xpath(" //div[@class='panel header']//a[contains(text(),'Sign In')]"));
       signInLink.click();
   // Find the email field and write invalid email on field
       WebElement emailField = driver.findElement(By.id("email"));
       emailField.sendKeys("Lina444@gmail.com");
   // Find password field and write invalid password on field
       WebElement passwordField = driver.findElement(By.id("pass"));
       passwordField.sendKeys("AlexNI122");
   // After fill email and password field click on signIn link
       WebElement signInLink1 = driver.findElement(By.id("send2"));
       signInLink1.click();
   //Verify the error message
       String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
       WebElement actualErrorMessageElement = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']"));
       String actualErrorMessage = actualErrorMessageElement.getText();
       Assert.assertEquals(expectedErrorMessage ,actualErrorMessage );
   }
   @Test
   public void userShouldLogOutSuccessfully(){
   // Click on signIn link
       WebElement signInLink = driver.findElement(By.xpath(" //div[@class='panel header']//a[contains(text(),'Sign In')]"));
       signInLink.click();
   // Find the email field and write valid email on field
       WebElement emailField = driver.findElement(By.id("email"));
       emailField.sendKeys("Lina445@gmail.com");
   // Find password field and write valid password on field
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("AlexNI123");
   // After fill email and password field click on signIn link
       WebElement signInLink1 = driver.findElement(By.id("send2"));
       signInLink1.click();
   // Verify the message
      String expectedText ="Welcome, Lina Smith!";
       WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Lina Smith!']"));
       String actualText = actualTextElement.getText();
       Assert.assertEquals(expectedText, actualText  );
   // Click on downArrow near Welcome
       WebElement downArrowField = driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']"));
       downArrowField.click();
   // Click on signOut link
       WebElement signOutLink = driver.findElement(By.xpath(" (//a[normalize-space()='Sign Out'])[1]"));
       signOutLink.click();
   // Verify the text
       String expectedText1 = "You are signed out";
       WebElement actualTextElement1 = driver.findElement(By.xpath("//span[@class='base']"));
       String actualText1 = actualTextElement1.getText();
       Assert.assertEquals(expectedText1,actualText1 );
   }
        @After
        public void tearDown() {
         closeBrowser();
        }

    }
