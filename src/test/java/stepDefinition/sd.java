package stepDefinition;
import static resources.utils.*;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sd {
	RequestSpecification res;
	Response response;
	Response response2;
	@Given("Add Employee payload")
	public void add_employee_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		res = given()
				.header("Content-Type","application/json")
				.body(new String(Files.readAllBytes(Paths.get("src\\test\\java\\emp.json").toAbsolutePath())));
	}

	@When("user calls {string} with Post request")
	public void user_calls_with_post_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		response =res.when().post("api/v1/create")
				.then().log().all().extract().response();
	}
	@Then("the status code is {int}")
	public void the_status_code_is(Integer status) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals((Integer)response.getStatusCode(),status);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(getJsonPath(response, "message"),value);
	}
	@Given("Update Employee payload")
	public void update_employee_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		res = given()
				.header("Content-Type","application/json")
				.body(new String(Files.readAllBytes(Paths.get("src\\test\\java\\empUpd.json").toAbsolutePath())));
	}
	@When("user calls updateAPI with Put request")
	public void user_calls_update_api_with_put_request() {
	    // Write code here that turns the phrase above into concrete actions
		response =res.when().put("/api/v1/update/21")
				.then().extract().response();
	}
	@Given("get a employee")
	public void get_a_employee() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		res = given();
	}

	@When("user calls getPI with GET request")
	public void user_calls_get_pi_with_get_request() {
	    // Write code here that turns the phrase above into concrete actions
		response =res.when().get("/api/v1/employee/21")
				.then().extract().response();
	}
	@Given("delete a employee")
	public void delete_a_employee() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		res = given();
	}

	@When("user calls deleteAPI with delete request")
	public void user_calls_delete_api_with_delete_request() {
	    // Write code here that turns the phrase above into concrete actions
		response =res.when().delete("/api/v1/delete/21")
				.then().extract().response();
	}
	@Given("get all employees")
	public void get_all_employees() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		res = given();
	}

	@When("user calls getAllAPI with GET request")
	public void user_calls_get_all_api_with_get_request() {
	    // Write code here that turns the phrase above into concrete actions
		response =res.when().get("/api/v1/employees")
				.then().extract().response();
	}
	@Then("get the employee by ID")
	public void get_the_employee_by_id() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res= given();
		
		response= res.when().get("/api/v1/employee/21")
		.then().log().all().extract().response();
	}

	@Then("Verify Employee information")
	public void verify_employee_information() {
	    // Write code here that turns the phrase above into concrete actions
		String employeeName= getJsonPath(response, "data.employee_name");
		assertEquals(employeeName,"test");
	}
	@Then("update employee payload by id")
	public void update_employee_payload_by_id() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		String id= getJsonPath(response, "data.id");
		res = given()
				.header("Content-Type","application/json")
				.body(new String(Files.readAllBytes(Paths.get("src\\test\\java\\empUpd.json").toAbsolutePath())));
		response =res.when().put("/api/v1/update/"+id+"")
				.then().extract().response();
	}

	@Then("Verify updated Employee information")
	public void verify_updated_employee_information() {
	    // Write code here that turns the phrase above into concrete actions
		String employeeName= getJsonPath(response, "data.employee_name");
		assertEquals(employeeName,"testUpdate");
	}
	@Then("delete the employee by ID")
	public void delete_the_employee_by_id() {
	    // Write code here that turns the phrase above into concrete actions
		String id= getJsonPath(response, "data.id");
		res = given();
		response =res.when().delete("/api/v1/delete/"+id+"")
				.then().extract().response();
	}
	@Given("Donot Add Employee body")
	public void donot_add_employee_body() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		res = given();
	}
	@Then("get the deleted employee by ID")
	public void get_the_deleted_employee_by_id() {
	    // Write code here that turns the phrase above into concrete actions
		response= res.when().get("/api/v1/employee/2")
				.then().log().all().extract().response();
	}

	
}