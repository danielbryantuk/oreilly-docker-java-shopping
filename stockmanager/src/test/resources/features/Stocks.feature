Feature: Retrieving Stocks

  Scenario: Should be able to get a list of all stocks
    Given the application has been initialised with test data
    When the client gets all stocks
    Then a list of 5 stocks will be returned

  Scenario: Should be able to get the correct SKU for the first stock
    Given the application has been initialised with test data
    When the client gets all stocks
    Then the stock at index 0 will have the sku 12345678