package rahulShetty.SeleniumFramework;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import rahulShetty.AbstractComponent.BaseTest;
import rahulShetty.pageobjects.CartPage;
import rahulShetty.pageobjects.ChechOutPage;
import rahulShetty.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest{

	@Test(groups= {"errorValidation"})
	public void submitOrder() throws IOException, InterruptedException
	{		
		
		lp.userLogin("abhinav@gmail.com", "Sher841407");
		String msg= lp.getErrorMsg();
		Assert.assertEquals("Incorrect email or password.", msg);
		
	}

}
