package TestRunner;

import Classes.UpdateUserModel;
import Classes.UserController;
import Classes.UserModel;
import Utils.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserTestRunner {

    @Test(description = "Get all users list", priority = 1)
    public void getUserList(){
        UserController userController = new UserController();
        Response response = userController.userList();
        System.out.println(response.asString());
    }

    @Test(description = "Search user from user list", priority = 2)
    public void searchUser(){
        UserController userController = new UserController();
        Response response = userController.searchUser();
        System.out.println(response.asString());
    }


    @Test(description = "Edit User Info", priority = 3)
    public void editUserInfo() throws IOException {
        UserController userController = new UserController();
        UpdateUserModel updateUserModel = new UpdateUserModel();

        String firstName = "Hello";
        String phoneNumber = "01122334400";

        updateUserModel.setfName(firstName);
        updateUserModel.setPhn(phoneNumber);

        Response response = userController.editUserInfo(updateUserModel);
        System.out.println(response.asString());
    }

    @Test(description = "Add Items in List", priority = 4)
    public void addList() throws IOException, ConfigurationException {

        String item = "Mobile";
        String quantity = "1";
        String amount = "37000";
        String purDate = "03/28/2025";
        String month = "March";
        String remarks = "Honor X9C";

        UpdateUserModel updateUserModel = new UpdateUserModel();

        updateUserModel.setItem(item);
        updateUserModel.setQuantity(quantity);
        updateUserModel.setAmount(amount);
        updateUserModel.setPurchaseDate(purDate);
        updateUserModel.setMonth(month);
        updateUserModel.setRemarks(remarks);

        UserController userController = new UserController();
        Response response = userController.addItem(updateUserModel);
        System.out.println(response.asString());

        JsonPath jsonPath = response.jsonPath();
        String productId = jsonPath.get("_id");
        Utils.setEnvVar("productId",productId);

    }

    @Test(description = "Get Item List", priority = 5)
    public void getItemList() throws IOException {
        UserController userController = new UserController();
        Response response = userController.getItemList();
        System.out.println(response.asString());
    }

    @Test(description = "Edit Item Name", priority = 6)
    public void updateList() throws IOException {
        String itemName = "Smart Phone";

        UserModel userModel = new UserModel();

        userModel.setItem(itemName);

        UserController userController = new UserController();
        Response response = userController.updateItem(userModel);
        System.out.println(response.asString());
    }

    @Test(description = "Get Item List", priority = 7)
    public void deleteItem() throws IOException {
        UserController userController = new UserController();
        Response response = userController.deleteItem();
        System.out.println(response.asString());
    }

}
