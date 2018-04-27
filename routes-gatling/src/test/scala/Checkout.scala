//import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Checkout extends Simulation {
  val httpProtocol = http.baseURL("http://localhost:8030/route/checkout")
    .acceptHeader("application/json").contentTypeHeader("application/json")

  val scn = scenario("CheckoutSimulation")
    .exec(http("request_1")
    .post("/").body(RawFileBody("checkoutBody.json")).asJSON)
    .pause(5)

  setUp(
    scn.inject(constantUsersPerSec(40) during (200))
  ).protocols(httpProtocol)
}