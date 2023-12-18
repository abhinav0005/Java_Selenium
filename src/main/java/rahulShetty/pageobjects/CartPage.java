package rahulShetty.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> products;

	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	public List<WebElement> cartList()
	{
		return products;		
		//boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(produtName));
	}
	public boolean cartMatch(String produtName)
	{
		return cartList().stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(produtName));
	}
	
	public ChechOutPage checkOut()
	{
		checkOut.click();
		ChechOutPage cop = new ChechOutPage(driver);
		return cop;
	}
}
