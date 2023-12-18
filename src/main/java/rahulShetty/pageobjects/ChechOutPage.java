package rahulShetty.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShetty.AbstractComponent.AbatractCoponent;

public class ChechOutPage {


	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement enterCountry;
	
	@FindBy(css=".ta-item span")
	List<WebElement> countriesList;
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement submit;
	
	WebDriver driver;
	
	public ChechOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void selectCountry(String countryName)
	{
		enterCountry.sendKeys(countryName);
		
		WebElement selectCountry=countriesList.stream().filter(country->country.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		selectCountry.click();
	}
	public void submitOrder() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.elementToBeClickable(submit));
		//Thread.sleep(3000);
		submit.click();
	}
}
