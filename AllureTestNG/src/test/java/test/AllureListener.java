package test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener{
	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] saveScreenshot(String name, WebDriver driver) {
		return (byte[])((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		saveScreenshot(result.getName(), Internet.driver);
	}//*/
}
