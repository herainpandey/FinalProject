package requestInitializer;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public interface RequestSpec {


    static RequestSpecification getGlobalRequestSpec(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        RequestSpecification spec = builder.build();
        return spec;
    }

    RequestSpecification getSpec() throws Exception;
}
