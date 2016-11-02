Feature: Retrieving Stocks

  Scenario: Should be able to get a list of all stocks
    Given the application has been initialised with test data
    When the client gets all stocks
    Then a list of 5 stocks will be returned