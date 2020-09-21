Instructions:
1. Clone the GitHub repository in your local
2. Open command prompt in the same folder
3. Type "mvn test verify" and press enter
4. open Employee\target\cucumber-html-reports\overview-features.html
5. In right corner of HTML page click features to view features statistics
6. In right corner of HTML page click Failures to view all failures
7. In right corner of HTML page click Steps to view all implementations
8. Further open Employee\src\test\java\features\employeeValidations.feature to see all test cases
 
 
 
 
 -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 Warning : Status code is 429 when some frequent API call are made. This need to be fixed for good testing results.
 
 Bugs:
 1) End to End functionality of Update API is not working
 2) End to End functionality of Create API is not working
 3) End to End functionality of Delete API is not working
 4) Employee is getting created without body
 5) Employee is getting updated withouth body
