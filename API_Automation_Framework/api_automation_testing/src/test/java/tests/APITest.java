package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static constants.Endpoints.GET_POST;
import io.restassured.response.Response;
import utils.APIUtils;
import utils.ConfigLoader;

public class APITest {

    @BeforeClass
    public void setup() {
        ConfigLoader.loadConfig();
  
    }

    @Test
    public void verifyGetRequest() {
        // Make GET call
        Response response = APIUtils.getCall(GET_POST);

        // Assert Response Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code is 200");

        // Assert Response Body
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"id\": 1"), "Response body does not contain expected ID.");
        Assert.assertTrue(responseBody.contains("\"userId\": 1"), "Response body does not contain expected User ID.");
        Assert.assertTrue(responseBody.contains("title"), "Response body does not contain title key.");
        Assert.assertTrue(responseBody.contains("body"), "Response body does not contain body key.");

        // Print Response
        System.out.println("Response: " + response.prettyPrint());
    }
}
