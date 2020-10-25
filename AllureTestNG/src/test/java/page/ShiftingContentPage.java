package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShiftingContentPage {
	WebDriver driver;

	By menuExampleButton = By.xpath("//a[contains(text(),'Example 1: Menu Element')]");
	By imageExampleButton = By.xpath("//a[contains(text(),'Example 2: An image')]");
	
	public ShiftingContentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPage() {
		driver.get("http://the-internet.herokuapp.com/shifting_content");
	}
	
	public void clickOnMenuExample() {
		driver.findElement(menuExampleButton).click();
	}
	
	public void clickOnImageExample() {
		driver.findElement(imageExampleButton).click();
	}
}
