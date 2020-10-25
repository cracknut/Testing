package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
	WebDriver driver;

	By browseFileButton = By.xpath("//input[@id='file-upload']");
	By submitButton = By.xpath("//input[@id='file-submit']");
	By uploadedFileName = By.xpath("//div[@id='uploaded-files']");
	
	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPage() {
		driver.get("http://the-internet.herokuapp.com/upload");
	}
	
	public void chooseFile(String filePath) {
		driver.findElement(browseFileButton).sendKeys(filePath);
	}

	public void clickOnSubmitButton() {
		driver.findElement(submitButton).click();
	}

	public boolean verifyUpload() {
		return driver.findElement(uploadedFileName).getText().matches("Test.txt");
	}
}
