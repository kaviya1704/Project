package stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import PageObjects.HI_001_HealthHomePage;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthInsurance {
	
	@Given("The user click on Insurance products menu")
	public void clickInsuranceProductsMenu() throws IOException {
		BaseClass.getLogger().info("************ Click insurance products menu *************** ");
		HI_001_HealthHomePage hhp=new HI_001_HealthHomePage(BaseClass.getDriver());
		hhp.clickInsProducts();
	}

	@When("Hover the health insurance menu")
	public void navigateHealthInsurancePage() {
		BaseClass.getLogger().info("************ Navigate to Health insurance page *************** ");
		HI_001_HealthHomePage hhp=new HI_001_HealthHomePage(BaseClass.getDriver());
		hhp.clickHealthInsurance();
	}
	

	@Then("Retrieve all the sub menus as list and print them")
	public void retrieveTheSubMenuItems() throws IOException {
		BaseClass.getLogger().info("************ Retrieve all the sub menus successfully *************** ");
		HI_001_HealthHomePage mp=new HI_001_HealthHomePage(BaseClass.getDriver());
		Assert.assertEquals(mp.getMenuItem(), "Menu item are retrived successfully");;
	}

	

}
