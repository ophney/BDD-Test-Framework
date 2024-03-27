Feature: Add Item to Card

  Scenario: Search for an item and add it to the cart
    Given the user navigates to shopping website homepage
    When user search for an item
    And select the desired item from the search results
    And add item to the card
    Then the correct item should be added to the cart
