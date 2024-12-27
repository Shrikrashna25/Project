Feature: This feature tests the product with all scenarios

Scenario: Verify count of items for kids T-Shirt
	When User hovers on Kids Menu
	And Click on T-Shirt
	Then Wait for T-Shirt page to launch
	And Verify the category count and title count to be equal
	