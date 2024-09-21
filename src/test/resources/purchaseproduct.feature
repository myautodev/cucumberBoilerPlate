Feature: User is able to purchase a product
  Scenario Outline: The user logs into application and purchases a bottle of wine
    Given I am logged into the app with "<username>" and  "<password>"
    When  I navigate to the shop
#    When I select the product and add to cart
#    When I click on checkout
#    Then I print the order Number




    Examples:

      | username | password    |  |
      | TestUser | Tester5027# |  |
