package Classes;

import Setup.Setup;
import Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserController {

    public UserController(){
        RestAssured.baseURI = "https://dailyfinanceapi.roadtocareer.net";
    }

    // Login
    public Response login(UserModel userModel){
        String content = "application/json";
        String path = "/api/auth/login";
        Response response = given().contentType(content).body(userModel).when().post(path);
        return response;
    }

    // User Registration
    public Response userRegistration(UserModel userModel){
        String content = "application/json";
        String path = "/api/auth/register";
        Response response = given().contentType(content).body(userModel).when().post(path);
        return response;
    }

    // Get User List
    public Response userList(){
        Setup setup = new Setup();
        try {
            setup.getEnvVar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String content = "application/json";
        String path = "/api/user/users";
        Response response = given().contentType(content)
                .header("Authorization", "Bearer "+ setup.prop.getProperty("adminToken"))
                .when().get(path);

        return response;
    }

    // Search User
    public Response searchUser(){
        Setup setup = new Setup();
        try {
            setup.getEnvVar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String content = "application/json";
        String path = "/api/user/";
        Response response = given().contentType(content)
                .header("Authorization", "Bearer "+ setup.prop.getProperty("adminToken"))
                .when().get(path + setup.prop.getProperty("userId"));

        return response;
    }

    // Edit User Info
    public Response editUserInfo(UpdateUserModel updateUserModel) throws IOException {
        Setup setup = new Setup();
        setup.getEnvVar();

        String content = "application/json";
        String path = "/api/user/";
        Response response = given().contentType(content).body(updateUserModel)
                .header("Authorization", "Bearer "+ setup.prop.getProperty("adminToken"))
                .when().put(path + setup.prop.getProperty("userId"));

        return response;
    }

    public Response getItemList() throws IOException {
        Setup setup = new Setup();
        setup.getEnvVar();

        String content = "application/json";
        String path = "/api/costs";
        Response response = given().contentType(content)
                .header("Authorization", "Bearer "+ setup.prop.getProperty("userToken"))
                .when().get(path);
        return response;
    }

    public Response addItem(UpdateUserModel updateUserModel) throws IOException {
        Setup setup = new Setup();
        setup.getEnvVar();

        String content = "application/json";
        String path = "/api/costs";
        Response response = given().contentType(content).body(updateUserModel)
                .header("Authorization", "Bearer "+ setup.prop.getProperty("userToken"))
                .when().post(path);
        return response;
    }

    public Response updateItem(UserModel userModel ) throws IOException {
        Setup setup = new Setup();
        setup.getEnvVar();

        String content = "application/json";
        String path = "/api/costs/";
        Response response = given().contentType(content).body(userModel)
                .header("Authorization", "Bearer "+ setup.prop.getProperty("userToken"))
                .when().put(path + setup.prop.getProperty("productId"));
        return response;
    }

    public Response deleteItem() throws IOException {
        Setup setup = new Setup();
        setup.getEnvVar();

        String content = "application/json";
        String path = "/api/costs/";
        Response response = given().contentType(content)
                .header("Authorization", "Bearer "+ setup.prop.getProperty("userToken"))
                .when().delete(path + setup.prop.getProperty("productId"));
        return response;
    }

}
