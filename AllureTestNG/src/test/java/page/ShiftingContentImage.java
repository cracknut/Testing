package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class ShiftingContentImage {
	WebDriver driver;

	By image = By.xpath("//img[@class='shift']");
	By shiftButton = By.xpath("//a[@href='/shifting_content/image?pixel_shift=100']");
	
	public ShiftingContentImage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPage() {
		driver.get("http://the-internet.herokuapp.com/shifting_content/image");;
	}
	
	public boolean verifyPixelShift() {
		Point oldLocation = driver.findElement(image).getLocation();
		driver.findElement(shiftButton).click();
		Point newLocation = driver.findElement(image).getLocation();
		return oldLocation.equals(newLocation);
	}
}
