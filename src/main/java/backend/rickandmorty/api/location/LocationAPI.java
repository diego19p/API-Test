package backend.rickandmorty.api.location;

import backend.rickandmorty.api.base.BaseAPI;
import io.restassured.response.Response;

public class LocationAPI extends BaseAPI {

    public Response getLocationById(int id) {
        return get("/location/{id}", id);
    }

    public Response getAllLocations() {
        return get("/location");
    }
}