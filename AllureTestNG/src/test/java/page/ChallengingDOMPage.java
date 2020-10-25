package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengingDOMPage {
	WebDriver driver;

	By contentTable = By.xpath("//div[@class='large-10 columns']//table//tbody");
	By trTag = By.tagName("tr");
	By tdTag = By.tagName("td");
	
	public ChallengingDOMPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPage() {
		driver.get("http://the-internet.herokuapp.com/challenging_dom");;
	}
	
	public boolean compareLastCharactersInRow(String lastCharacter, Integer rowIndex) {
		WebElement tbody = driver.findElement(contentTable);
		List<WebElement> rows = tbody.findElements(trTag);
		List<WebElement> firstRow = rows.get(rowIndex).findElements(tdTag);
		
		for(int i = 0; i < firstRow.size() - 1; i++) {
			boolean endsWithZero = firstRow.get(i).getText().endsWith(lastCharacter);
			if(!endsWithZero) {
				return false;
			}
		}
		
		return true;
	}
}
