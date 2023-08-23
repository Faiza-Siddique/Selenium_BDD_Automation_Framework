Feature: Verify User is able to Login on the Website, Add 1 product in the cart and then Checkout

  @Login
  Scenario: Check user is able to open the Browser and Login to the SauceDemo
    Given user opens the browser
    Then user navigates to the URL
    When user enter text in username field
    When user enter text in password field
    Then user click on the "Login_Button"

  @Login  @Add-To-Cart
  Scenario: Check user is able Add product it cart and checkout
    Then user click on the "Product_Name"
    Then user click on the "Add_To_Cart"
    Then user click on the "Shopping_Cart"
    Then user click on the "Checkout_Button"
    When user enter text "Faiza" in "Address_FirstName" field
    When user enter text "Siddique" in "Address_LastName" field
    When user enter text "12345" in "Address_PostalCode" field
    Then user click on the "Address_Continue"
    Then user click on the "Finish"
    Given user Close The Browser












