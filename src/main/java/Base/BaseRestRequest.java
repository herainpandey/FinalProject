package Base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import request.GenericRestRequestProcessor;
import Enum.RequestType;

public class BaseRestRequest {

    RequestSpecification requestSpecification;
    protected static String resourceURLs;
    Response response;


    public BaseRestRequest(RequestSpecification requestSpecification , String resourceURL){
        this.requestSpecification = requestSpecification;
        if(!resourceURL.startsWith("/")){
            this.resourceURLs="/"+resourceURL;
        }else{
            this.resourceURLs=resourceURL;
        }
    }


    public Response sendRequestAndGetResponse(RequestType type){
        Response reponse = GenericRestRequestProcessor.getResponse(requestSpecification, type, this.resourceURLs);
        this.response = reponse;
        return reponse;
    }



}
