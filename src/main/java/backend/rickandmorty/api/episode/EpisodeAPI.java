package backend.rickandmorty.api.episode;

import backend.rickandmorty.api.base.BaseAPI;
import io.restassured.response.Response;

public class EpisodeAPI extends BaseAPI {

    public Response getEpisodeById(int id) {
        return get("/episode/{id}", id);
    }

    public Response getAllEpisodes() {
        return get("/episode");
    }
}
