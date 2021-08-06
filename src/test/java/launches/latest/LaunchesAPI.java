package launches.latest;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class LaunchesAPI {

    private static String LAUNCHES_BY_LATEST = "https://api.spacexdata.com/v4/launches/latest";

    @Step("Get launches by latest")
    public void fetchLatestBySpaceLaunches() {
        SerenityRest.given()
                .get(LAUNCHES_BY_LATEST);
    }
}
