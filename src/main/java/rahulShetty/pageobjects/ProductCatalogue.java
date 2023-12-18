package rahulShetty.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulShetty.AbstractComponent.AbatractCoponent;

public class ProductCatalogue extends AbatractCoponent{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css= ".mb-3")
	List <WebElement> products;
	//By.cssSelector(".mb-3")
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToApper(productsBy);
		return products;
	}
	public WebElement getProductByName(String produtName)
	{
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(produtName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String produtName)
	{
		WebElement prod = getProductByName(produtName);
		prod.findElement(addToCart).click();
		waitForElementToApper(toastMsg);
		waitForElementToDisspper(toastMsg);
	}
	
}
