package backend.rickandmorty.character;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import backend.rickandmorty.api.character.CharacterAPI;
import io.restassured.response.Response;

public class CharacterEndpointTest {

    private CharacterAPI characterAPI;

    @BeforeClass
    public void setup() {
        characterAPI = new CharacterAPI();
    }

    @Test
    public void testGetCharacterStatusCode() {
        Response response = characterAPI.getCharacterById(1);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }


    @Test
    public void testGetCharacterResponsePayload() {
        Response response = characterAPI.getCharacterById(1);
        String name = response.jsonPath().getString("name");
        String status = response.jsonPath().getString("status");
        String species = response.jsonPath().getString("species");

        Assert.assertEquals(name, "Rick Sanchez", "Expected character name to be Rick Sanchez");
        Assert.assertEquals(status, "Alive", "Expected status to be Alive");
        Assert.assertEquals(species, "Human", "Expected species to be Human");
    }

    @Test
    public void testGetCharacterResponseHeaders() {
        Response response = characterAPI.getCharacterById(1);
        String contentType = response.getHeader("Content-Type");
        String dateHeader = response.getHeader("Date");

        Assert.assertEquals(contentType, "application/json; charset=utf-8", "Expected Content-Type to be application/json; charset=utf-8");
        Assert.assertNotNull(dateHeader, "Expected Date header to be present");
    }
}