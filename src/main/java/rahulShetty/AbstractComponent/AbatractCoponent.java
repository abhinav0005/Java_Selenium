package rahulShetty.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShetty.pageobjects.CartPage;

public class AbatractCoponent {

	
	WebDriver driver;
	public AbatractCoponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		@FindBy(css="button[routerlink*='cart']")
		WebElement cartButton;
		
	public CartPage clickOnCart()
	{
		cartButton.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	public void waitForElementToApper(By findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void waitForWebElementToApper(WebElement findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public void waitForElementToDisspper(By findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		
	}
	
}
