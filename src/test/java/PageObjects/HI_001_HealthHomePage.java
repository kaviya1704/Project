package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WriteExcel;

public class HI_001_HealthHomePage extends BasePage {
	
	public HI_001_HealthHomePage (WebDriver driver) {
		super(driver);
	}
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Declaration of Actions class
	Actions act=new Actions(driver);
	
	//Locators
	@FindBy(xpath="//a[text()='Insurance Products ']")
	WebElement insuranceProducts;
	
	@FindBy(xpath="(//a[text()='Health Insurance'])[2]")
	WebElement healthInsurance;
	
	@FindBy(xpath="//div[@class=\"ruby-row\"]/div[3]/ul/li")
	List<WebElement> menu ;
	
	//Actions
	//Method to click the Insurance products
	public void clickInsProducts() {
		wait.until(ExpectedConditions.visibilityOf(insuranceProducts));
		insuranceProducts.click();
	}
	//Method to click the health insurance
	public void clickHealthInsurance() {
		wait.until(ExpectedConditions.visibilityOf(healthInsurance));
		act.moveToElement(healthInsurance).perform();
		
	}
	public String getMenuItem() throws IOException {
		try {
			int i=1;
			for(WebElement item:menu) {
				String menu=item.getText();
				System.out.println(menu);
				WriteExcel.setCellData("Health Insurance", i, 0,menu );
				i++;
				
			}
			return "Menu item are retrived successfully";
		}
		catch(Exception e) {
			return "Menu item not retrived";
		}
	}
	
	
	

}
