package backend.rickandmorty.api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    protected RequestSpecification request;

    public BaseAPI() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api/";
        this.request = RestAssured.given();
    }

    protected Response get(String endpoint, Object... pathParams) {
        return request.pathParams("id", pathParams[0]).get(endpoint); 
    }
}