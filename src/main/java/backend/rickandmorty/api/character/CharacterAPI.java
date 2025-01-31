package backend.rickandmorty.api.character;

import backend.rickandmorty.api.base.BaseAPI;
import io.restassured.response.Response;

public class CharacterAPI extends BaseAPI {

    public Response getCharacterById(int id) {
        return get("/character/{id}", id);
    }

    public Response getAllCharacters() {
        return get("/character");
    }

}