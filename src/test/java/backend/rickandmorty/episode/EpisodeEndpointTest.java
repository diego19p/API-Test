package backend.rickandmorty.episode;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import backend.rickandmorty.api.episode.EpisodeAPI;
import io.restassured.response.Response;

public class EpisodeEndpointTest {

    private EpisodeAPI episodeAPI;

    @BeforeClass
    public void setup() {
        episodeAPI = new EpisodeAPI();
    }

    @Test
    public void testGetEpisodeDetails() {
        Response response = episodeAPI.getEpisodeById(1);
        Assert.assertNotNull(response.jsonPath().get("id"), "Field 'id' should not be null");
        Assert.assertNotNull(response.jsonPath().get("name"), "Field 'name' should not be null");
        Assert.assertNotNull(response.jsonPath().get("air_date"), "Field 'air_date' should not be null");
        Assert.assertNotNull(response.jsonPath().get("episode"), "Field 'episode' should not be null");
        Assert.assertNotNull(response.jsonPath().get("characters"), "Field 'characters' should not be null");
        Assert.assertNotNull(response.jsonPath().get("url"), "Field 'url' should not be null");
        Assert.assertNotNull(response.jsonPath().get("created"), "Field 'created' should not be null");
    }
}