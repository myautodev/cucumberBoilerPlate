package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MyStepdefsAPI {

    @When("I get the value")
    public void iGetTheValue() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Map<String, String> formParams = new HashMap<>();
        formParams.put("status", "available");


        Response response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(formParams)
                .get("/pet/findByStatus");
        String rawResponse = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(rawResponse);

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);


//        Map<String, Object> firstElement = jsonPath.getMap("[1]");
//        System.out.println("First element: " + firstElement);







    }
}



