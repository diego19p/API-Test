package backend.rickandmorty.utils;

import io.restassured.response.Response;

public class RestAssuredUtils {

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    public static void validateResponseTime(Response response, long maxResponseTime) {
        long responseTime = response.getTime();
        if (responseTime > maxResponseTime) {
            throw new AssertionError("Response time exceeded " + maxResponseTime + " ms");
        }
    }
}
