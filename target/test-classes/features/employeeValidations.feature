Feature: Validating Employee API

Scenario: Verify status code and message in response when employee is created
	Given Add Employee payload
	When user calls "createAPI" with Post request
	Then the status code is 200
	And "message" in response body is "Successfully! Record has been added."
	
Scenario: Verify status code and message in response when employee is updated
	Given Update Employee payload
	When user calls updateAPI with Put request
	Then the status code is 200
	And "message" in response body is "Successfully! Record has been updated."

Scenario: Verify status code and message in response when user get a employee
	Given get a employee
	When user calls getPI with GET request
	Then the status code is 200
	And "message" in response body is "Successfully! Record has been fetched."
	
Scenario: Verify status code and message in response when a employee is deleted
	Given delete a employee
	When user calls deleteAPI with delete request
	Then the status code is 200
	And "message" in response body is "Successfully! Record has been deleted"
	
Scenario: Verify status code and message in response when user get all employees
	Given get all employees
	When user calls getAllAPI with GET request
	Then the status code is 200
	And "message" in response body is "Successfully! All records has been fetched."
	
Scenario: Verify if getAPI shows Employee informtion when addAPI adds an Employee
	Given Add Employee payload
	When user calls "createAPI" with Post request
	Then get the employee by ID
	And Verify Employee information

Scenario: Verify if getAPI shows Updated Employee informtion when UpdateAPI update an Employee
	Given Update Employee payload
	When user calls updateAPI with Put request
	Then get the employee by ID
	And Verify updated Employee information

Scenario: Verify if getAPI doesnot shows you Employee informtion when DeleteAPI delete an Employee
	Given delete a employee
	When user calls deleteAPI with delete request
	Then verify if we can't get the employee by ID

Scenario: To verify Entire crud operation at once
	Given Add Employee payload
	When user calls "createAPI" with Post request
	Then update employee payload by id
	And get the employee by ID
	And delete the employee by ID
	And verify if we can't get the employee by ID

Scenario: To verify if we cant create withouth body
	Given Donot Add Employee body
	When user calls "createAPI" with Post request
	Then the status code is 422

Scenario: To verify if we cant update withouth body
	Given Donot Add Update Employee body
	When user calls updateAPI with Put request
	Then the status code is 422
	
	
	