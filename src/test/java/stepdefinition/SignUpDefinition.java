package stepdefinition;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class SignUpDefinition {
	
	@Given(": I on the login page")
	public void i_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@When(": Entered the following credentials")
	public void entered_the_following_credentials (DataTable dt) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	     
		List<Map<String, String>> asList = dt.asMaps(String.class,String.class);
		
		for(Map EachMap: asList) {
			System.out.println(EachMap.get("Email"));
		}
		
		/*System.out.println(asList.get(0).get("username"));
		System.out.println(asList.get(0).get("password"));
		System.out.println(asList.get(1).get("username"));
		System.out.println(asList.get(0).get("password"));
		System.out.println();*/
	}

	@When(": click on the login button")
	public void click_on_the_login_button() {
	    System.out.println("clicked on login button");
	     
	}

	@Then(": i should be on the home page")
	public void i_should_be_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("yeahhh..!, i'm on the home page");
	     
	}


}
