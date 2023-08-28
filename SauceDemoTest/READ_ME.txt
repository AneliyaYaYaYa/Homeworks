# SAUCE DEMO TESTS

The current project presents automated testing using Selenium WebDriver with Java. 
It includes several test cases that automate loging, adding products and succesfull cehck out. 
The tests are designed to run on different browsers, including Chrome, Firefox, Edge and their headless versions.

## MAIN
You can find the enum for different browser types set up.

## TEST/CORE
I have created a various helping classes here.

 - BaseTest - startUp and terminate the driver before and after each test; Tried the resetApp button 
but did not work as expected, so it is a work in progress. This base class also contains several methods.
 - ErrorMessages - success and error messages constants are here;
 - LoginForm & UserDetails - two separate classes to help with the fill in forms

### TEST/SAUCEDEMOTESTS
 - Logintests - a separate class for the login itself;
 - ProductTests - I have prepared 2 versions of productAddedToShoppingCart_when_addToCart test - 
one that checks all items and their prices using CSV tests 
and another one fo the homework itself. You can run whichever you like. :)


## Browser Support

The tests can be configured to run on different browsers by changing the `browserType` variable in the BaseTest/startUp. 
Supported browsers include:
- Chrome and Chrome_headless
- Firefox and Firefox_headless
- Edge and Edge_headless

## Running the Tests

To run the tests, you can use your preferred IDE with JUnit support or run them from the command line using Maven.

