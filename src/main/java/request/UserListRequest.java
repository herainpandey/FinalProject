package request;

import Base.BaseRestRequest;
import Pojo.RestResponse;
import Pojo.responses.UserListResponse;
import Enum.RequestType;
import io.restassured.response.Response;
import requestInitializer.UserListSpecProvider;

public class UserListRequest extends BaseRestRequest {

    public static UserListRequest request=null;
    UserListRequest(String resourceURL){
     super(new UserListSpecProvider().getSpec(),resourceURL);
    }


    public static UserListRequest getInstance(String resourceURL){
        if(request==null){
            request = new UserListRequest(resourceURL);
        }else{
            if(!resourceURL.startsWith("/")){
                resourceURLs = "/" + resourceURL;
            }else{
                resourceURLs = resourceURL;
            }
        }
        return request;
    }


    public Response call(){
        return sendRequestAndGetResponse(RequestType.GET);
    }
}
