package rahulShetty.SeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShetty.AbstractComponent.BaseTest;
import rahulShetty.pageobjects.CartPage;
import rahulShetty.pageobjects.ChechOutPage;
import rahulShetty.pageobjects.LandingPage;
import rahulShetty.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	@Test(dataProvider="getData")
	public void submitOrder(String userName, String password, String produtName) throws IOException, InterruptedException
	{		
		//String produtName= "ZARA COAT 3";	
		//LandingPage lp = launchApp();   using @BeforeMethod to initilize
		ProductCatalogue pc = lp.userLogin(userName, password);
	
		//ProductCatalogue pc = new ProductCatalogue(driver);
		List<WebElement> productList = pc.getProductList();
		pc.addProductToCart(produtName);		
		CartPage cp = pc.clickOnCart();
		
		//CartPage cp = new CartPage(driver);
		boolean match = cp.cartMatch(produtName);
		Assert.assertTrue(match);
		ChechOutPage cop = cp.checkOut();

		//ChechOutPage cop = new ChechOutPage(driver);
		cop.selectCountry("India");		
		Thread.sleep(5000);
		//driver.findElement(By.cssSelector(".action__submit")).click();
		cop.submitOrder();
	}
	
	
	@DataProvider()
	public Object[][] getData()
	{
		return new Object [][] {{"abhinav@gmail.com", "Sher@841407","ZARA COAT 3"},{"ar@gmail.com", "Sher@841407","ADIDAS ORIGINAL"}};
	}

}
