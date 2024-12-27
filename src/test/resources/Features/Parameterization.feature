Feature: This feature explains parameterization in cucumber

Scenario: Parameteising a single step
	Given I have numbers 15 and 16
	When I add them
	Then verify if result is prime
	
@Regression @Sanity
Scenario: Passing list as arguments
	Given I have following fruits:
		|Mango|6|12|
		|Banana|12|33|
		|Apple|4|45|
		|Pineapple|1|45|
		|Strawberry|20|12|
	Then print them one by one
	
@Sanity
Scenario Outline:
	Given I have <pincode>
	Then print the pincode
Examples: 
	|pincode|
	|'411014'|
	|'411015'|
	|'411016'|
	|'411017'|
	|'411018'|
	|'411019'|
	