
@tag
Feature: Validate the error from Ecommerce website
  
  Background: 
  Given I landed on Ecommerce Page
  
  @negative
  Scenario Outline: Negative Test of submitting the order
    Given I landed on Ecommerce Page
  	When Logged in with username <name> and password <pass>  	
  	Then validate the error msg "Incorrect email or password."
  	
  	
  	Examples:
  	 |name  						|pass					  |
  	 |abhinav@gmail.com	|Sher@84140700	|

