package helper;

import Pojo.responses.UserListResponse;
import request.UserListRequest;

public class WorkFlowHelper {

    static UserListRequest request;

    private WorkFlowHelper instance= null;
    private WorkFlowHelper(){

    }


    public WorkFlowHelper getInstance(){
        if(instance == null){
            instance = new WorkFlowHelper();
        }
        return instance;
    }

    public static UserListResponse hitUserListAPI(String resourseURL){
        request = UserListRequest.getInstance(resourseURL);
        return request.call().as(UserListResponse.class);
    }
}
