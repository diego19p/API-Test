package backend.rickandmorty.location;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import backend.rickandmorty.api.location.LocationAPI;
import io.restassured.response.Response;

public class LocationEndpointTest {

    private LocationAPI locationAPI;

    @BeforeClass
    public void setup() {
        locationAPI = new LocationAPI();
    }

    @Test
    public void testGetLocationDetails() {
        Response response = locationAPI.getLocationById(1);
        Assert.assertNotNull(response.jsonPath().get("id"), "Field 'id' should not be null");
        Assert.assertNotNull(response.jsonPath().get("name"), "Field 'name' should not be null");
        Assert.assertNotNull(response.jsonPath().get("type"), "Field 'type' should not be null");
        Assert.assertNotNull(response.jsonPath().get("dimension"), "Field 'dimension' should not be null");
        Assert.assertNotNull(response.jsonPath().get("residents"), "Field 'residents' should not be null");
        Assert.assertNotNull(response.jsonPath().get("url"), "Field 'url' should not be null");
        Assert.assertNotNull(response.jsonPath().get("created"), "Field 'created' should not be null");
    }
}