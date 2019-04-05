package stepdefinition;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RegistrationDefinitionClass {
	
	@Given(": user on the login page")
	public void user_on_the_login_page() {
	    System.out.println("user has navigated to the page succesfully");
	    
	}

	@When(": Entered the following details")
	public void entered_the_following_details(DataTable dataTable) {
	   List<List<String>> asList = dataTable.asLists(String.class);
	   for(int i=1;i<asList.size();i++) {
		   for(int j=0;j<i;j++)
		  System.out.println(asList.get(i).get(j).toString());
	   }
	   
	   
	  /* for(int i=0;i<asList.size();i++) {
		   
			   System.out.println(asList.get(i).get("FirstName").toString());
			   System.out.println(asList.get(i).get("LastName").toString());
			   
		   }*/
	   
	  
	   /*System.out.println(asList.get(0).get(1).toString());
	   System.out.println(asList.get(1).get(0).toString());
	  System.out.println(asList.get(1).get(1).toString());
	   System.out.println(asList.get(0).get(4).toString());
	   System.out.println(asList.get(0).get(5).toString());*/
	   
	}

	@When(": click on enter")
	public void click_on_enter() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("signup button has been succesfully clicked");
	}

	@Then(": account should be created succesfully")
	public void account_should_be_created_succesfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("account was created succesfully");
	   
	}



}
