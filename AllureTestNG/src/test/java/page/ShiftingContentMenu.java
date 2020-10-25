package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShiftingContentMenu {
	WebDriver driver;
	
	public ShiftingContentMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPage() {
		driver.get("http://the-internet.herokuapp.com/shifting_content/menu");
	}
	
	public boolean checkButtonResponseOnHover(String buttonText) {
		WebElement button = driver.findElement(By.xpath("//a[contains(text(),'" + buttonText + "')]"));
		Dimension elementSize = button.getSize();
		Actions action = new Actions(driver);
		action.moveToElement(button).perform();
		return button.getSize().equals(elementSize);
	}
}
