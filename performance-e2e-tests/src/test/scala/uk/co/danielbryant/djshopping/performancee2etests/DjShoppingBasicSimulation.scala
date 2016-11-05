package uk.co.danielbryant.djshopping.performancee2etests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class DjShoppingBasicSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8010")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val primaryScenario = scenario("DJShopping website and API performance test")
    .exec(http("website")
      .get("/")
      .check(
        status is 200,
        substring("Docker Java")))
    .pause(7)

    .exec(http("products API")
      .get("/products")
      .check(
        status is 200,
        jsonPath("$[0].id") is "1",
        jsonPath("$[0].sku") is "12345678"))

  setUp(primaryScenario.inject(
    constantUsersPerSec(30) during (30 seconds)
  ).protocols(httpProtocol))
    .assertions(global.responseTime.max.lessThan(50))
    .assertions(global.failedRequests.percent.is(0))
}
