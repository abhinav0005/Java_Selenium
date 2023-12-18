
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommerce Page
  
  @positive
  Scenario Outline: Positive Test of submitting the order
  
  	Given Logged in with username <name> and password <pass>
  	When i add product <productName> to cart
  	And checkout <productName> 
  	Then submit the order
  	
  	Examples:
  	 |name  						|pass					|productName |
  	 |abhinav@gmail.com	|Sher@841407	|ZARA COAT 3 |

