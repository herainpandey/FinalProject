package Test;

import Pojo.responses.UserListResponse;
import helper.WorkFlowHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static manager.ExtentTestManager.startTest;
import static Log.LogManager.Log;

public class RestAssuredTest {

    @Test(groups = "smoke")
    public void verifyUserList(Method method){
        startTest(method.getName() , "This test case will Pass");
        Log.info("Going to call Rest Api to get Total User list")  ;
        UserListResponse response = WorkFlowHelper.hitUserListAPI("api/users?page=2");
        Assert.assertEquals(String.valueOf(response.getTotal()),"12","List not match");

    }


    @Test(groups = "smoke")
    public void verifyUserListWrongExpectedValues(Method method){
        startTest(method.getName() , "This test case will Fail");
        Log.info("Going to call Rest Api to get Total User list");
        UserListResponse response = WorkFlowHelper.hitUserListAPI("api/users?page=2");
        Assert.assertEquals(String.valueOf(response.getTotal()),"14","List not match");

    }

}
