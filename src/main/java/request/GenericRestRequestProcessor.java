package request;

import Enum.RequestType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenericRestRequestProcessor {


    public static Response getResponse(RequestSpecification requestSpecification, RequestType type, String resourceURL){

        Response response = null;

        if(type == RequestType.GET){
            response = given()
                    .spec(requestSpecification)
                    .when()
                    .get(resourceURL)
                    .then().extract().response();

        }
        else if(type == RequestType.POST){
            response = given()
                    .spec(requestSpecification)
                    .when()
                    .post(resourceURL)
                    .then().extract().response();

        }else if(type == RequestType.PUT){
            response = given()
                    .spec(requestSpecification)
                    .when()
                    .put(resourceURL)
                    .then().extract().response();

        }


        return response;
    }
}
