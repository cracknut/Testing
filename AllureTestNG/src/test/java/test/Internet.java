package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import page.*;

@Listeners(AllureListener.class)
public class Internet {
	public static WebDriver driver;
	HomePage homePage;
	FileUploadPage fileUploadPage;
	ShiftingContentPage shiftingContentPage;
	ShiftingContentMenu shiftingContentMenu;
	ShiftingContentImage shiftingContentImage;
	ChallengingDOMPage challengingDOMPage;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		homePage = new HomePage(driver);
		fileUploadPage = new FileUploadPage(driver);
		shiftingContentPage = new ShiftingContentPage(driver);
		shiftingContentMenu = new ShiftingContentMenu(driver);
		shiftingContentImage = new ShiftingContentImage(driver);
		challengingDOMPage = new ChallengingDOMPage(driver);
	}
	
	@Test(priority=1)
	@Description("Check if we're able to upload a file")
	@Epic("EA1")
	@Feature("File Upload")
	public void fileUploadTest() {
		homePage.getPage();
		homePage.clickOnFileUpload();
		fileUploadPage.chooseFile(new File("./").getAbsolutePath() + "\\Test.txt");
		fileUploadPage.clickOnSubmitButton();
		Assert.assertEquals(fileUploadPage.verifyUpload(), true);
	}
	
	@Test(priority=2)
	@Epic("EA1")
	@Description("Check if shifting content is shifting")
	@Feature("Shifting Content")
	public void shiftingContentTest() {
		//Button
		homePage.getPage();
		homePage.clickOnShiftingContent();
		shiftingContentPage.clickOnMenuExample();
		Assert.assertEquals(shiftingContentMenu.checkButtonResponseOnHover("Home"), false);
		
		//Image
		homePage.getPage();
		homePage.clickOnShiftingContent();
		shiftingContentPage.clickOnImageExample();
		Assert.assertEquals(shiftingContentImage.verifyPixelShift(), false);
	}
	
	@Test(priority=3)
	@Epic("EA1")
	@Description("Check if all data in row 1 ends with 0")
	@Feature("Matching Data")
	public void challengingDOMTest() {
		homePage.getPage();
		homePage.clickOnChallengingDOM();
		boolean isAllSame = challengingDOMPage.compareLastCharactersInRow("0", 0);
		Assert.assertEquals(isAllSame, true);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
