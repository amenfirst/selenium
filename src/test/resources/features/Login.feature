
@E2E
Feature: As a user, I want to enter my email and my password to authenticate

	Background:
		Given I launch the TUTTO application #pré-conditions
    
    When I click on login icon of nav-menu #action
    Then Connexion Page is opened #resultat attendu
    @REGRESSION_TEST
  Scenario Outline: Connect with wrong email or password
  
    
    
    When I enter the mail "<mail>" and password "<password>"
    And I click on connect button
    Then An error "<message>" is dispalyed
    
    Examples:
|mail|password|message|
|anis.fatnassi.c@gmail.com|687fegrzef|Échec d'authentification|
|anis.fatnassi89556qs@gmail.com|06061993|Erreur|
  @SMOKE_TEST
  Scenario: Connect with email and password correct

    
    When I enter the mail and password correct 
    And I click on connect button 
    Then I connect to my application's account
  
  
    
    