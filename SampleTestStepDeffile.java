package userdefinedfunctions.stepdefinitions;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import userdefinedfunctions.pageobjectmodel.SampleTestPOM;

public class SampleTestStepDeffile {

	SampleTestPOM sampletestpomobj = new SampleTestPOM();

	// =============SCENARIO 1=======================

	@Given("User is on amazon homepage")
	public void stepOne(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> lstTable = dataTable.asMaps(String.class, String.class);
		String Amazon = lstTable.get(0).get("Amazon");
		sampletestpomobj.AmazonURl(Amazon);
		System.out.println("URL opened");
	}

	@When("User is on Amazon and searches iphone16pro and clicks on search btn")
	public void stepTwo(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> lstTable = dataTable.asMaps(String.class, String.class);
		String AmazonSearchBox = lstTable.get(0).get("AmazonSearchBox");
		String amzSearchBtn = lstTable.get(0).get("amzSearchBtn");
		sampletestpomobj.AmazonSearchBox(AmazonSearchBox);
		sampletestpomobj.amzSearchBtn(amzSearchBtn);
		System.out.println("Text input complete");
	}

	@When("User is on iphone listing page and clicks on Apple iPhone listing")
	public void stepThree(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> lstTable = dataTable.asMaps(String.class, String.class);
		String iPhoneDesertTitanium = lstTable.get(0).get("iPhoneDesertTitanium");
		sampletestpomobj.ip16DT128Click(iPhoneDesertTitanium);
		System.out.println("SKIP");

	}

	@When("User is redirected to new tab where user validates a unique label")
	public void SwitchTab_PriceVerify(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> lstTable = dataTable.asMaps(String.class, String.class);
		String LabelVerify = lstTable.get(0).get("LabelVerify");
		System.out.println("Switch tab");
		sampletestpomobj.SwitchTabInBrowser();
		sampletestpomobj.LabelVerify(LabelVerify);
	}

	@When("User should validate the specifications wrt to data in a json file")
	public void JsonFileParserStep() {
		sampletestpomobj.JsonFileParser();
	}

	@Then("If Missmatch then Problem should be logged")
	public void if_Missmatch_then_Problem() {
		System.out.println("Scenario ends here, log defect if fail");
	}

}
