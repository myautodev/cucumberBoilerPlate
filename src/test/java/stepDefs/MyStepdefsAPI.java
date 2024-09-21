package stepDefs;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MyStepdefsAPI {

    @Given("I get the value")
    public void iGetTheValue() {

        RestAssured.baseURI = "https://api.coindesk.com";

        try{

            Response response = RestAssured.given().get("/v1/bpi/currentprice.json");

            String responsBody = response.asString();
            JsonPath jsonPath = new JsonPath(responsBody);

            String gdb_Rate = jsonPath.getString("GBP");

            //Apologies been using Karate DSL to obtain nested elements in my current work scope

            System.out.println(gdb_Rate);



        }

        catch (Exception e){
            e.printStackTrace();
        }


    }

    }

