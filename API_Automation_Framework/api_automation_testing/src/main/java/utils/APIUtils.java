package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIUtils {
    public static Response getCall(String endpoint) {
        return given()
                .baseUri(ConfigLoader.getProperty("baseUrl"))
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}