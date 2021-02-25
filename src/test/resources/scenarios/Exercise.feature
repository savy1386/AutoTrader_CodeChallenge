Feature: Exercise feature file 
			This is the coding exercise feature
			To verify links and
			To perform advanced search
	
	
Scenario: Search for Cars 
	Given user is on autotrader home page 
	Then verify expected elements are present
	When perform advanced search of "BMW" in zip "30004" from year "2017" to year "2020"
	Then results should contain searched "BMW" vehicle