package rahulShetty.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShetty.AbstractComponent.AbatractCoponent;

public class LandingPage extends AbatractCoponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.id("userEmail"))
	@FindBy(id="userEmail")
	WebElement email;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement login;
	@FindBy(css=".toast-message")
	WebElement errorMsg;
	
	public ProductCatalogue userLogin(String userEmail, String userPassword)
	{
		email.sendKeys(userEmail);
		password.sendKeys(userPassword);
		login.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
	public void launchingPage(String baseUrl)
	{
		driver.get(baseUrl);
	}
	public String getErrorMsg()
	{
		waitForWebElementToApper(errorMsg);
		return errorMsg.getText();
	}
}
