package Stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefLogin {
	
	WebDriver driver;
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   
	}
	@When("User open URL {string}")
	public void user_open_url(String url) {
		
		driver.get(url);
	    
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    
		WebElement emailid=driver.findElement(By.id("modalusername"));
		WebElement pass=driver.findElement(By.id("current-password"));
		
		emailid.sendKeys(email);
		pass.sendKeys(password);

		
	}
	@When("Click on Login button")
	public void click_on_login_button() throws InterruptedException {
		
		WebElement loginbtn=driver.findElement(By.xpath("//span[text()='Log in']"));
         loginbtn.click();
    
         Thread.sleep(8000);
	   
	}
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, expectedTitle);
	
	}
	
	@Then("close browser")
	public void close_browser() {
		
		driver.close();
	   
	}


}
