package requestInitializer;

import io.restassured.specification.RequestSpecification;
import request.GenericRestRequestProcessor;

import java.util.HashMap;
import java.util.Map;

public class UserListSpecProvider implements RequestSpec{
    public RequestSpecification getSpec(){
        RequestSpecification spec = RequestSpec.getGlobalRequestSpec();
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","applicatioin/json");
        spec.headers(headerMap);
        spec.baseUri("https://reqres.in/");
        return  spec;
    }
}
