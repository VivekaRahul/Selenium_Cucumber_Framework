Feature: Purchase a product from Demoblaze

  Scenario: Add Samsung Galaxy S6 and complete purchase
    Given I am on the "https://www.demoblaze.com" website
    When I scroll to the "Samsung galaxy s6" product
    And I click on the "Samsung galaxy s6" product
    And I click the "Add to cart" button
    And I accept the alert
    And I navigate to the cart page
    And I click the "Place Order" link or button 
    And I scroll to the "Purchase" button   
    And I click the "Purchase" button without filling details 
    Then I should see an alert message and accept it
    When I enter valid purchase details
    And I click the "Purchase" link or button  
    Then I should see the success message
    And I take a screenshot of a success message  
    And I click "OK" link or button 
    
     
  Scenario: Add MacBook Pro and complete purchase
    Given I am on the "https://www.demoblaze.com" website
    When I scroll to the "CATEGORIES" section
    And I click on the "Laptops" category
    And I scroll to the "MacBook Pro" product
    And I click on the "MacBook Pro" product
    And I click the "Add to cart" button
    And I accept the alert
    And I navigate to the cart page
    And I click the "Place Order" link or button 
    And I scroll to the "Purchase" button   
    And I click the "Purchase" button without filling details 
    Then I should see an alert message and accept it
    When I enter valid purchase details
    And I click the "Purchase" link or button
    Then I should see the success message
    And I take a screenshot of a success message         
    And I click "OK" link or button 
   
     