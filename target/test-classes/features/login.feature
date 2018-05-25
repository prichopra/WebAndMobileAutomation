Feature: Login into Straits Time

  Scenario Outline: Login into Straits Time
  	Given I want to launch the Straits Times site
    When I want to login the straits time site as <UserName> and <Password>
  	#When User enters the email ID
  	#And User enters the password
  	
Examples:
    |UserName     |Password   |
    |digitaltest1 |Sphdigital1|