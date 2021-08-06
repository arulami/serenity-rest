package launches.latest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class LaunchesStepDefinitions {

    @Steps
    LaunchesAPI launchesAPI;

    @When("I look up a rocket latest launches")
    public void lookUpAPostCode() {
        launchesAPI.fetchLatestBySpaceLaunches();
    }

    @Then("the launch status should be success")
    public void theResultingLocationShouldBe() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(LaunchesResponse.SUCCESS, equalTo(true)));
    }

    @And("I should see rocket fire date")
    public void theFireDate(){
        restAssuredThat(response -> response.body(LaunchesResponse.FIREDATE, containsString(":")));
    }

    @Then("I should see the links has items")
    public void theLinkItems(){
        restAssuredThat(response -> response.body(LaunchesResponse.LINKS, hasKey("patch")));
        restAssuredThat(response -> response.body(LaunchesResponse.LINKS, hasKey("reddit")));
        restAssuredThat(response -> response.body(LaunchesResponse.LINKS, hasKey("flickr")));
    }

    @And("I should see youtube and wikipedia links")
    public void youTubeAndWikipedia(){
        restAssuredThat(response -> response.body(LaunchesResponse.WIKI, not(emptyString())));
        restAssuredThat(response -> response.body(LaunchesResponse.YOUTUBE, not(emptyString())));
    }

    @Then("I should see launch pad details")
    public void i_should_see_launch_pad_details() {
        restAssuredThat(response -> response.body(LaunchesResponse.LAUNCHPAD, not(emptyString())));
    }
    @Then("I should see flight Number")
    public void i_should_see_flight_number() {
        restAssuredThat(response -> response.body(LaunchesResponse.FLIGHTNUMBER, greaterThan(0)));
    }
    @Then("I should see name and id")
    public void i_should_see_name_and_id() {
        restAssuredThat(response -> response.body(LaunchesResponse.FLIGHTNAME, not(emptyString())));
        restAssuredThat(response -> response.body(LaunchesResponse.ID, not(emptyString())));
    }

    @Then("I should see core details")
    public void i_should_see_core_details() {
        restAssuredThat(response -> response.body(LaunchesResponse.CORE, not(emptyString())));
        restAssuredThat(response -> response.body(LaunchesResponse.FLIGHT, not(emptyString())));
        restAssuredThat(response -> response.body(LaunchesResponse.LANDINGTYPE, not(emptyString())));
        restAssuredThat(response -> response.body(LaunchesResponse.LANDINGSUCCESS, equalTo(true)));
    }

    @And("I should see capsule details")
    public void i_should_see_capsule(){
        restAssuredThat(response -> response.body(LaunchesResponse.CAPSULE, not(emptyString())));
    }

}
