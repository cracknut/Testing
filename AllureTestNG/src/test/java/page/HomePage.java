package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	By fileUpload = By.xpath("//a[contains(text(),'File Upload')]");
	By shiftingContent = By.xpath("//a[contains(text(),'Shifting Content')]");
	By challengingDOM = By.xpath("//a[contains(text(),'Challenging DOM')]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPage() {
		driver.get("http://the-internet.herokuapp.com/");;
	}
	
	public void clickOnFileUpload() {
		driver.findElement(fileUpload).click();
	}

	public void clickOnShiftingContent() {
		driver.findElement(shiftingContent).click();
	}

	public void clickOnChallengingDOM() {
		driver.findElement(challengingDOM).click();
	}
}
