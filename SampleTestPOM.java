package userdefinedfunctions.pageobjectmodel;

import tcoe.framework.global.intialize.ClsInitialize;
import tcoe.framework.global.intialize.ClsInitialize.ClsInitializeFrameworkType;
import tcoe.framework.web.webhelpers.WebHelper;
import tcoe.framework.web.webmanager.ClsInitializeWeb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.support.events.WebDriverEventListener;

import tcoe.framework.userinterface.Button;

public class SampleTestPOM {
	WebHelper webhelperobj = new WebHelper();

	// ============Advisor remittance functions===============
	public boolean AmazonURl(String Amazon) {
		try {
			ClsInitializeWeb.getDriver().get("https://www.amazon.in/");
			WebHelper.Wait(5);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean AmazonSearchBox(String AmazonSearchBox) {
		try {
			WebHelper.Wait(5);
			ClsInitializeWeb.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(AmazonSearchBox);
			WebHelper.Wait(5);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean amzSearchBtn(String amzSearchBtn) {
		try {
			WebHelper.Wait(5);
			ClsInitializeWeb.getDriver().findElement(By.id("nav-search-submit-button")).click();
			// ClsInitializeWeb.getDriver().findElement(By.xpath("//div//span//input[@type=\"submit\"]").Click();
			WebHelper.Wait(5);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean ip16DT128Click(String iPhone16Pro128GBDesertTitanium) {
		try {
			WebHelper.Wait(5);
			//To handle elemet where we are not aware about the location on page
			//*[contains(text(),'Apple iPhone 16 Pro (128 GB) - Desert Titanium')]
			ClsInitializeWeb.getDriver().findElement(By.xpath("//a//span[text()='Apple iPhone 16 Pro Max (256 GB) - Desert Titanium']")).click();
			System.out.println("Clicked on the listing");
			WebHelper.Wait(5);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void SwitchTabInBrowser() {

		try

		{
			ArrayList<String> currentTabs = new ArrayList<String>(ClsInitializeWeb.getDriver().getWindowHandles());

			if (currentTabs.size() > 1) {

				ClsInitializeWeb.getDriver().switchTo().window(currentTabs.get(1));

				System.out.println("Switched Successfully !!!!");
			}

		} catch (Exception e)

		{

			System.out.println("Current Window");

		}

	}

	public boolean LabelVerify(String LabelVerify) {
		try {
			WebHelper.Wait(5);
			// ClsInitializeWeb.getDriver().findElement(By.id("nav-search-submit-button")).click();
			String ActualLabelValue = ClsInitializeWeb.getDriver().findElement(By.xpath("//*[contains(text(),'Visit the Apple Store')]")).getText();
			if (ActualLabelValue.equalsIgnoreCase(LabelVerify)) {
				System.out.println("value matched");
				System.out.println(ActualLabelValue);
				System.out.println(LabelVerify);

			} else
				System.out.println("Not matched");
			WebHelper.Wait(5);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void JsonFileParser() {
		try {
			String JsonFilePick = new String((Files.readAllBytes(Paths.get(
					"C:\\Users\\yh23\\Documents\\renewalfactory_phoenix-feature-AdvisorRemittance@e258f6660f3\\CucumberLatestFramework\\Advisor Remittance\\src\\test\\resources\\featurefiles\\GetExpectedResultsfromJSON.json"))));

			// org.json.JSONObject
			JSONObject jsonFile = new JSONObject(JsonFilePick);

			Set<String> Keys= jsonFile.keySet();
			for (String key : Keys)
			{
				Object value = jsonFile.get(key);
				System.out.println("---------------------------------------------------------------");
				System.out.println("key: " + key + " value: " + value);
				System.out.println("---------------------------------------------------------------");
			};
			
			//Validating the Expected results with the actual results from json file
			String ActualBrandValue = ClsInitializeWeb.getDriver().findElement(By.xpath("//*[@class='a-size-base a-text-bold' and text()='Brand']")).getText();
			String ExpectedBrandValue= jsonFile.getString("Brand");
			if (ActualBrandValue.equalsIgnoreCase(ExpectedBrandValue)) {
				System.out.println("Brand matched " +ActualBrandValue+ " vs " +ExpectedBrandValue);
			}
			else {
				System.out.println("Mismatch");
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed");
		}

		// //==================Below are all the web elements===================
		// //=============Advisor Remittance Elements============
		// @WebLocator_Desktop(PropertyType = "xpath", value = "//*[contains(text(),'SSO
		// Test Driver')]")
		// public Label MenuPortalABCTestDriverElement() throws IOException,
		// InterruptedException {
		// return new Label("MenuPortalABCTestDriverElement");

	}
}
