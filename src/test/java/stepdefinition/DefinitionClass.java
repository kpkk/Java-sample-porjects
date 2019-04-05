package stepdefinition;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class DefinitionClass {
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	   System.out.println("this is given step");
	    
	}

	@When("^enter the username \"(.*)\" and password \"(.*)\"")
	public void enetered_the_username_and_password(String s1, String s2) {
		
		System.out.println(s1);
		System.out.println(s2);
		 
		 
	  
	}

	@When("Click on signin button")
	public void click_on_signin_button() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is second when step");
	}

	@Then("user should be navigated to home page succesfully")
	public void user_should_be_navigated_to_home_page_succesfully() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is then step");
	}


}
