package TestRunner;

import Classes.UserController;
import Classes.UserModel;
import Setup.Setup;
import Utils.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class LoginTestRunner {

    @Test(description = "Admin Login", priority = 1)
    public void adminLogin() throws ConfigurationException {
        UserController userController = new UserController();
        UserModel userModel = new UserModel();
        userModel.setEmail("admin@test.com");
        userModel.setPassword("admin123");

        Response response = userController.login(userModel);
        System.out.println(response.asString());

        JsonPath jsonPath = response.jsonPath();
        String adminToken = jsonPath.get("token");
        Utils.setEnvVar("adminToken",adminToken);
    }

    @Test(description = "User Login", priority = 2)
    public void userLogin() throws ConfigurationException, IOException {
        UserController userController = new UserController();
        UserModel userModel = new UserModel();

        Setup setup = new Setup();
        setup.getEnvVar();

        String email = setup.prop.getProperty("userEmail");
        userModel.setEmail(email);
        userModel.setPassword("1234");

        Response response = userController.login(userModel);
        System.out.println(response.asString());

        JsonPath jsonPath = response.jsonPath();
        String userToken = jsonPath.get("token");
        Utils.setEnvVar("userToken",userToken);
    }
}
