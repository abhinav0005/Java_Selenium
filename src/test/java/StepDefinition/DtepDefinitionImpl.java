package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulShetty.AbstractComponent.BaseTest;
import rahulShetty.pageobjects.CartPage;
import rahulShetty.pageobjects.ChechOutPage;
import rahulShetty.pageobjects.LandingPage;
import rahulShetty.pageobjects.ProductCatalogue;

public class DtepDefinitionImpl extends BaseTest {

	public LandingPage lp;
	public ProductCatalogue pc;
	public ChechOutPage cop;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		lp = launchApp();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Given_Logged_in_with_username_and_password(String userName, String password)
	{
		pc = lp.userLogin(userName, password);
	}
	@When("^i add product (.+) to cart$")
	public void i_add_product_to_cart(String produtName)
	{
		List<WebElement> productList = pc.getProductList();
		pc.addProductToCart(produtName);
	}
	@And("^checkout (.+)$")
	public void checkout_productName(String productName)
	{
		CartPage cp = pc.clickOnCart();
		boolean match = cp.cartMatch(productName);
		Assert.assertTrue(match);
		cop = cp.checkOut();		
	}
	
	@Then("submit the order")
	public void submit_the_order() throws InterruptedException
	{	
		cop.selectCountry("India");		
		cop.submitOrder();
		driver.close();
	}
	@Then("validate the error msg {string}")
	public void validate_the_error_msg(String string)
	{
		String msg= lp.getErrorMsg();
		Assert.assertEquals(string, msg);
		driver.close();
	}
}
