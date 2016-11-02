$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Stocks.feature");
formatter.feature({
  "line": 1,
  "name": "Retrieving Stocks",
  "description": "",
  "id": "retrieving-stocks",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Should be able to get a list of all stocks",
  "description": "",
  "id": "retrieving-stocks;should-be-able-to-get-a-list-of-all-stocks",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the application has been initialised with test data",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the client gets all stocks",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "a list of 5 stocks will be returned",
  "keyword": "Then "
});
formatter.match({
  "location": "RestStepDefs.init()"
});
formatter.result({
  "duration": 84321994,
  "status": "passed"
});
formatter.match({
  "location": "RestStepDefs.getAllStocks()"
});
formatter.result({
  "duration": 402617962,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 10
    }
  ],
  "location": "RestStepDefs.assertListOfStocksLength(int)"
});
formatter.result({
  "duration": 6269809,
  "status": "passed"
});
});